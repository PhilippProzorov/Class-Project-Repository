package AddressBook;
import java.util.*;

class AddressBook {
    private Map<String, Address> habitantInfo =
            new HashMap<>();
    Map<String, Address> get() {
        return habitantInfo;
    }

    void add(String inhabitant, Address address) {
        if ((inhabitant.isEmpty()) || (habitantInfo.containsKey(inhabitant))) {
            throw new IllegalArgumentException("FAILED TO ADD. INCORRECT INPUT");
        }
        else habitantInfo.put(inhabitant, address);
    }

    public void search(String inhabitant) {
        if (habitantInfo.containsKey(inhabitant)) {
            habitantInfo.get(inhabitant);
        }
        else throw new IllegalArgumentException("NO RESULT. EITHER INCORRECT INPUT OR THIS PERSON DOESN'T EXIST");
    }

    void change(String inhabitant, Address address) {
        if (habitantInfo.containsKey(inhabitant)) {
            habitantInfo.replace(inhabitant, address);
        }
        else throw new IllegalArgumentException("FAILED TO CHANGE. NON-EXISTENT INHABITANT ");
    }

    void remove(String habitant) {
        if (habitantInfo.containsKey(habitant)) {
            habitantInfo.remove(habitant);
        }
        else throw new IllegalArgumentException("FAILED TO REMOVE. THIS PERSON DOESN'T EXIST");
    }

    List<String> sameStreet(String street) {
        List<String> streetInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : habitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street)) {
                streetInhabitants.add(addressBook.getKey());
            }
        }
        return streetInhabitants;
    }

    List<String> sameHouse(String street, int house) {
        List<String> houseInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : habitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street) &&
                    (Objects.equals(addressBook.getValue().getHouse(), house))) {
                houseInhabitants.add(addressBook.getKey());
            }
        }
        return houseInhabitants;
    }
}