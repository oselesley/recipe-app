package lesley.springframework.recipeapp.repositories;

import lesley.springframework.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT{
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findUnitOfMeasureByUom() {
        Optional<UnitOfMeasure> uom =  unitOfMeasureRepository.findUnitOfMeasureByUom("Dash");
        assertEquals("Dash", uom.get().getUom());
    }

    @Test
    void findUnitOfMeasureByUomCup() {
        Optional<UnitOfMeasure> uom =  unitOfMeasureRepository.findUnitOfMeasureByUom("Cup");
        assertEquals("Cup", uom.get().getUom());
    }
}