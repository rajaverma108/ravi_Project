//package com.user.reg.sys.model.faculty.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
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
//        entityManagerFactoryRef = "SecondentityManagerFactoryBean",
//        basePackages = {"com.user.reg.sys.model.faculty.facultyrepo"},
//        transactionManagerRef = "SecondtransectionManager"
//)
//public class PostgresDb {
//
//    @Autowired
//    private Environment environment;
//
//    //DataSource
//    @Bean(name = "SecondDataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource source = new DriverManagerDataSource();
//        source.setUrl(environment.getProperty("Second.datasource.url"));
//        source.setUsername(environment.getProperty("Second.datasource.username"));
//        source.setPassword(environment.getProperty("Second.datasource.password"));
//        source.setDriverClassName(environment.getProperty("Second.datasource.driver-class-name"));
//
//        return source;
//    }
//
//    //EntityManager
//
//    @Bean(name = "SecondentityManagerFactoryBean")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//
//        bean.setDataSource(dataSource());
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(adapter);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("Second.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        map.put("hibernate.show_sql", "true");
//       map.put("Second.jpa.hibernate.ddl-auto", "update");
//        bean.setJpaPropertyMap(map);
//        bean.setPackagesToScan("com.user.reg.sys.model.faculty.entities");
//        return bean;
//    }
//
//    //PlateformTransectionManager
//    @Bean(name = "SecondtransectionManager")
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//}
