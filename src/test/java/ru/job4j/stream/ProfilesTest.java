package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.collection.Departments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenTest() {
        List<Profile> inputBefore = new ArrayList<>();
        inputBefore.add(new Profile(new Address("Sankt=Peterburg", "Nevskiy prospect", 15, 10)));
        inputBefore.add(new Profile(new Address("Altay", "Ligovskiy prospect", 10, 8)));
        inputBefore.add(new Profile(new Address("Sankt=Peterburg", "Nevskiy prospect", 15, 10)));
        inputBefore.add(new Profile(new Address("Krasnoyarsk", "Pobedi street", 1, 105)));
        inputBefore.add(new Profile(new Address("Sochi", "Mayakovskogo street", 5, 201)));
        List<Address> inputAfter = Profiles.collect(inputBefore);
        System.out.println(inputAfter.size());
        List<Address> result = new ArrayList<>();
        result.add(new Address("Altay", "Ligovskiy prospect", 10, 8));
        result.add(new Address("Krasnoyarsk", "Pobedi street", 1, 105));
        result.add(new Address("Sankt=Peterburg", "Nevskiy prospect", 15, 10));
        result.add(new Address("Sochi", "Mayakovskogo street", 5, 201));
        assertThat(inputAfter, is(result));
    }

}