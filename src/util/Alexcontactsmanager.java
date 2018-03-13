package util;

import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

    public class Alexcontactsmanager {
        private Scanner scanner;
        private List contacts;

        public static void main(String[] args) {
            Input Input = new Input();
            Alexcontactsmanager FileIO = new Alexcontactsmanager();
//Read contents from contacts file
            String fileName = "data/contacts.txt";
            if (! Files.exists(Paths.get(fileName))) {
                try {
                    Files.createFile(Paths.get(fileName));
                } catch(IOException e) {
                    System.out.println(e);
                }
            }
            FileIO.contacts = FileIO.readContacts(fileName);

            int userInput;
            do {
//Ask for user input
                FileIO.printMenu();
                userInput = Input.getInt(1,5);

//Execute user selection

                FileIO.userSelection(userInput);
            } while(userInput != 5);
        }

        public Alexcontactsmanager() {
            this.scanner = new Scanner(System.in);
        }

        public List readContacts(String filename) {
            List lines = null;
            try {
                lines = Files.readAllLines(Paths.get(filename));
// catch em all
            } catch (Exception e) {
                System.out.println("Some exception was thrown" + e);
            }
            return lines;
        }

        //function: prints menu
        protected void printMenu() {
            System.out.print(
                    "1. View Contacts.\n" +
                            "2. Add new contact.\n" +
                            "3. Search a contact by name.\n" +
                            "4. Delete an existing contact.\n" +
                            "5. Exit.\n"
            );
            System.out.print("Enter an option 1-5: ");
        }

        public String newContact() {
            System.out.println("Please enter new contact name and phone number on one line: ");
            return scanner.nextLine();
        }

        public void addContact(String newContact) {
            this.contacts.add(newContact);
        }

        public void printContacts() {
            System.out.print("|    Name    |    Phone number    |\n" +
                    "--------------------\n");
            for (Object contact : contacts) {
                System.out.println(contact);
            }
        }

        public void searchContacts() {
            System.out.println("Enter name to search: ");
            String userSearch = scanner.nextLine();
            userSearch = userSearch.toLowerCase();
            for (Object contact : contacts) {
                if (String.valueOf(contact).contains(userSearch)) {
                    System.out.println(contact);
                }
            }
        }

        public void removeContacts() {
            System.out.println("Enter name to remove: ");
            Object deleteContact = null;
            String userSearch = scanner.nextLine();
            for (Object contact : contacts) {
                if (String.valueOf(contact).contains(userSearch)) {
                    deleteContact = contact;
                }
            }
            contacts.remove(deleteContact);
        }

        public void writeToFile() {
            System.out.println("Writing to file..");
            System.out.println("all done.");
            FileWriter writer = null;
            try {
                writer = new FileWriter("data/contacts.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Object contact: contacts) {
                try {
                    assert writer != null;
                    writer.write(String.valueOf(contact)+ "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                assert writer != null;
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void userSelection(int userInput) {
            switch(userInput){
                case 1:
// View Contacts
                    this.printContacts();
                    break;
                case 2:
// add a new contact
                    this.addContact(this.newContact());
                    break;
                case 3:
// Search a contact by name
                    this.searchContacts();
                    break;
                case 4:
// Delete an existing contact
                    this.removeContacts();
                    break;
                case 5:
// Exit
                    this.writeToFile();
                    break;
            }
        }

        public String getString() {
            return this.scanner.nextLine();
        }


    }









