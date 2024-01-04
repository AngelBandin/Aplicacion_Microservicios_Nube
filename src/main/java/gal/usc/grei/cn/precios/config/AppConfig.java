package gal.usc.grei.cn.precios.config;

import gal.usc.grei.cn.precios.modelo.Compra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}
    @Bean
    public Compra compra(){
        return new Compra();
    }
}
