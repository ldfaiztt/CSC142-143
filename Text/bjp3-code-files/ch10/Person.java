// Class Person records the name and immediate blood relations of an
// individual (mother, father, children).

import java.util.*;

public class Person {
    private String name;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;

    // post: constructs a person object with no family links
    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<Person>();
    }

    // post: returns this person's name
    public String getName() {
        return this.name;
    }

    // post: returns this person's mother (null if not known)
    public Person getMother() {
        return this.mother;
    }

    // post: returns this person's father (null if not known)
    public Person getFather() {
        return this.father;
    }

    // post: returns this person's list of children
    public ArrayList<Person> getChildren() {
        return this.children;
    }

    // post: records the mother of this person
    public void setMother(Person mother) {
        this.mother = mother;
    }

    // post: records the fathher of this person
    public void setFather(Person father) {
        this.father = father;
    }

    // post: records another child of this  person
    public void addChild(Person child) {
        this.children.add(child);
    }
}
