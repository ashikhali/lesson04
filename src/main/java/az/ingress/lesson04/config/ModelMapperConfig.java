package az.ingress.lesson04.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {

    @Bean(name="ModelMapper1")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapper() {
        System.out.println("1--ModelMapper");
        return new ModelMapper();
    }

    @Bean(name="ModelMapper2")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapper1() {
        System.out.println("2--ModelMapper");
        return new ModelMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Test getTest() {
        System.out.println("Creating new instance of Test class");
        return new Test();
    }


}
