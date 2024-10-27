//package com.khanhtran0111;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, String registrationNumber,
               Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        return "Car:\n"
                + "\tBrand: " + getBrand() + "\n"
                + "\tModel: " + getModel() + "\n"
                + "\tRegistration Number: " + getRegistrationNumber() + "\n"
                + "\tNumber of Doors: " + numberOfDoors + "\n"
                + "\tBelongs to " + getOwner().getName() + " - " + getOwner().getAddress();
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
