package id.promoanda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.Locale;

/**
 * Created by tsagita on 13/3/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "id.promoanda")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Bean(name = "appProperties")
    public PropertiesFactoryBean appProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("id/promoanda/config/app.properties"));
        return bean;
    }

    @Bean(name="messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource properties = new ResourceBundleMessageSource();
        properties.setBasename("messages");
        properties.setDefaultEncoding("UTF-8");

        return properties;
    }

    @Bean(name = "localeResolver")
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("in", "ID"));

        return resolver;
    }

    @Bean(name = "localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");

        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true)
                .favorPathExtension(true)
                .mediaType("html", MediaType.TEXT_HTML);
    }

    @Bean(name = "tilesViewResolver")
    public TilesViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }

    @Bean(name = "tilesConfigurer")
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles-defs/templates.xml", "/WEB-INF/tiles-defs/definitions.xml");

        return tilesConfigurer;
    }

}
