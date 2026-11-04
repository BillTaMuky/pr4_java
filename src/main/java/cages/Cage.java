package main.java.cages;

import main.java.animals.Animal;
import main.java.exceptions.AnimalNotFoundException;
import main.java.exceptions.CageFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Cage<T extends Animal> {
    private final int maxCapacity;
    private final List<T> animals = new ArrayList<>();

    protected Cage(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути більшою за 0");
        }
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getOccupied() {
        return animals.size();
    }

    public void add(T animal) {
        if (animals.size() >= maxCapacity) {
            throw new CageFullException(
                    "Вольєр заповнений (" + maxCapacity + " місць), не вдалося додати " + animal);
        }
        animals.add(animal);
    }

    public void remove(T animal) {
        if (!animals.remove(animal)) {
            throw new AnimalNotFoundException(
                    "Тварини " + animal + " немає у вольєрі");
        }
    }


    public void addAll(Collection<? extends T> source) {
        for (T animal : source) {
            add(animal);
        }
    }

    public List<T> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}