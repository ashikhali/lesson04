package az.ingress.lesson04.services;

import az.ingress.lesson04.dto.Student;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesExample {

    @Value("${amin.first-name}")
    private String firstName;

    @Autowired
    private Student student;

    @PostConstruct
    public void print(){
        System.out.println("The value of first name is: " + firstName);
        System.out.println("The value of student " + student);
    }

}
