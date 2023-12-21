package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit>getAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/desc")
    public List<Fruit>getDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse getById(@Positive @PathVariable long id){
      Fruit byId =fruitService.getById(id);
        return new FruitResponse("basarili",byId);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @PutMapping
    public Fruit update(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id){
        return fruitService.delete(id);
    }
}
