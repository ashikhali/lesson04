package az.ingress.lesson04.mapper;

import az.ingress.lesson04.domain.FruitEntity;
import az.ingress.lesson04.dto.FruitRequestDto;
import az.ingress.lesson04.dto.FruitResponseDto;
import az.ingress.lesson04.repository.FruitRepository;

public interface FruitMapper {

    FruitResponseDto toRespDto(FruitEntity fruitEntity);
//    FruitRequestDto toReqDto(FruitEntity fruitEntity);
    FruitEntity toEntity(FruitRequestDto fruitRequestDto);
}
