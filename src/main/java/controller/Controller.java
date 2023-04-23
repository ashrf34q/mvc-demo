package controller;

import model.Person;
import view.PersonFormView;
import view.SearchPersonView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private List<Person> people;
    private PersonFormView formView;
    private SearchPersonView searchView;

    public Controller() {
        people = new ArrayList<>();
        formView = new PersonFormView();
        searchView = new SearchPersonView();

        formView.setController(this);
        searchView.setController(this);
    }

    public void print() {
        for (Person person:
             people) {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }

    public Person searchByName(String name) {
        for(Person person : people) {
            if(person.getName().equals(name)) {
                return person;
            }
        }
        throw new RuntimeException("Not found!");
    }

    public Person[] searchByAge(int age) {

        List<Person> list = new ArrayList<>();

        for(Person person : people) {
            if(person.getAge() == age) {
                list.add(person);
            }
        }

        Person[] array = list.toArray(new Person[0]);

        System.out.println(Arrays.toString(array));

        return array;
    }

    public void savePerson(String name, int age, String email) {
        Person person = new Person(name, age, email);
        people.add(person);
    }

    public PersonFormView getFormView() {
        return formView;
    }

    public SearchPersonView getSearchView() {
        return searchView;
    }

}
