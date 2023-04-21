package model;

public class Passenger {
    private String name;
    private int age;
    private int priority;
    private String id;

    public Passenger(String name, String id, int age, int priority) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.id = id;
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
}
