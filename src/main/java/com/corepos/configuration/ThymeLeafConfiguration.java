package com.corepos.configuration;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;

public class ThymeLeafConfiguration {

	@Bean
    public ServletContextTemplateResolver layoutTemplateResolverServlet() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        Set<IDialect> dialects = new HashSet<IDialect>();
        dialects.add(new LayoutDialect());
        dialects.add(new SpringSecurityDialect());
        engine.setAdditionalDialects(dialects);
        LinkedHashSet<ITemplateResolver> templateResolvers = new LinkedHashSet<ITemplateResolver>(2);
        templateResolvers.add(layoutTemplateResolverServlet());
        engine.setTemplateResolvers(templateResolvers);
        return engine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCache(false);
        return resolver;
    }
	
}
