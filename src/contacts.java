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

    public void addPhoneNumbers(int number) {
        numbers.add(number);
    }

    public void addContactName() {
        String name = input.getString("What is the new Contact name?");

        contacts contact = makeContact();

        contact.put(name, number);
    }

    protected contacts makeContact() {
        String name = input.getString("Please enter the Contact Name: ");

        contacts contact = new contacts(name);

        do {
            number = input.getInt("Please enter a phone number for " + name + ".");

            contact.addPhoneNumbers(number);

        } while (input.yesNo("Do you want to add more contacts and their numbers?"));

        return contact;
    }
}
