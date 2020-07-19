package lesley.springframework.recipeapp.services.serviceImpl;

import lesley.springframework.recipeapp.domain.UnitOfMeasure;
import lesley.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import lesley.springframework.recipeapp.services.UnitOfMeasureService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return unitOfMeasureRepository.findById(id).orElse(null);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure obj) {
        return unitOfMeasureRepository.save(obj);
    }

    @Override
    public Set<UnitOfMeasure> getRecipes() {
        Set<UnitOfMeasure> uoms = new HashSet<>();
        unitOfMeasureRepository.findAll().forEach(uoms::add);
        return uoms;
    }
}
