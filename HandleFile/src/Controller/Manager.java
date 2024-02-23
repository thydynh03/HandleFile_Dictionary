package Controller;

import Model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import Controller.Validation;
public class Manager {
    public static ArrayList<Person> getListPerson(String pathFile, Validation validation) {
        ArrayList<Person> personList = new ArrayList<>();
        File file = new File(pathFile);

        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] infoPerson = line.split(";");
                personList.add(new Person(infoPerson[0], infoPerson[1], validation.checkInputMoney()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't read file.");
        }

        return personList;
    }

    public static void printListPerson(ArrayList<Person> personList, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : personList) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(personList);
        System.out.println("Max: " + personList.get(0).getName());
        System.out.println("Min: " + personList.get(personList.size() - 1).getName());
    }

    public static String getNewContent(String pathFileInput, Validation validation) {
        HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFileInput);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }

        StringBuilder content = new StringBuilder();
        for (String line : newContent) {
            content.append(line);
        }

        return content.toString();
    }

    public static void writeNewContent(String pathFileOutput, String content, Validation validation) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathFileOutput))) {
            bufferWriter.write(content);
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        }
    }
}
