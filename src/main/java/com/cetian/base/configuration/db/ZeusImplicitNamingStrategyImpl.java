/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: YunImplicitNamingStrategyImpl.java 
 * @date 2017年3月5日 下午8:31:51 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.db;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;
import org.hibernate.boot.model.naming.ImplicitIdentifierColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

/**
 * @ClassName: YunImplicitNamingStrategyImpl
 * @Description: 数据表默认命名方式，如果指定了就用指定名，如果没指定就用默认命名方式
 * @date: 2017年3月5日 下午8:31:51
 * @author: zangrong
 * 
 */
public class ZeusImplicitNamingStrategyImpl extends ImplicitNamingStrategyJpaCompliantImpl
		implements ImplicitNamingStrategy {

	private static final long serialVersionUID = -9075205680387317517L;
	private static final Map<String, String> ABBREVIATIONS = buildAbbreviationMap();// 缩略词列表
	private static final String TABLE_PREFIX = "ct";// 默认表名前缀

	@Override
	public Identifier determineIdentifierColumnName(ImplicitIdentifierColumnNameSource source) {
		Identifier identifier = super.determineIdentifierColumnName(source);
		return identifier;
	}

	/**
	 * 目前主要是重写普通列名的implicit默认命名方式
	 */
	@Override
	public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
		String fullPath = source.getAttributePath().getFullPath();
		LinkedList<String> parts = splitAndReplace(fullPath);
		String text = join(parts);
		Identifier identifier = toIdentifier(text, source.getBuildingContext());
		return identifier;
	}

	/**
	 * 重新表的命名规则，如果没有给实体设置表名，则默认采用yun_实体下划线名，实际中应该应用不多
	 */
	@Override
	public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
		Identifier identifier = super.determinePrimaryTableName(source);
		String tableName = identifier.getText();
		LinkedList<String> parts = splitAndReplace(tableName);
		parts.add(0, TABLE_PREFIX);
		String text = join(parts);
		identifier = toIdentifier(text, source.getBuildingContext());
		return identifier;
	}

	/**
	 * 
	 * @Title: buildAbbreviationMap
	 * @Description: 创建一个缩略词列表，如果有的话，目前暂时不需要
	 * @param: @return
	 * @return: Map<String,String>
	 * @throws:
	 */
	private static Map<String, String> buildAbbreviationMap() {
		TreeMap<String, String> abbreviationMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		return abbreviationMap;
	}

	/**
	 * 
	 * @Title: splitAndReplace
	 * @Description: 把驼峰命名的词拆分成多个小写单词列表
	 * @param: @param
	 *             name
	 * @param: @return
	 * @return: LinkedList<String>
	 * @throws:
	 */
	private LinkedList<String> splitAndReplace(String name) {
		LinkedList<String> result = new LinkedList<>();
		for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
			if (part == null || part.trim().isEmpty()) {
				continue;
			}
			part = applyAbbreviationReplacement(part);
			result.add(part.toLowerCase(Locale.ROOT));
		}
		return result;
	}

	/**
	 * 
	 * @Title: applyAbbreviationReplacement
	 * @Description: 缩写替换，目前暂时用不到
	 * @param: @param
	 *             word
	 * @param: @return
	 * @return: String
	 * @throws:
	 */
	private String applyAbbreviationReplacement(String word) {
		if (ABBREVIATIONS.containsKey(word)) {
			return ABBREVIATIONS.get(word);
		}
		return word;
	}

	/**
	 * 
	 * @Title: join
	 * @Description: 把单词列表通过_合在一起，形成最终的名字
	 * @param: @param
	 *             parts
	 * @param: @return
	 * @return: String
	 * @throws:
	 */
	private String join(List<String> parts) {
		boolean firstPass = true;
		String separator = "";
		StringBuilder joined = new StringBuilder();
		for (String part : parts) {
			joined.append(separator).append(part);
			if (firstPass) {
				firstPass = false;
				separator = "_";
			}
		}
		return joined.toString();
	}

}
