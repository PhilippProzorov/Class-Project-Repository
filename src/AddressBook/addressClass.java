package AddressBook;

class Address {
    public String street;
    public int house;
    public int apartment;
    Address(String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        if ((street.isEmpty()) ||
                (house <= 0) ||
                (apartment <= 0)) {
            throw new IllegalArgumentException("ILLEGAL ADDRESS FORMAT");
        }
    }
    String extractedStreet() {
        return this.street;
    }
    int extractedHouse() {
        return this.house;
    }
    @Override
    public String toString() {
        return "Улица " + street + ", дом " + house + ", квартира " + apartment;
    }
}