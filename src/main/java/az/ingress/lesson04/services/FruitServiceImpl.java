package az.ingress.lesson04.services;

import az.ingress.lesson04.domain.FruitEntity;
import az.ingress.lesson04.dto.FruitDto;
import az.ingress.lesson04.dto.FruitRequestDto;
import az.ingress.lesson04.dto.FruitResponseDto;
import az.ingress.lesson04.mapper.FruitMapperImpl;
import az.ingress.lesson04.repository.FruitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    private final ModelMapper modelMapper;

    public FruitServiceImpl(FruitRepository fruitRepository, @Qualifier("ModelMapper1") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        System.out.println("Created instance of FruitServiceImpl " + this);
        this.fruitRepository = fruitRepository;
    }


    @Override
    public List<FruitResponseDto> allList() {
        return fruitRepository.findAll()
                .stream()
                .map(fruitEntity -> modelMapper.map(fruitEntity, FruitResponseDto.class))
                .toList();
    }

    @Override
    public List<FruitResponseDto> list(Integer from, Integer to) {
        return fruitRepository.findAll()
                .stream()
                .map(fruitEntity -> modelMapper.map(fruitEntity, FruitResponseDto.class))
                .toList();
    }

    @Override
    public FruitResponseDto get(Long id) {
        return fruitRepository.findById(id)
                .map(fruitEntity -> modelMapper.map(fruitEntity, FruitResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Fruit not found"));
    }

    private FruitResponseDto convertToDto(FruitEntity fruitEntity) {
        return new FruitResponseDto(fruitEntity.getId(), fruitEntity.getName(), fruitEntity.getAmount(), fruitEntity.getPrice());
    }

    @Override
    public FruitResponseDto create(FruitRequestDto fruitDto) {
        FruitEntity fruit = modelMapper.map(fruitDto, FruitEntity.class);
        return modelMapper.map(fruitRepository.save(fruit), FruitResponseDto.class);
    }

    @Override
    public FruitResponseDto update(Long id, FruitRequestDto fruitDto) {
        FruitEntity fruitEntity = modelMapper.map(fruitDto, FruitEntity.class);
        fruitEntity.setId(id);
        fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit with %d not found ".formatted(id)));
        return modelMapper.map(fruitRepository.save(fruitEntity), FruitResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        FruitEntity fruitEntity = fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));
        fruitRepository.delete(fruitEntity);
    }
}
