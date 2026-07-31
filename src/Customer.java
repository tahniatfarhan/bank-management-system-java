public class Customer extends Person {
    private String address;

    public Customer(int id, String name, String cnic, String phone, String address) {
        super(id, name, cnic, phone);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    // Add these getters:
    public String getCnic() {
        return cnic;  // matches field in Person
    }

    public String getPhone() {
        return phone; // matches field in Person
    }
}
