/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: YunPhysicalNamingStrategyImpl.java 
 * @date 2017年3月2日 下午5:11:01 
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
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @ClassName: YunPhysicalNamingStrategyImpl
 * @Description: 数据库强制命名方式，目前暂不使用
 * @date: 2017年3月2日 下午5:11:01
 * @author: zangrong
 * @deprecated
 */
public class ZeusPhysicalNamingStrategyImpl implements PhysicalNamingStrategy {
	private static final Map<String, String> ABBREVIATIONS = buildAbbreviationMap();

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// Acme naming standards do not apply to catalog names
		return name;
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		// Acme naming standards do not apply to schema names
		return null;
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final List<String> parts = splitAndReplace(name.getText());
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(join(parts), name.isQuoted());
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final LinkedList<String> parts = splitAndReplace(name.getText());
		// Acme Corp says all sequences should end with _seq
		if (!"seq".equalsIgnoreCase(parts.getLast())) {
			parts.add("seq");
		}
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(join(parts), name.isQuoted());
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		final List<String> parts = splitAndReplace(name.getText());
		return jdbcEnvironment.getIdentifierHelper().toIdentifier(join(parts), name.isQuoted());
	}

	private static Map<String, String> buildAbbreviationMap() {
		TreeMap<String, String> abbreviationMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		
		return abbreviationMap;
	}

	private LinkedList<String> splitAndReplace(String name) {
		LinkedList<String> result = new LinkedList<>();
		for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
			if (part == null || part.trim().isEmpty()) {
				// skip null and space
				continue;
			}
			part = applyAbbreviationReplacement(part);
			result.add(part.toLowerCase(Locale.ROOT));
		}
		return result;
	}

	private String applyAbbreviationReplacement(String word) {
		if (ABBREVIATIONS.containsKey(word)) {
			return ABBREVIATIONS.get(word);
		}

		return word;
	}

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
