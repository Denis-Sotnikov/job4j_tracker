package ru.job4j.tracker.oop;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CatTest {

    @Test
    void whenSoundMauMau() {
        String name = "Мяу-мяу";
        Cat cat = new Cat();
        String nameFromFunction = cat.sound();
        assertThat(nameFromFunction).isEqualTo(name);
    }
}