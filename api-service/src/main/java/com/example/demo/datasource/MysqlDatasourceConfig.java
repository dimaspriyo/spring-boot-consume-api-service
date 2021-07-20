package com.example.demo.datasource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Lazy
@Configuration
@PropertySource(value = {"classpath:mysql.datasource.properties"})
@EnableJpaRepositories(
        basePackages = {"com.example.demo.repository.mysql"},
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlDatasourceConfig {

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.user}")
    private String user;

    @Value("${mysql.pass}")
    private String pass;

    @Value("${mysql.driver}")
    private String driver;

    @Value("${hibernate.hbm2ddl.auto}")
    private String ddlAuto;

    @Value("${hibernate.dialect}")
    private String dialect;

    private Boolean showSql = true;

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(pass);
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDataSource());
        em.setPackagesToScan(
                new String[]{"com.example.demo.repository.mysql.entity"});

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
//        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", true);

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);

        return em;

    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mysqlEntityManagerFactory.getObject());
        return transactionManager;
    }


}
