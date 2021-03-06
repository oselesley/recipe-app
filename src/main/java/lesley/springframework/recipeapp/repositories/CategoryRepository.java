package lesley.springframework.recipeapp.repositories;

import lesley.springframework.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Optional<Category> findCategoriesByCategoryName(String name);
}
