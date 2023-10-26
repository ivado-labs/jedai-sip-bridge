package org.chusj.crhsj.sip_bridge.config;

import static org.chusj.crhsj.sip_bridge.SipBridge.springLiquibase;


import com.zaxxer.hikari.HikariDataSource;
import java.util.Map;
import java.util.Objects;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages ="org.chusj.crhsj.sip_bridge.adt" ,
    entityManagerFactoryRef = "adtEntityManagerFactory",transactionManagerRef = "adtTransactionManager")
@EnableTransactionManagement
public class AdtDataSourceConfiguration {
  @Bean
  @ConfigurationProperties("adt.datasource")
  public DataSourceProperties adtDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @ConfigurationProperties("adt.datasource.configuration")
  public HikariDataSource adtDataSource() {
    return adtDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "adt.datasource.liquibase")
  public LiquibaseProperties adtLiquibaseProperties() {
    return new LiquibaseProperties();
  }

  @Bean
  public SpringLiquibase adtLiquibase() {
    return springLiquibase(adtDataSource(), adtLiquibaseProperties());
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean adtEntityManagerFactory(
      EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
    return entityManagerFactoryBuilder
        .dataSource(adtDataSource())
        .packages("org.chusj.crhsj.sip_bridge.adt")
        .persistenceUnit("adt")
        .build();
  }
  @Bean
  public PlatformTransactionManager adtTransactionManager(
      final @Qualifier("adtEntityManagerFactory") LocalContainerEntityManagerFactoryBean adtEntityManagerFactory) {
    return new JpaTransactionManager(Objects.requireNonNull(adtEntityManagerFactory.getObject()));
  }
}
