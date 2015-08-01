package com.vapepos.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories
public class JpaConfiguration {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
		.setName("TEST_DB")
		.setType(EmbeddedDatabaseType.HSQL)
				
				/* Schemas */
				.addScript("classpath:/sql/tables/UsersTable.sql")
				.addScript("classpath:/sql/tables/RolesTable.sql")
				
				/* Test Data */
				.addScript("classpath:/sql/data/users_sample_data.sql")
				.addScript("classpath:/sql/data/roles_sample_data.sql")
				.build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.vapepos.domain" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		em.setJpaProperties(properties);
		return em;
	}
	
}
