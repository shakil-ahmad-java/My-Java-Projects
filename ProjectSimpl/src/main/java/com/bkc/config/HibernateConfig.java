package com.bkc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:resources/application.properties"})
public class HibernateConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		sf.setPackagesToScan(new String[] {"com.bkc.model"});
		sf.setHibernateProperties(hibernateProperties());
		return sf;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		ds.setUrl(environment.getRequiredProperty("jdbc.url"));
		ds.setUsername(environment.getRequiredProperty("jdbc.username"));
		ds.setPassword(environment.getRequiredProperty("jdbc.password"));
		return ds;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(s);
		return tx;
	}
}
