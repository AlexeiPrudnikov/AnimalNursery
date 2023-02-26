package Repositories;

import Models.Animal;

import java.util.List;

public interface IRepo {
    public List<Animal> getAll();
    public List<Animal> getYang();
}
