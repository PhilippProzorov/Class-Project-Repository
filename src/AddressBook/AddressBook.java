package AddressBook;
import java.util.*;

class AddressBook {
    private Map<String, Address> inhabitantInfo = new HashMap<>();
    void add(String inhabitant, Address address) {
        if ((inhabitant.isEmpty()) || (inhabitantInfo.containsKey(inhabitant)))
            throw new IllegalArgumentException("FAILED TO ADD. INCORRECT INPUT");
        inhabitantInfo.put(inhabitant, address);
    }

    public String search(String inhabitant) {
        if (!inhabitantInfo.containsKey(inhabitant))
            throw new IllegalArgumentException("NO RESULT. EITHER INCORRECT INPUT OR THIS PERSON DOESN'T EXIST");
        return inhabitantInfo.get(inhabitant).toString();

    }

    void change(String inhabitant, Address address) {
        if (!inhabitantInfo.containsKey(inhabitant)) {
            throw new IllegalArgumentException("FAILED TO CHANGE. NON-EXISTENT INHABITANT ");
        }
        inhabitantInfo.replace(inhabitant, address);
    }

    void remove(String inhabitant) {
        if (!inhabitantInfo.containsKey(inhabitant))
            throw new IllegalArgumentException("FAILED TO REMOVE. THIS PERSON DOESN'T EXIST");
        inhabitantInfo.remove(inhabitant);
    }

    List<String> sameStreet(String street) {
        List<String> streetInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : inhabitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street)) {
                streetInhabitants.add(addressBook.getKey());
            }
        }
        return streetInhabitants;
    }

    List<String> sameHouse(String street, int house) {
        List<String> houseInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : inhabitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street) &&
                    (Objects.equals(addressBook.getValue().getHouse(), house))) {
                houseInhabitants.add(addressBook.getKey());
            }
        }
        return houseInhabitants;
    }

    public int size() {
        return inhabitantInfo.size();
    }
}
