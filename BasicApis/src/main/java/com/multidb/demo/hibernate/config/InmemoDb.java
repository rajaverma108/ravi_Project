package com.multidb.demo.hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryBean",
        basePackages = {"com.multidb.demo.hibernate.repo"},
        transactionManagerRef = "transectionManager"
)
public class InmemoDb {
    @Autowired
    private Environment environment;

    //DataSource
    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(environment.getProperty("spring.datasource.url"));
        source.setUsername(environment.getProperty("spring.datasource.username"));
        source.setPassword(environment.getProperty("spring.datasource.password"));
        source.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));

        return source;
    }

    //EntityManager

    @Bean(name = "entityManagerFactoryBean")
    @Primary

    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

        bean.setDataSource(dataSource());
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String, String> map = new HashMap<>();
        map.put("spring.jpa.database-platform", "org.hibernate.dialect.H2Dialect");
        map.put("hibernate.show_sql", "true");
        map.put("hibernate.hbm2ddl.auto", "update");
        bean.setJpaPropertyMap(map);
        bean.setPackagesToScan("com.multidb.demo.hibernate.entities");
        return bean;
    }

    //PlateformTransectionManager
    @Primary
    @Bean(name = "transectionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
