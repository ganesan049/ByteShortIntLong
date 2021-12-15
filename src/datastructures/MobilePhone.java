package datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private static ArrayList<Contact> mobileContacts = new ArrayList<Contact>();

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        while (!quit){

        int inst = scanner.nextInt();
        switch (inst){
            case 0:
                printInstructions();break;
            case 1:
                addContact();break;
            case 2:
                modifyContact();break;
            case 3:
                removeContact();break;
            case 4:
                queryContact();break;
            case 5:
                printContacts();break;
            case 6: default:
                quit = true;
                break;
        }

        }
    }

    private static void printContacts() {
        for (int i=0;i<mobileContacts.size();i++){
            System.out.println(mobileContacts.get(i).getName()+" - "
            +mobileContacts.get(i).getNumber());
        }
    }

    private static void queryContact() {
        System.out.println("Enter Name");
        String name = scanner.next();
        int index = checkName(name);
        if(index != -1){
            System.out.println("Number is "+mobileContacts.get(index).getNumber());
        }else {
            System.out.println("Contact is NA");
        }
    }

    private static void removeContact() {
        Contact contact = getContact();
        int index = checkName(contact);
        if(index != -1){
            mobileContacts.remove(index);
            System.out.println("Removed successfully");
        }else {
            System.out.println("Contact is NA");
        }
    }

    private static void modifyContact() {
        Contact contact = getContact();
        int index = checkName(contact.getName());
        if(index != -1){
            Contact newContact = getContact();
            replaceContact(index,newContact);
        }else {
            System.out.println("Contact is NA");
        }
    }

    private static void replaceContact(int index, Contact contact) {
        mobileContacts.set(index,contact);
        System.out.println("Modified successfully");
    }

    private static int checkName(Contact contact) {
        int index = mobileContacts.indexOf(contact);
        return index;
    }

    private static int checkName(String name) {
        for (int i=0;i<mobileContacts.size();i++){
            if(mobileContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    private static void addContact() {
        Contact contact = getContact();
        mobileContacts.add(contact);
        System.out.println("Contact added successfully with "+contact.getName()+" "+contact.getNumber());
    }

    private static Contact getContact() {
        System.out.println("Enter Name");
        String name = scanner.next();
        System.out.println("Enter Number");
        int number = scanner.nextInt();
        return new Contact().createContact(name,number);
    }

    private static void printInstructions() {
        System.out.println("0 -> printInstructions");
        System.out.println("1 -> storeContact");
        System.out.println("2 -> modifyContact");
        System.out.println("3 -> removeContact");
        System.out.println("4 -> queryContact");
        System.out.println("5 -> printContacts");
        System.out.println("6 -> quit");
    }
}
