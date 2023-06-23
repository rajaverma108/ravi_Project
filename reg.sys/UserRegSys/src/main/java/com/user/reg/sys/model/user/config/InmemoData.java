//package com.user.reg.sys.model.user.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactoryBeanForUserData",
//        basePackages = {"com.user.reg.sys.model.user.userrepo"},
//        transactionManagerRef = "transactionManagerForUserData"
//)
//public class InmemoData {
//    @Autowired
//    private Environment environment;
//
//    //dataSource
//    @Primary
//    @Bean(name="Inmemodb")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        //dataSource.setUrl(environment.getProperty("jdbc:postgresql://localhost:5432/postgres"));
//        //dataSource.setDriverClassName(environment.getProperty("org.postgresql.Driver"));
//
//        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
//        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
//
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//        return dataSource;
//
//    }
//
//    //EntityManger
//    @Primary
//    @Bean(name = "entityManagerFactoryBeanForUserData")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean bean =
//                new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource());
//
//        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(jpaVendorAdapter);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        map.put("spring.jpa.show-sql", "true");
//        map.put("spring.jpa.hibernate.ddl-auto", "update");
//        bean.setJpaPropertyMap(map);
//        bean.setPackagesToScan("com.user.reg.sys.model.user.entities");
//        return bean;
//    }
//
//    //TxnManger
//    @Bean(name = "transactionManagerForUserData")
//    @Primary
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return manager;
//
//    }
//
//}
