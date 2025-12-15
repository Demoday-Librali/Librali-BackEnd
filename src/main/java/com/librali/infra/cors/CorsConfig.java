package com.librali.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    //Permite dar as permissões ao cliente, oq ele realizar dentro da API direto pela web
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://librali-front-end-pi.vercel.app/") //URL ou LocalHost do Front end
                .allowedMethods("GET", "POST", "PUT","PATCH", "DELETE");
    }
}
