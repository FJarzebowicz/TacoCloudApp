package org.example.repository;

import org.example.model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngridientRepositry extends CrudRepository<Ingredients, String> {

}
