package az.ingress.lesson04.mapper;

import az.ingress.lesson04.domain.FruitEntity;
import az.ingress.lesson04.dto.FruitRequestDto;
import az.ingress.lesson04.dto.FruitResponseDto;
import az.ingress.lesson04.repository.FruitRepository;
import org.springframework.stereotype.Component;

@Component
public class FruitMapperImpl implements FruitMapper {
    @Override
    public FruitResponseDto toRespDto(FruitEntity fruitEntity) {
        return FruitResponseDto
                .builder()
                .name(fruitEntity.getName())
                .amount(fruitEntity.getAmount())
                .price(fruitEntity.getPrice())
                .build();
    }

//    @Override
//    public FruitRequestDto toReqDto(FruitEntity fruitEntity) {
//        return FruitRequestDto
//                .builder()
//                .name(fruitEntity.getName())
//                .amount(fruitEntity.getAmount())
//                .price(fruitEntity.getPrice())
//                .build();
//    }

    @Override
    public FruitEntity toEntity(FruitRequestDto fruitRequestDto) {
        return FruitEntity.builder()
                .name(fruitRequestDto.getName())
                .amount(fruitRequestDto.getAmount())
                .price(fruitRequestDto.getPrice())
                .build();
    }
}
