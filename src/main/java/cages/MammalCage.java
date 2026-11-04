package main.java.cages;

import main.java.animals.Mammal;

public class MammalCage<T extends Mammal> extends Cage<T> {
    public MammalCage(int maxCapacity) {
        super(maxCapacity);
    }
}