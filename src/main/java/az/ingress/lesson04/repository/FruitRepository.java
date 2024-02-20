package az.ingress.lesson04.repository;

import az.ingress.lesson04.domain.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<FruitEntity, Long> {
}
