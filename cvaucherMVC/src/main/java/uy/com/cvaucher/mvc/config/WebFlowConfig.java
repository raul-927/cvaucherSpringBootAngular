package uy.com.cvaucher.mvc.config;

import java.util.Collections;
import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.mvc.view.AjaxUrlBasedViewResolver;
import org.springframework.webflow.mvc.view.FlowAjaxTiles3View;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@EnableWebMvc
@Configuration
//@ComponentScan("uy.com.cvaucher")
public class WebFlowConfig extends AbstractFlowConfiguration implements WebMvcConfigurer {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
	public FlowExecutor flowExecutor() {
	    return getFlowExecutorBuilder(flowRegistry()).build();
	}
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
	   
		return getFlowDefinitionRegistryBuilder().setFlowBuilderServices(flowBuilderServices())
			
	    		.setBasePath("/WEB-INF/flows")
	            .addFlowLocationPattern("/**/*-flow.xml")
	            .build();
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true).setValidator(validator()).build();
	}

	@Bean
	public  MvcViewFactoryCreator mvcViewFactoryCreator() {
		 MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
	     factoryCreator.setViewResolvers(Collections.singletonList(tilesViewResolver()));
	     factoryCreator.setUseSpringBeanBinding(true);
	     return factoryCreator;
	}
	
	@Bean
	public ViewResolver tilesViewResolver() {
		AjaxUrlBasedViewResolver ajaxUrlBasedViewResolver = new AjaxUrlBasedViewResolver();
		ajaxUrlBasedViewResolver.setViewClass(FlowAjaxTiles3View.class);
		return ajaxUrlBasedViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		String definitions ="/WEB-INF/views/**/views.xml";
		tilesConfigurer.setDefinitions(definitions );
		return tilesConfigurer;
		
	}
	
//	@Bean
//	public InternalResourceViewResolver internalResourceViewResolver() {
//		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//		internalResourceViewResolver.setViewClass(JstlView.class);
//		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//		internalResourceViewResolver.setSuffix(".jsp");
//		return internalResourceViewResolver;
//	}
	
	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter flowHandlerAdapter= new FlowHandlerAdapter();
		flowHandlerAdapter.setFlowExecutor(flowExecutor());
		
		return flowHandlerAdapter;
	}
	
	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
		flowHandlerMapping.setFlowRegistry(flowRegistry());
		return flowHandlerMapping;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		return  localValidatorFactoryBean;
	}
	
	@Bean
	public DefaultConversionService defaultConversionService() {
		DefaultConversionService defaultConversionService = new DefaultConversionService();
		
		return defaultConversionService;
	}
	
}
