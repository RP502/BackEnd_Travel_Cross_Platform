package com.java.travel_cross_platform_be.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class PersistenceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.java.travel_cross_platform_be.Model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPersistenceUnitName("default");
        em.setJpaPropertyMap(Map.of(
            "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect",
            "hibernate.hbm2ddl.auto", "update"
        ));
        em.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        return em;
    }
}
