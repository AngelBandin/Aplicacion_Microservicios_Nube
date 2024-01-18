package gal.usc.grei.cn.serviciopago.config;
import gal.usc.grei.cn.serviciopago.modelo.Compra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Compra compra(){
        return new Compra();
    }
}
