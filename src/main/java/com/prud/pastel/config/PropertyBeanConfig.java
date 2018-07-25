/**
 * 
 */
package com.prud.pastel.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author megha
 *
 */
@Configuration
public class PropertyBeanConfig {

	@Bean(name = "pasToPastelMapping")
	public static PropertiesFactoryBean pasToPastelMapping() {
	        PropertiesFactoryBean bean = new PropertiesFactoryBean();
	        bean.setLocation(new ClassPathResource(
	                "PasToPastelMapping.properties"));
	        return bean;
	}
}
