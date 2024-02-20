package az.ingress.lesson04.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FruitDto {

    @NotBlank
    private String name;

    @NotNull
    private String amount;

    @NotNull
    private Double price;
}
