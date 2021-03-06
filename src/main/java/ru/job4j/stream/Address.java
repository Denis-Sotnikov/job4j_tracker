package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Address {
    private String city;
    private String street;

    private int home;
    private int apartment;

    public Address() {
    }

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    public String getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='"
                + city
                + '\''
                + ", street='"
                + street
                + '\''
                + ", home="
                + home
                + ", apartment="
                + apartment
                + '}';
    }
}