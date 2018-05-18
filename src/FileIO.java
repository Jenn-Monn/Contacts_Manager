
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;



public class FileIO {
    static String directory = "data";
    static String filename = "contacts.txt";
    Input input = new Input();

    public static void main(String[] args) {


                createNewFile(directory, filename);

        try {
            ArrayList<String> contacts = makeContacts();

            try {
                writeContactsToFile(contacts, directory, filename);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    mainMenu();

    }

    public static void mainMenu() {
        Input input = new Input();
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
                try{
                    makeContacts();
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
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
                    deleteNumber(directory, filename);
                    changesInPhoneBook(directory, filename);
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("\nExiting program");
                break;
            default:
                System.out.println("Testing default");

        }
    }


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

    public static boolean changesInPhoneBook(String directory, String filename){
        boolean changed = true;
        Path contactDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, filename);
        if (changed){
           contactFile.toAbsolutePath();
            PrintWriter out;
            }
            return changesInPhoneBook(directory, filename);
    }



    public static void writeContactsToFile(ArrayList<String> list, String directory, String filename) throws IOException{

        Path filepath = Paths.get(directory, filename);
        Files.write(filepath, list, StandardOpenOption.APPEND);

    }


    public static void readContacts(String directory, String filename) throws IOException{
        Path filepath = Paths.get(directory, filename);

        List<String> list = Files.readAllLines(filepath);

        for(String contact: list){
            System.out.println(contact);
        }

    }


    public static ArrayList<String> makeContacts() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Input input = new Input();

        String name;
        String number;
        String fullInfo;
        String answer;

        name = input.getString("Please input the contact you want to add to the list: ");
        number = input.getString("Please add the phone number for this contact: ");
        fullInfo = name + ", " + number;
        list.add(fullInfo);

        answer = input.getString("Would you like to enter another contact?");

        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
            makeContacts();
        }

        return list;

    }

    public static void searchNumber(String directory, String filename) throws IOException {
        Path filepath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filepath);
            Input input = new Input();
            String answer;
            String name;
        System.out.println(list.size());
            answer = input.getString("Enter the name of the contact you want to look up").trim();

            for (String person: list) {
                if (person.substring(0, answer.length()).equalsIgnoreCase(answer)){

                }
            }
//            if(list.contains(answer.substring(0, answer.length()))) {
//                int i;
//                i = list.indexOf(answer);
//                System.out.println(list.get(i));
//            }else {
//                System.out.println("Sorry, that name isn't in your contacts");
//            }
    }


    public static void deleteNumber(String directory, String filename) throws IOException{
        Path filepath = Paths.get(directory, filename);
        List<String> list = Files.readAllLines(filepath);
        for(int i =0; i < list.size(); i++) {
            Input input = new Input();
            String answer;
            String name;
            answer = input.getString("Enter the name of the contact you want to delete").trim().toLowerCase();
            name = list.get(i);
            if (name == null)
                System.out.println("\n Sorry, there is no one existing contact for " + answer);
            else {
                list.remove(i);
                System.out.println("\nRecord of contact removed for " + answer);
            }
        }
    }

}
