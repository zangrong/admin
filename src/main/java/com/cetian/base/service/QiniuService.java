/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: QiniuService.java 
 * @date 2018年3月29日 下午1:06:53 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cetian.base.util.HttpUtil;
import com.cetian.base.util.JacksonUtil;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;

/**
 * @ClassName:  QiniuService   
 * @Description:TODO
 * @date:  2018年3月29日 下午1:06:53
 * @author: zangrong
 * 
 */
@Service
public class QiniuService {
	
	private static final Logger log = LoggerFactory.getLogger(QiniuService.class);

	private String qiniuDomain = "http://p6ww5y82n.bkt.clouddn.com";
	
	private String accessKey = "Cp_13Mxmxzz8AO0nPkHJ1ECqUbEoD0wfir0TaPoh";
	
	private String secretKey = "NmJruOL7XbbvFfM8KlF3dygeXBbo1eut5bJ2F-3q";
	
	private String bucket1 = "image";
	
	
	public Map<String, String> getUploadToken() {
		// ...其他参数参考类注释
		Auth auth = Auth.create(accessKey, secretKey);
		String token = auth.uploadToken(bucket1);
		Map<String, String> map = new HashMap<>();
		map.put("uptoken", token);
		return map;
	}
	
	/**
	 * @Title: file
	 * @Description: 上传本地文件到七牛
	 * @param file
	 * @param key
	 * @param bucket
	 *            七牛名字空间，默认bucket1
	 * @param days
	 *            过期时间，不为null且大于0才设置
	 * @return: String
	 * @throws:
	 */
	public String upload(MultipartFile file) {
		String bucket = bucket1;
		String downloadUrl = null;
		String key = "image/" + UUID.randomUUID().toString();
		Integer days = null;
		Configuration cfg = new Configuration(Zone.zone2());
		// ...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		// ...生成上传凭证，然后准备上传
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		Auth auth = Auth.create(accessKey, secretKey);
		// 获取token时加入key，保证覆盖上传，下载时需要加时间戳，避免七牛缓存
		String token = auth.uploadToken(bucket, key);
		try {
			Response response = uploadManager.put(file.getInputStream(), key, token, null, null);
			
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			log.debug("key : [{}]", putRet.key);
			log.debug("hash : [{}]", putRet.hash);
			downloadUrl = String.format("%s/%s", qiniuDomain, putRet.key);
			// 如果days不为空且大于0，则设置过期时间
			if (days != null && days > 0) {
				deleteAfterDays(key, bucket, days);
			}
		} catch (QiniuException ex) {
			try {
				log.error("", ex);
				Response r = ex.response;
				if (r != null) {
					log.error("Qiniu Response : [{}]", r.toString());
					log.error("Qiniu Response : [{}]", r.bodyString());
				}
			} catch (QiniuException ex2) {
			}
		}catch (Exception e) {
			log.warn("", e);
		}
		return downloadUrl;
	}
	
	/**
	 * @Title: uploadLocalFile
	 * @Description: 上传本地文件到七牛
	 * @param localFilePath
	 * @param key
	 * @param bucket
	 *            七牛名字空间，默认bucket1
	 * @param days
	 *            过期时间，不为null且大于0才设置
	 * @return: String
	 * @throws:
	 */
	public String uploadLocalFile(String localFilePath, String key, String bucket, Integer days) {
		log.info(key);
		if (StringUtils.isBlank(bucket)) {
			bucket = bucket1;
		}
		String downloadUrl = null;
		Configuration cfg = new Configuration(Zone.zone0());
		// ...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		// ...生成上传凭证，然后准备上传
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		Auth auth = Auth.create(accessKey, secretKey);
		// 获取token时加入key，保证覆盖上传，下载时需要加时间戳，避免七牛缓存
		String upToken = auth.uploadToken(bucket, key);
		try {
			Response response = uploadManager.put(localFilePath, key, upToken);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			log.debug("key : [{}]", putRet.key);
			log.debug("hash : [{}]", putRet.hash);
			downloadUrl = qiniuDomain + "/@" + putRet.key;
			// 如果days不为空且大于0，则设置过期时间
			if (days != null && days > 0) {
				deleteAfterDays(key, bucket, days);
			}
		} catch (QiniuException ex) {
			try {
				log.error("", ex);
				Response r = ex.response;
				if (r != null) {
					log.error("Qiniu Response : [{}]", r.toString());
					log.error("Qiniu Response : [{}]", r.bodyString());
				}
			} catch (QiniuException ex2) {
			}
		}
		return downloadUrl;
	}
	
	/**
	 * https://developer.qiniu.com/kodo/api/1284/list
	 * 
	 * @Title: exist
	 * @Description: 判断七牛上某个 key 的文件是否存在
	 * @param key
	 * @param bucket
	 *            七牛名字空间 默认是bucket1
	 * @return: boolean
	 * @throws:
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean exist(String key, String bucket) {
		if (StringUtils.isBlank(bucket)) {
			bucket = bucket1;
		}
		boolean result = false;
		String host = Zone.zone0().getRsfHttp();
		String path = String.format("/list?bucket=%s&prefix=%s", bucket1, key);
		String url = host + path;
		Map<String, Object> headers = new HashMap<>();
		Auth auth = Auth.create(accessKey, secretKey);
		String accessToken = auth.signRequest(path, null, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		headers.put("Authorization", "QBox " + accessToken);
		String response = HttpUtil.doGet(url, null, headers);
		try {
			Map<String, Object> map = JacksonUtil.fromString(response, Map.class);
			List list = (List) map.get("items");
			log.info("map[{}] \n list[{}]", map, list);
			if (CollectionUtils.isNotEmpty(list)) {
				result = true;
			}
		} catch (Exception e) {
			log.info("qiniu exist response[{}]", response);
		}
		return result;
	}

	/**
	 * https://developer.qiniu.com/kodo/api/1732/update-file-lifecycle
	 * 
	 * @Title: deleteAfterDays
	 * @Description: 设置上传资源的有效期
	 * @param key
	 * @param bucket
	 * @param days
	 *            有效期，单位天
	 * @return: boolean
	 * @throws:
	 */
	public boolean deleteAfterDays(String key, String bucket, int days) {
		boolean result = true;
		String host = Zone.zone0().getRsHttp();
		String encodedEntryURI = UrlSafeBase64.encodeToString(bucket + ":" + key);
		String path = String.format("/deleteAfterDays/%s/%s", encodedEntryURI, days);
		String url = host + path;

		Map<String, Object> headers = new HashMap<>();
		Auth auth = Auth.create(accessKey, secretKey);
		String accessToken = auth.signRequest(path, null, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		headers.put("Authorization", "QBox " + accessToken);
		Map<String, Object> params = new HashMap<>();
		String response = HttpUtil.doPost(url, params, headers);
		log.info("qiniu deleteAfterDays response[{}]", response);
		return result;
	}
}
