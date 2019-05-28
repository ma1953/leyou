package com.leyou.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration  configuration =new CorsConfiguration();
              configuration.addAllowedOrigin("http://manage.leyou.com");
              configuration.setAllowCredentials(true);
              configuration.addAllowedMethod("OPTIONS");
              configuration.addAllowedMethod("HEAD");
              configuration.addAllowedMethod("GET");
              configuration.addAllowedMethod("PUT");
              configuration.addAllowedMethod("POST");
              configuration.addAllowedMethod("DELETE");
              configuration.addAllowedMethod("PATCH");
              configuration.addAllowedHeader("");
        UrlBasedCorsConfigurationSource  configurationSource=new UrlBasedCorsConfigurationSource();
           configurationSource.registerCorsConfiguration("/**",configuration);
           return  new CorsFilter(configurationSource);
    }
}
