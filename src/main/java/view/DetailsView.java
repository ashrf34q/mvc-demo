package view;

import model.Person;

import javax.swing.*;
import java.awt.*;

public class DetailsView extends JPanel {

    private JLabel nameLabel;

    private JLabel age;

    private JLabel email;

    private JTextArea nameArea;

    private JTextArea ageArea;

    private JTextArea emailArea;


    public DetailsView(Person person) {
        setLayout(new GridLayout(5, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);

        nameArea = new JTextArea(1,1);
        nameArea.append(person.getName());
        add(nameArea);

        age = new JLabel("Age:");
        add(age);

        ageArea = new JTextArea(1,1);
        ageArea.append(String.valueOf(person.getAge()));
        add(ageArea);

        email = new JLabel("Email:");
        add(email);

        emailArea = new JTextArea(1, 1);
        emailArea.append(person.getEmail());
        add(emailArea);
    }

}
