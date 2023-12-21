package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    // final dersek ctor'e  @AutoWired eklememize gerek yok.
    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }


    @Override
    public Fruit delete(long id) {
        Fruit selectedId=getById(id);
        fruitRepository.delete(selectedId);
        return selectedId ;
    }

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> fruit=fruitRepository.findById(id);
        if(fruit.isPresent()){
            return fruit.get();
        }
        throw new PlantException("this id not exist"+id, HttpStatus.NOT_FOUND);
    }
}
