package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonFormView extends JPanel {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel ageLabel;
    private JTextField ageTextField;
    private JButton saveButton;

    private JLabel emailLabel;

    private JTextField emailTextField;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }


    public PersonFormView() {

        setLayout(new GridLayout(4, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);

        nameTextField = new JTextField();
        add(nameTextField);

        ageLabel = new JLabel("Age:");
        add(ageLabel);

        ageTextField = new JTextField();
        add(ageTextField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);

        emailTextField = new JTextField();
        add(emailTextField);

        saveButton = new JButton("Save");
        add(saveButton);
        saveButton.addActionListener(e -> {
            String name = nameTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            String email = emailTextField.getText();
            controller.savePerson(name, age, email);
        });
    }

}