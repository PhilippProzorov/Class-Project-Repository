package AddressBook;

class Address {
    private String street;
    private int house;
    private int apartment;
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
    String getStreet() {
        return this.street;
    }
    int getHouse() {
        return this.house;
    }
    @Override
    public String toString() {
        return "Улица " + street + ", дом " + house + ", квартира " + apartment;
    }
}