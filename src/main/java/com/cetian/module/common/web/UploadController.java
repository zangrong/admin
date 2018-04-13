/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: UploadController.java 
 * @date 2018年4月9日 上午12:10:55 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.common.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cetian.module.common.service.UploadService;

/**
 * @ClassName:  UploadController   
 * @Description:TODO
 * @date:  2018年4月9日 上午12:10:55
 * @author: zangrong
 * 
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);

	@Autowired
	private UploadService uploadService;
	
	/**
	 * @return 
	 * @Title: image   
	 * @Description: 上传图片，用七牛      
	 * @return: void      
	 * @throws IOException 
	 * @throws:
	 */
	@RequestMapping("/image")
	public void image(@RequestParam("upload") MultipartFile file, @RequestParam("CKEditorFuncNum") String callback,
			HttpServletResponse response) throws IOException {
		log.warn("image file [{}]", file);
		
		String url = uploadService.image(file);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		String script = "window.parent.CKEDITOR.tools.callFunction(%s,'%s','')";
        out.println(String.format(script, callback, url));
        out.println("</script>");
        out.flush();
        out.close();
	}
	
	
}
