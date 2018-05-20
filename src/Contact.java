import java.util.ArrayList;

public class Contact {
    protected String name;
    protected String number;


    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getContact() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String toString(){
        return this.name + " |  " + this.number + " |  ";
    }

}

//import java.util.ArrayList;
//
//public class contacts {
//    private String contact;
//    private String number;
//    public ArrayList<String> numbers;
//    Input input = new Input();
//
//    public contacts(String contact) {
//        this.contact = contact;
//        numbers = new ArrayList<>();
//    }
//
//
//    public String getContactName(String prompt) {
//        return contact;
//    }
//
//    public void setContactName(String contact) {
//        contact = input.getString("Please enter a name for your Contacts List: ");
//    }
//
//    public void setNumber(int number) {
//        number = input.getInt("Please enter a phone number for your contact: ");
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void addPhoneNumbers(String number) {
//        numbers.add(number);
//    }
//}
