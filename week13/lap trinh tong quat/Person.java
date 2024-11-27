//package com.khanhtran0111;

public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    /**
     * person.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    /**
     * person.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * lmao.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Person o) {
        int nameCompare = this.name.compareTo(o.getName());
        return nameCompare != 0
                ? nameCompare
                : Integer.compare(this.age, o.getAge());
    }
}
