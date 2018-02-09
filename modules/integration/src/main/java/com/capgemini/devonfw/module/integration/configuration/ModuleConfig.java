package com.capgemini.devonfw.module.integration.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

/**
 * Spring Boot auto-configuration for Integration module
 *
 */
@Configuration("integration")
@EnableIntegration
@ComponentScan(basePackages = { "com.capgemini.devonfw.module.integration" })
@IntegrationComponentScan(basePackages = { "com.capgemini.devonfw.module.integration.common" })
public class ModuleConfig {

}
