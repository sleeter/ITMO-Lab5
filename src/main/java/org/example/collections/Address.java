package org.example.collections;

/**
 * An address is a street.
 */
public class Address {
    private String street; //Поле может быть null
    public Address(String street){
        this.street = street;
    }
    /**
     * It returns the street name of the address.
     *
     * @return The street variable.
     */
    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}
