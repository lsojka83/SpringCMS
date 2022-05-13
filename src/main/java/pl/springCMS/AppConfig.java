package pl.springCMS;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pl.springCMS")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
    }

//    @Bean
//    public Converter authorConverter() {
//        return new AuthorConverter();
//    }
}
