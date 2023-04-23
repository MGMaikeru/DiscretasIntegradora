package model;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private int priority;
    private String id;
    private String section;
    private boolean isConfirmed;

    public Passenger(String name, String id, int age, String section, int priority) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.id = id;
        this.section = section;
        this.isConfirmed = false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }
    public void confirmAssistance(){
        this.isConfirmed = true;
    }

    public String toString(){
        return "Name: "+ this.name + "\nSection: " + this.section + "\nID: " + this.id + "\nAge: " + this.age + "\nPriority: " + this.priority + "\n";
    }

    @Override
    public int compareTo(Passenger o) {
        return this.priority - o.getPriority();
    }
}
