public class Cliente {

    // Atrubutes
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Cliente(String name, String phone, String email) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Gets and Sets
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "Nome: " + name + "\nTelefone: " + phone + "\nEmail: " + email;
    }

}
