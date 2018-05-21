
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

//    public String toString(){
//        return this.name + " |  " + this.number + " |  ";
//    }

}

