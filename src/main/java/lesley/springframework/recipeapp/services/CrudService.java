package lesley.springframework.recipeapp.services;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CrudService<T> {
    T findById (Long id);

    T save (T obj);

    Set<T> getRecipes();
}
