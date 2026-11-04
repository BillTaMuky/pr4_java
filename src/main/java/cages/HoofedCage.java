package main.java.cages;

import main.java.animals.Hoofed;

public class HoofedCage<T extends Hoofed> extends MammalCage<T> {
    public HoofedCage(int maxCapacity) {
        super(maxCapacity);
    }
}
