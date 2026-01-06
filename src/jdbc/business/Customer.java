package jdbc.business;

/*
Entidad Cliente del sistema de tienda de videojuegos.
 */

public class Customer {
    private String name;
    private String surnames;
    private String address;
    private String email;
    private Long customerId;

    public Customer(String name, String surnames, String address, String email, Long customerId) {
        this.name = name;
        this.surnames = surnames;
        this.address = address;
        this.email = email;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
