package it.fucarino.pizzeria.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fucarino.pizzeria.model.Pizza;
import it.fucarino.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	
	@GetMapping("/pizze")
	public String index(Model model) {
		
	    List<Pizza> pizza = repository.findAll();
		
		model.addAttribute("list", pizza);
		
	
		return"/pizze/index";
	}
	
	@GetMapping("/pizze/pizza/{id}")
	public String pizza(@PathVariable("id") Integer pizzaId,  Model model) {
		
		
		model.addAttribute("pizza", repository.getReferenceById(pizzaId));
		
		return"/pizze/pizza";
	}
}
