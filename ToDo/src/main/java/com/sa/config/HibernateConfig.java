package com.sa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:resources/application.properties" })
public class HibernateConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		sf.setPackagesToScan(new String[] {"com.sa.model"});
		sf.setHibernateProperties(hibernateProperties());
		return sf;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));
		return ds;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager txManager(SessionFactory sf) {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sf);
		return tx;
	}
}
