package view;

import controller.Controller;
import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

public class SearchPersonView extends JPanel {

    private JTextField searchField;

    private JButton searchButton;

    private JList list;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public SearchPersonView() {
        setLayout(new GridLayout(3, 1));

        searchField = new JTextField();
        add(searchField);

        searchButton = new JButton("Search by age");
        add(searchButton);
        searchButton.addActionListener(a -> {
            // call controller to return list of objects based on search criteria
            int age = Integer.parseInt(searchField.getText());

            Person[] resultList = controller.searchByAge(age);

            String[] names = new String[resultList.length];

            for(int i = 0; i < resultList.length; i++) {
                names[i] = resultList[i].getName();
            }

            System.out.println(Arrays.toString(names));

            list = new JList(names);
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list.setLayoutOrientation(JList.VERTICAL);
            add(list);

            MouseListener mouseListener = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 2) {

                        String selectedPerson = (String) list.getSelectedValue();

                        System.out.println("Clicked on " + selectedPerson);

//                        Now we have the object necessary, just send this to our third view for a detailed list of this person
                        Person person = controller.searchByName(selectedPerson);

                        JFrame frame = new JFrame("View3");

                        frame.add(new DetailsView(person));

                        frame.setSize(350, 300);
                        frame.setVisible(true);

                    }
                }
            };

            list.addMouseListener(mouseListener);



        });
    }


}