import controller.Controller;
import view.PersonFormView;
import view.SearchPersonView;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();


        JFrame frame0= new JFrame("View 1");
        JFrame frame1 = new JFrame("View 2");

        PersonFormView view1 = controller.getFormView();
        SearchPersonView view2 = controller.getSearchView();

        frame0.add(view1);
        frame1.add(view2);


        frame0.setLayout(new GridLayout(4,2));
        frame0.setSize(400,600);
        frame0.setVisible(true);
        frame1.setSize(400, 600);
        frame1.setVisible(true);
    }
}
