package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private Address address;

    public Profile() {
    }

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
