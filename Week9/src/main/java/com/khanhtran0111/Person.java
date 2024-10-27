package com.khanhtran0111;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public String address;
    List<Vehicle> vehicleList;

    /**
     * An especially short bit of Javadoc.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicleList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public void removeVehicle(String registrationNumber) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(vehicle);
            }
        }
    }

    /**
     * An especially short bit of Javadoc.
     */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return name + " has no vehicle!";
        } else {
            StringBuilder result = new StringBuilder(name + " has:\n\n");
            for (Vehicle vehicle : vehicleList) {
                result.append(vehicle.getInfo()).append("\n");
            }
            return result.toString();
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
