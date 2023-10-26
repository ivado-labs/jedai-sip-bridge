package org.chusj.crhsj.sip_bridge.config;

import static org.chusj.crhsj.sip_bridge.SipBridge.springLiquibase;


import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import java.util.Objects;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "org.chusj.crhsj.sip_bridge.sip",
    entityManagerFactoryRef = "sipEntityManagerFactory", transactionManagerRef = "sipTransactionManager")
@EnableTransactionManagement
public class SipDataSourceConfiguration {
  @Primary
  @Bean
  @ConfigurationProperties("sip.datasource")
  public DataSourceProperties sipDataSourceProperties() {
    return new DataSourceProperties();
  }


  @Primary
  @Bean
  @ConfigurationProperties("sip.datasource.configuration")
  public HikariDataSource sipDataSource() {
    return sipDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "sip.datasource.liquibase")
  public LiquibaseProperties sipLiquibaseProperties() {
    return new LiquibaseProperties();
  }

  @Bean
  public SpringLiquibase sipLiquibase() {
    return springLiquibase(sipDataSource(), sipLiquibaseProperties());
  }


  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean sipEntityManagerFactory(
      EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
    return entityManagerFactoryBuilder
        .dataSource(sipDataSource())
        .properties(
            Map.of(
            "hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy",
            "hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy"))
        .packages("org.chusj.crhsj.sip_bridge.sip")
        .persistenceUnit("sip")
        .build();
  }

  @Primary
  @Bean
  public PlatformTransactionManager sipTransactionManager(
      final LocalContainerEntityManagerFactoryBean sipEntityManagerFactory) {
    return new JpaTransactionManager(Objects.requireNonNull(sipEntityManagerFactory.getObject()));
  }
}
