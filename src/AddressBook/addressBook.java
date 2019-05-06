package AddressBook;
import java.util.*;

class AddressBook {
    private Map<String, Address> habitantInfo =
            new HashMap<>();
    Map<String, Address> get() {
        return habitantInfo;
    }

    void addition (String habitant, Address address) {
        if (habitant.isEmpty()){
            throw new IllegalArgumentException("FAILED TO ADD. SUBMITTED INFO MUST CONTAIN A NAME");
        }
        else {
            if (habitantInfo.containsKey(habitant))
                throw new IllegalArgumentException("FAILED TO ADD. THIS PERSON ALREADY EXISTS");
            else habitantInfo.put(habitant, address);
           }
    }

    void change(String habitant, Address address) {
        if (habitantInfo.containsKey(habitant))
            habitantInfo.replace(habitant, address);
        else throw new IllegalArgumentException("FAILED TO CHANGE. NON-EXISTENT INHABITANT ");
    }

    void remove(String habitant) {
        if (habitantInfo.containsKey(habitant))
            habitantInfo.remove(habitant);
        else throw new IllegalArgumentException("FAILED TO REMOVE. THIS PERSON DOESN'T EXIST");
    }

    List<String> sameStreet(String street) {
        List<String> streetInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : habitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().extractedStreet(), street)) {
                streetInhabitants.add(addressBook.getKey());
            }
        }
        return streetInhabitants;
    }

    List<String> sameHouse(int house, String street) {
        List<String> houseInhabitants =
                new ArrayList<>();
        for (Map.Entry<String, Address> addressBook : habitantInfo.entrySet()) {
            if (Objects.equals(addressBook.getValue().extractedStreet(), street) &&
                    (addressBook.getValue().extractedHouse() == house)) {
                houseInhabitants.add(addressBook.getKey());
            }
        }
        return houseInhabitants;
    }
}