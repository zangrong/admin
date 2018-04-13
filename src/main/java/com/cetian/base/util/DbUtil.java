/**
 * @Copyright: 2017 720yun.com Inc. All rights reserved. 
 * @Title: DbUtil.java 
 * @date 2017年5月4日 上午10:56:30 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName: DbUtil
 * @Description: 数据库操作工具
 * @date: 2017年5月4日 上午10:56:30
 * @author: zangrong
 * 
 */
public class DbUtil {

	/**
	 * 
	 * @Title: close
	 * @Description: 关闭要关闭的
	 * @param rs
	 * @param stmt
	 * @param con
	 * @return: void
	 * @throws:
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
		}

	}
}
