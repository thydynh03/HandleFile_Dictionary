package Controller;

import View.Display;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private final Display view;
    private final Map<String, String> wordMap;

    public Manager() {
        view = new Display();
        wordMap = new HashMap<>();
    }

    public void start() {
        while (true) {
            int choice = view.menu();
            switch (choice) {
                case 1:
                    addNewWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    searchWord();
                    break;
                case 4:
                    return;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewWord() {
        String english = view.inputEnglishWord();
        if (wordMap.containsKey(english)) {
            view.displayMessage("The word already exists.");
            return;
        }
        String vietnamese = view.inputVietnameseMeaning();
        wordMap.put(english, vietnamese);
        view.displayMessage("Add successful.");
    }

    private void deleteWord() {
        String english = view.inputEnglishWord();
        if (!wordMap.containsKey(english)) {
            view.displayMessage("The word does not exist.");
            return;
        }
        wordMap.remove(english);
        view.displayMessage("Delete successful.");
    }

    private void searchWord() {
        String english = view.inputEnglishWord();
        String vietnamese = wordMap.getOrDefault(english, "Not found in data.");
        view.displayMessage("Vietnamese: " + vietnamese);
    }
}
