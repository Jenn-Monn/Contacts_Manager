
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileIO {


    public static void createNewFile(String directory, String filename){
        Path contactDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, filename);

        try{
            if (Files.notExists(contactDirectory)){
                Files.createDirectories(contactDirectory);
            }

            if (Files.notExists(contactFile)){
                Files.createFile(contactFile);
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void writeContactsToFile(ArrayList<String> list, String directory, String filename) throws IOException{

        Path filepath = Paths.get(directory, filename);
        Files.write(filepath, list, StandardOpenOption.APPEND);

    }


    public static void noWriteContactsToFile(List<String> list, String directory, String filename)throws IOException{
        Path filepath = Paths.get(directory, filename);
        Files.write(filepath, list);
    }


    public static void readContacts(String directory, String filename) throws IOException{
        Path filepath = Paths.get(directory, filename);

        List<String> list = Files.readAllLines(filepath);
        System.out.println("Name                | Phone Number");
        System.out.println("----------------------------------");
        for(String contact: list){
            System.out.println(contact);
        }

    }


    public static void makeContacts()throws IOException{
        Input input = new Input();
        String name;
        String number;
        String fullInfo;
        ArrayList<String> list = new ArrayList<>();

        do {
            name = input.getString("Please input the contact you want to add to the list: ");
            number = input.getString("Please add the phone number for this contact: ");
            Contact contact = new Contact(name, number);
            fullInfo = contact.name + "           | " + contact.number + " |  ";
            list.add(fullInfo);
        } while (input.yesNo("Do you want to add another contact to the list [yes/no]: "));
        writeContactsToFile(list, "data", "contacts.txt");

    }


    public static void searchNumber(String directory, String filename) throws IOException {
        Input input = new Input();
        Path filepath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filepath);
        String answer;
        answer = input.getString("Enter the name of the contact you want to look up").trim().toLowerCase();
        for (String contact: list){
            if (contact.toLowerCase().contains(answer)){
                System.out.println("The information for " + answer + " | is:  |"  + contact + " | ");
            }
        }

    }

    public static void deleteNumber(String directory, String filename, String inputUser) throws IOException{
        Input input = new Input();
        Path filepath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filepath);
        inputUser = input.getString("Enter the contact you want to delete");
        for(String contact: list){
            if(contact.trim().toLowerCase().contains(inputUser.toLowerCase())){
                list.remove(contact);
                System.out.println("Contact " + contact +  " deleted");
                noWriteContactsToFile(list, "data", "contacts.txt");
            }

        }
    }

    public static void main(String[] args) throws IOException{
        String directory = "data";
        String filename = "contacts.txt";
        Input input = new Input();
        boolean userExit = false;

                createNewFile(directory, filename);

        do {
        int command;
        command = input.getInt("Welcome to your phone Book!\n" +
                "   1. View all contacts\n" +
                "   2.Add a new contact\n" +
                "   3.Search a contact by name\n" +
                "   4.Delete an existing contact\n" +
                "   5. Exit\n" +
                "   Enter an option (1, 2, 3, 4, or 5) : ");

            switch (command){
                case 1:
                    try {
                        readContacts(directory, filename);
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                        makeContacts();
                    break;

                case 3:
                    try {
                        searchNumber(directory, filename);
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        deleteNumber(directory, filename, input.getString(""));
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\nExiting program");
                    userExit = true;
                    break;
                    default:
                        System.out.println("Testing default");
            }
        } while (!userExit);

    }

}


//    static String directory = "data";
//    static String filename = "contacts.txt";
//    Input input = new Input();


//    public static void main(String[] args) {
//
//
//                createNewFile(directory, filename);
//
////        try {
////            ArrayList<String> contacts = makeContacts();
////
////            try {
////                writeContactsToFile(contacts, directory, filename);
////            } catch (IOException e) {
////                System.out.println(e.getMessage());
////            }
////        } catch (IOException e){
////            System.out.println(e.getMessage());
////        }
////
////    mainMenu();
//
//    }
//
//    public static void mainMenu() {
//        Input input = new Input();
//        int command;
//        command = input.getInt("Welcome to your phone Book!\n" +
//                "   1. View all contacts\n" +
//                "   2.Add a new contact\n" +
//                "   3.Search a contact by name\n" +
//                "   4.Delete an existing contact\n" +
//                "   5. Exit\n" +
//                "   Enter an option (1, 2, 3, 4, or 5) : ");
//
//        switch (command){
//            case 1:
//                try {
//                    readContacts(directory, filename);
//                }catch (IOException e){
//                    System.out.println(e.getMessage());
//                }
//                break;
//
//            case 2:
//                try{
//                    makeContacts();
//                }catch (IOException e){
//                    System.out.println(e.getMessage());
//                }
//                break;
//
//            case 3:
//                try {
//                    searchNumber(directory, filename);
//                }catch (IOException e){
//                    System.out.println(e.getMessage());
//                }
//                break;
//
//            case 4:
//                try {
//                    deleteNumber(directory, filename, input.getString(""));
//
//                }catch (IOException e){
//                    System.out.println(e.getMessage());
//                }
//                break;
//
//            case 5:
//                System.out.println("\nExiting program");
//                break;
//            default:
//                System.out.println("Testing default");
//
//        }
//    }


// --------------------- CODE ON SEARCH NUMBER ----------------------
//Input input = new Input();
//            String answer;
//            String name;
//        System.out.println(list.size());
//            answer = input.getString("Enter the name of the contact you want to look up").trim();
//
//            for (String person: list) {
//                if (person.substring(0, answer.length()).equalsIgnoreCase(answer)){
//
//                }
//            }
//            if(list.contains(answer.substring(0, answer.length()))) {
//                int i;
//                i = list.indexOf(answer);
//                System.out.println(list.get(i));
//            }else {
//                System.out.println("Sorry, that name isn't in your contacts");
//            }