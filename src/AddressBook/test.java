package AddressBook;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.Collections;

class Tests {
    public static AddressBook newAdressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.addition("Иванов Иван", new Address("Пушкина", 3, 12));
        addressBook.addition("Илья Рожков", new Address("Пушкина", 69, 207));
        addressBook.addition("Dieter Reinhard", new Address("Neue Mainzer Strasse", 1, 13));
        addressBook.addition("Роман Исаев", new Address("Оборонная", 70, 101));
        addressBook.addition("Юрий Муравьёв", new Address("Авиационная", 23, 142));
        addressBook.addition("Георгий Рябов", new Address("Пушкина", 3, 1));
        return addressBook;
    }

    @Test
    @Tag("Methods")
    void addition() {
        AddressBook addressBook = newAdressBook();
        addressBook.addition("Виктор Гурьев", new Address("Тухачевского", 90, 24));
        addressBook.addition("Евгений Тарасов", new Address("Ворошилова", 86, 32));
        assertEquals(8, addressBook.get().size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addition("Иванов Иван", new Address("Палиашвили", 4, 14)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addition("", new Address("Новороссийская", 2, 12)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addition("Иванов Иван", new Address("Новороссийская", 11, -1)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addition("Иванов Иван", new Address("Новороссийская", -11, 1)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.addition("Иванов Иван", new Address("Новороссийская", 0, 1)));

    }


    @Test
    @Tag("Methods")
    void removal() {
        AddressBook addressBook = newAdressBook();
        addressBook.remove("Иванов Иван");
        assertEquals(5, addressBook.get().size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.remove("Тимофей Куликов"));
    }


    @Test
    @Tag("Methods")
    void change() {
        AddressBook addressBook = newAdressBook();
        addressBook.change("Иванов Иван", new Address("Монетная", 88, 22));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.change("Тимофей Куликов", new Address("Сергея Макеева", 7, 38)));
    }

    @Test
    @Tag("Status Check")
    void sameHouse() {
        AddressBook addressBook = newAdressBook();
        assertEquals(Arrays.asList("Иванов Иван", "Георгий Рябов"), addressBook.sameHouse(20, "Пушкина"));
        assertEquals(Arrays.asList("Юрий Муравьёв"), addressBook.sameHouse(2, "Авиационная"));
        assertEquals(Collections.emptyList(), addressBook.sameHouse(12, "Undefined"));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.change("Тимофей Куликов", new Address("Сергея Макеева", 7, 38)));
    }

    @Test
    @Tag("Status Check")
    void sameStreet() {
        AddressBook addressBook = newAdressBook();
        assertEquals(Arrays.asList("Илья Рожков", "Георгий Рябов", "Иванов Иван"), addressBook.sameStreet("Пушкина"));
        assertEquals(Arrays.asList("Роман Исаев"), addressBook.sameStreet("Оборонная"));
        assertEquals(Collections.emptyList(), addressBook.sameStreet("Мориса Тореза"));
        
    }
}