package model;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private int priority;
    private String id;
    private String section;
    private boolean isConfirmed;
    private String confirmationHour;
    private String row;
    private String column;

    public Passenger(String name, String id, int age, String section, int priority, String row, String column) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.id = id;
        this.section = section;
        this.isConfirmed = false;
        this.confirmationHour = "";
        this.row = row;
        this.column = column;
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

    public String getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public void confirmAssistance(){
        this.isConfirmed = true;
    }

    public String toString(){
        return "Name: "+ this.name + "\nPosition: " + this.row + this.column +"\nSection: " + this.section + "\nArrival time: " + this.confirmationHour + "\nID: " + this.id + "\nAge: " + this.age + "\nPriority: " + this.priority + "\n";
    }

    @Override
    public int compareTo(Passenger o) {
        if (this.priority == o.getPriority()){
            System.out.println("Prioridad igual, entonces mi hora es igual a:" + ((this.priority - o.getPriority()) - (confirmationHour.compareTo(o.getConfirmationHour()))));
            return (this.priority - o.getPriority()) - (confirmationHour.compareTo(o.getConfirmationHour()));
        }
        System.out.println("Mi indice de prioridad es" + (this.priority - o.getPriority()));
        return this.priority - o.getPriority();
    }
}
