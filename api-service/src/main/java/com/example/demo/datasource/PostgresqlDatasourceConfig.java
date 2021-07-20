package com.example.demo.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Lazy
@Configuration
@PropertySource(value = "classpath:postgresql.datasource.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.demo.repository.postgresql"},
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager"
)
public class PostgresqlDatasourceConfig {


    @Value("${postgresql.url}")
    private String url;

    @Value("${postgresql.user}")
    private String user;

    @Value("${postgresql.pass}")
    private String pass;

    @Value("${postgresql.driver}")
    private String driver;

    @Value("${hibernate.hbm2ddl.auto}")
    private String ddlAuto;

    @Value("${hibernate.dialect}")
    private String dialect;

    private Boolean showSql = true;

    @Bean(name = "postgresqlDataSource")
    public DataSource postgresqlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(pass);
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();
    }

    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresqlDataSource());
        em.setPackagesToScan(new String[]{"com.example.demo.repository.postgresql.entity"});

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        em.setJpaPropertyMap(properties);
        return em;
    }


    @Bean(name = "postgresqlTransactionManager")
    public PlatformTransactionManager postgresqlTransactionManager(@Qualifier("postgresqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(postgresqlEntityManagerFactory.getObject());
        return jpaTransactionManager;
    }

}
