package AddressBook;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.Collections;

class Tests {
    private AddressBook newAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("Иванов Иван", new Address("Пушкина", 3, 12));
        addressBook.add("Илья Рожков", new Address("Пушкина", 69, 207));
        addressBook.add("Dieter Reinhard", new Address("Neue Mainzer Strasse", 1, 13));
        addressBook.add("Роман Исаев", new Address("Оборонная", 70, 101));
        addressBook.add("Юрий Муравьёв", new Address("Авиационная", 23, 142));
        addressBook.add("Георгий Рябов", new Address("Пушкина", 3, 1));
        return addressBook;
    }

    @Test
    @Tag("Methods")
    void add() {
        AddressBook addressBook = newAddressBook();
        addressBook.add("Виктор Гурьев", new Address("Тухачевского", 90, 24));
        assertEquals(new Address("Тухачевского", 90, 24).toString(),
                addressBook.search("Виктор Гурьев"));
        addressBook.add("Евгений Тарасов", new Address("Ворошилова", 86, 32));
        assertEquals(new Address("Ворошилова", 86, 32).toString(),
                addressBook.search("Евгений Тарасов"));
        assertEquals(8, addressBook.size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.add("Иванов Иван", new Address("Палиашвили", 4, 14)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.add("", new Address("Новороссийская", 2, 12)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.add("Иванов Иван", new Address("Новороссийская", 11, -1)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.add("Иванов Иван", new Address("Новороссийская", -11, 1)));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.add("Иванов Иван", new Address("Новороссийская", 0, 1)));

    }

    @Test
    @Tag("Methods")
    void search() {
        AddressBook addressBook = newAddressBook();
        addressBook.add("Евгений Тарасов", new Address("Ворошилова", 86, 32));
        assertEquals(7, addressBook.size());
        assertEquals(new Address("Ворошилова", 86, 32).toString(),
                addressBook.search("Евгений Тарасов"));
        assertEquals(new Address("Пушкина", 3, 1).toString(),
                addressBook.search("Георгий Рябов"));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.search("Тимофей Куликов"));
    }

    @Test
    @Tag("Methods")
    void remove() {
        AddressBook addressBook = newAddressBook();
        addressBook.remove("Иванов Иван");
        assertEquals(5, addressBook.size());
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.search("Иванов Иван"));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.remove("Тимофей Куликов"));
    }

    @Test
    @Tag("Methods")
    void change() {
        AddressBook addressBook = newAddressBook();
        addressBook.change("Иванов Иван", new Address("Монетная", 88, 22));
        assertEquals(6, addressBook.size());
        assertEquals(new Address("Монетная", 88, 22).toString(),
                addressBook.search("Иванов Иван"));
        assertThrows(IllegalArgumentException.class, () ->
                addressBook.change("Тимофей Куликов", new Address("Сергея Макеева", 7, 38)));
    }

    @Test
    @Tag("Methods")
    void sameStreet() {
        AddressBook addressBook = newAddressBook();
        assertEquals(Arrays.asList("Илья Рожков",
                "Георгий Рябов", "Иванов Иван"), addressBook.sameStreet("Пушкина"));
        assertEquals(Arrays.asList("Роман Исаев"),
                addressBook.sameStreet("Оборонная"));
        assertEquals(Collections.emptyList(),
                addressBook.sameStreet("Мориса Тореза"));
        
    }

    @Test
    @Tag("Methods")
    void sameHouse() {
        AddressBook addressBook = newAddressBook();
        assertEquals(Arrays.asList("Георгий Рябов", "Иванов Иван"),
                addressBook.sameHouse("Пушкина", 3));
        assertEquals(Arrays.asList("Dieter Reinhard"),
                addressBook.sameHouse("Neue Mainzer Strasse", 1));
        assertEquals(Collections.emptyList(),
                addressBook.sameHouse("undefined", 0));
    }
}

