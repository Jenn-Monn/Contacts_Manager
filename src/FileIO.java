import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileIO {

    public static void main(String[] args) {

        String directory = "data";
        String filename = "contacts.txt";

                createNewFile( directory, filename);

        ArrayList<String> contacts = makeContacts();
        System.out.println(contacts);

        try {

            writeContactsToFile(contacts, directory, filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {

            readContacts(directory, filename);
        } catch (IOException e){
            System.out.println(e.getMessage());
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


    public static ArrayList<String> makeContacts(){
        ArrayList<String> list = new ArrayList<>();
        Input input = new Input();
        String contact;


        contact = input.getString("Please input the contact you want to add to the list");
        list.add(contact);


        return list;

    }






}
