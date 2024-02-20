package az.ingress.lesson04.services;

import az.ingress.lesson04.dto.FruitDto;
import az.ingress.lesson04.dto.FruitRequestDto;
import az.ingress.lesson04.dto.FruitResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FruitService {

    List<FruitResponseDto> allList();

    List<FruitResponseDto> list(Integer from, Integer to);

    FruitResponseDto get(Long id);


    FruitResponseDto create(FruitRequestDto fruitDto);


    FruitResponseDto update(Long id, FruitRequestDto fruitDto);

    void delete(Long id);

}
