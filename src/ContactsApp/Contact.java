package ContactsApp;

public class Contact {
    private String name, phone;
    protected Contact (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    protected Contact () {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return this.name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    protected void setPhone(String phone) {
        this.phone = phone;
    }
}
