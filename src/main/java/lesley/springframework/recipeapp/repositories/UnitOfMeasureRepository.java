package lesley.springframework.recipeapp.repositories;

import lesley.springframework.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    public Optional<UnitOfMeasure> findUnitOfMeasureByUom (String uom);
}
