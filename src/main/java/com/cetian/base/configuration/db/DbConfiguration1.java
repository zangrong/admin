/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: MysqlConfiguration1.java 
 * @date 2017年2月27日 下午3:33:52 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.db;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cetian.module.admin.dao.AdminDao;
import com.cetian.module.admin.entity.Admin;
import com.cetian.module.exam.dao.PaperDao;
import com.cetian.module.exam.entity.Paper;
import com.cetian.module.library.dao.QuestionDao;
import com.cetian.module.library.entity.Question;
import com.cetian.module.system.dao.ModuleDao;
import com.cetian.module.system.entity.Module;

/**
 * 
 * @ClassName: DbConfiguration1
 * @Description: mysql db1
 * @date: 2017年3月29日 上午10:32:31
 * @author: zangrong
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {
		AdminDao.class,ModuleDao.class,QuestionDao.class,PaperDao.class }, entityManagerFactoryRef = DbConfiguration1.EMF1, transactionManagerRef = DbConfiguration1.TM1)
public class DbConfiguration1 {

	public static final String DB1 = "db1";
	public static final String EMF1 = "entityManagerFactory1";
	public static final String TM1 = "transactionManager1";

	@Primary
	@Bean(name = DB1)
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = EMF1)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory1(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource1())
				.packages(Admin.class, Module.class, Question.class, Paper.class)
				.persistenceUnit(DB1).build();
		return em;
	}

	@Primary
	@Bean(name = TM1)
	PlatformTransactionManager transactionManager1(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactory1(builder).getObject());
	}
}
