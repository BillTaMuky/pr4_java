package test.java;

import main.java.Zoo;
import main.java.animals.*;
import main.java.cages.BirdCage;
import main.java.cages.HoofedCage;
import main.java.cages.LionCage;

import main.java.exceptions.AnimalNotFoundException;
import main.java.exceptions.CageFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    private LionCage lionCage;
    private HoofedCage<Hoofed> hoofedCage;
    private BirdCage<Bird> birdCage;
    private Zoo zoo;

    @BeforeEach
    void setUp() {
        lionCage = new LionCage(2);
        hoofedCage = new HoofedCage<>(3);
        birdCage = new BirdCage<>(1);
        zoo = new Zoo();
        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        zoo.addCage(birdCage);
    }

    @Test
    void addAnimalIncreasesOccupied() {
        lionCage.add(new Lion("TIGR"));
        assertEquals(1, lionCage.getOccupied());
        assertEquals(2, lionCage.getMaxCapacity());
    }

    @Test
    void addToFullCageThrows() {
        lionCage.add(new Lion("TIGR"));
        lionCage.add(new Lion("KOTIK"));
        assertThrows(CageFullException.class, () -> lionCage.add(new Lion("KOTIK2")));
    }

    @Test
    void removeAnimal() {
        Lion tigr = new Lion("TIGR");
        lionCage.add(tigr);
        lionCage.remove(tigr);
        assertEquals(0, lionCage.getOccupied());
    }

    @Test
    void removeMissingAnimalThrows() {
        assertThrows(AnimalNotFoundException.class,
                () -> lionCage.remove(new Lion("NOKOTIK")));
    }

    @Test
    void hoofedCageAcceptsZebrasAndGiraffes() {
        hoofedCage.add(new Zebra("ZEBRA"));
        hoofedCage.add(new Giraffe("GIRRAFA"));
        assertEquals(2, hoofedCage.getOccupied());
    }

    @Test
    void addAllUsesWildcard() {
        List<Zebra> zebras = List.of(new Zebra("Z1"), new Zebra("Z2"));
        hoofedCage.addAll(zebras);
        assertEquals(2, hoofedCage.getOccupied());
    }

    @Test
    void zooCountsAllAnimals() {
        lionCage.add(new Lion("TIGR"));
        hoofedCage.add(new Zebra("ZEBRA"));
        hoofedCage.add(new Giraffe("GIRAFA"));
        birdCage.add(new Eagle("KAKADU"));
        assertEquals(4, zoo.getCountOfAnimals());
    }

    @Test
    void emptyZooHasZeroAnimals() {
        assertEquals(0, new Zoo().getCountOfAnimals());
    }

    @Test
    void zeroCapacityFails() {
        LionCage cage = new LionCage(0);   // конструктор кине виняток
        assertEquals(0, cage.getMaxCapacity());
    }

}

