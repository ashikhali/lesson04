package az.ingress.lesson04.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FruitResponseDto {

    private Long id;

    private String name;

    private String amount;

    private Double price;
}

