import java.util.ArrayList;

public class contacts {
    private String contact;
    private int number;
    public ArrayList<Integer> numbers;
    Input input = new Input();

    public contacts(String contact) {
        this.contact = contact;
        numbers = new ArrayList<>();
    }

    public void addPhoneNumbers() {
        numbers.add(number);
    }

    public String getContactName(String prompt) {
        return contact;
    }

    public void setContactName(String contact) {
        contact = input.getString("Please enter a name for your Contacts List: ");
    }

    public void setNumber(int number) {
        number = input.getInt("Please enter a phone number for your contact: ");
    }

    public int getNumber() {
        return number;
    }
}
