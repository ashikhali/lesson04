package az.ingress.lesson04.dto;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "amin")
public class Student {

    private String firstName;
    private String lastName;
    private Integer age;

    List<String> lessons;

    Map<String, Integer> marks;
    Map<String, Lessons> grades;
}

