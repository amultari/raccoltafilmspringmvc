package it.prova.raccoltafilmspringmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.prova.raccoltafilmspringmvc.repository")
public class PersistenceJPAConfig {

}
