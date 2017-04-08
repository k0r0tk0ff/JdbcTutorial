package entity;

/**
 * Created by user on 4/8/2017.
 */
public class Address {

    private long id;
    private String country;
    private String city;
    private String street;
    private String postcode;

    public Address() {
    }

    /**
     * If in project use more than two parameters,
     * smart mans recommended write "get" and "set" methods
     */

    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'country'.
     *
     * @return Value for property 'country'.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for property 'country'.
     *
     * @param country Value to set for property 'country'.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for property 'city'.
     *
     * @return Value for property 'city'.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for property 'city'.
     *
     * @param city Value to set for property 'city'.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for property 'street'.
     *
     * @return Value for property 'street'.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for property 'street'.
     *
     * @param street Value to set for property 'street'.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for property 'postcode'.
     *
     * @return Value for property 'postcode'.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Setter for property 'postcode'.
     *
     * @param postcode Value to set for property 'postcode'.
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return postcode != null ? postcode.equals(address.postcode) : address.postcode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
