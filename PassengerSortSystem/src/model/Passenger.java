package model;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private int priority;
    private String id;
    private String section;
    private boolean isConfirmed;
    private String confirmationHour;

    public Passenger(String name, String id, int age, String section, int priority) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.id = id;
        this.section = section;
        this.isConfirmed = false;
        this.confirmationHour = "";
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

    public void setConfirmationHour(String confirmationHour) {
        this.confirmationHour = confirmationHour;
    }

    public String getConfirmationHour() {
        return confirmationHour;
    }

    public void confirmAssistance(){
        this.isConfirmed = true;
    }

    public String toString(){
        return "Name: "+ this.name + "\nSection: " + this.section + "\nArrival time: " + this.confirmationHour + "\nID: " + this.id + "\nAge: " + this.age + "\nPriority: " + this.priority + "\n";
    }

    @Override
    public int compareTo(Passenger o) {
        if (this.priority == o.getPriority()){
            return o.getConfirmationHour().hashCode() - confirmationHour.hashCode();
        }
        return this.priority - o.getPriority();
    }
}
