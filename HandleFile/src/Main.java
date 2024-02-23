import Controller.Controller;
import View.View;
import Controller.Validation;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Validation validation = new Validation(view.getScanner());
        Controller controller = new Controller(view, validation);
        controller.start();
    }
}
