package main.java;

import main.java.animals.Animal;
import main.java.cages.Cage;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public List<Cage<? extends Animal>> cages = new ArrayList<>();


    public void addCage(Cage<? extends Animal> cage) {
        cages.add(cage);
    }

    public int getCountOfAnimals() {
        int total = 0;
        for (Cage<? extends Animal> cage : cages) {
            total += cage.getOccupied();
        }
        return total;
    }
}
