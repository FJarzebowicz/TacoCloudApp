package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Ingredients;
import org.example.model.Order;
import org.example.model.Taco;
import org.example.repository.IngridientRepositry;
import org.example.repository.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    private final IngridientRepositry ingredientsRepository;
    private TacoRepository designRepo;
    @Autowired
    public DesignTacoController(IngridientRepositry ingredientsRepository, TacoRepository designRepo) {
        this.ingredientsRepository = ingredientsRepository;
        this.designRepo = designRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(i -> ingredients.add(i));
        Ingredients.Type[] types = Ingredients.Type.values();
        for (Ingredients.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";

    }
    private List<Ingredients> filterByType(
            List<Ingredients> ingridients, Ingredients.Type type) {
        return ingridients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
   @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
    @PostMapping
    public String processDesign(@Valid Taco design, @ModelAttribute Order order, Errors errors) {
        if(errors.hasErrors()) {
            return "design";
        }
        Taco saved = designRepo.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }
}
