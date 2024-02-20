package az.ingress.lesson04.rest;


import az.ingress.lesson04.dto.FruitDto;
import az.ingress.lesson04.dto.FruitRequestDto;
import az.ingress.lesson04.dto.FruitResponseDto;
import az.ingress.lesson04.services.FruitService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/fruits")
public class FruitApi {

    public final FruitService fruitService;

    List<FruitDto> fruitDtoList = new ArrayList<>();

    @GetMapping
    public List<FruitResponseDto> getAllFruits() {
        return fruitService.allList();
    }

    @GetMapping("/sublist")
    public List<FruitResponseDto> getSubListFruits(@RequestParam(value = "from", required = false,
            defaultValue = "0") Integer from,
                                                   @RequestParam(value = "to", required = false) Integer to) {
        return fruitService.list(from, to);
    }

    @GetMapping("/{id}")
    public FruitResponseDto getFruitById(@PathVariable Long id) {
        return fruitService.get(id);
    }


    public FruitApi(FruitService fruitService) {
        System.out.println("Injected instance of fruit service " + fruitService);
        this.fruitService = fruitService;
    }

    @PostMapping
    public FruitResponseDto createFruit(@Validated @RequestBody FruitRequestDto fruit) {
        return fruitService.create(fruit);
    }

    @PutMapping("/{id}")
    public FruitResponseDto updateFruit(@PathVariable Long id,
                              @Validated @RequestBody FruitRequestDto fruit) {
        return fruitService.update(id, fruit);
    }

    @DeleteMapping("/{id}")
    public void deleteFruit(@PathVariable Long id) {
        fruitService.delete(id);
    }
}
