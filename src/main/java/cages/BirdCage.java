package main.java.cages;

import main.java.animals.Bird;

public class BirdCage<T extends Bird> extends Cage<T> {
    public BirdCage(int maxCapacity) {
        super(maxCapacity);
    }
}
