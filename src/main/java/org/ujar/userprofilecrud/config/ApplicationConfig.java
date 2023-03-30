package org.ujar.userprofilecrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"org.ujar.userprofilecrud.repository"})
@EnableJpaAuditing
@EnableTransactionManagement
class ApplicationConfig {

}
