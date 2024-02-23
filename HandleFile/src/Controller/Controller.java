// Controller.java
package Controller;

import Model.Person;
import View.View;
import java.util.ArrayList;

public class Controller {
    private final View view;
    private final Validation validation;

    public Controller(View view, Validation validation) {
        this.view = view;
        this.validation = validation;
    }

    public void start() {
        while (true) {
            int choice = view.menu();
            switch (choice) {
                case 1:
                    findPersonInfo();
                    break;
                case 2:
                    copyNewFile();
                    break;
                case 3:
                    return;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void findPersonInfo() {
        String pathFile = view.inputPathFile();
        ArrayList<Person> personList = Manager.getListPerson(pathFile, validation);
        double money = validation.checkInputMoney();
        Manager.printListPerson(personList, money);
    }

    private void copyNewFile() {
        String pathFileInput = view.inputPathFile();
        String pathFileOutput = view.inputPathFile();
        String content = Manager.getNewContent(pathFileInput, validation);
        view.displayMessage(content);
        Manager.writeNewContent(pathFileOutput, content, validation);
    }
}
