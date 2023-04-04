package model;

//import exceptions.EmptyFieldException;

import java.util.Comparator;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) /*throws EmptyFieldException*/{
        if(name == null || name.isEmpty()
                || phone == null || phone.isEmpty()
                || email == null || email.isEmpty())
        {
            //throw new EmptyFieldException();
        }
        else {
            Integer.parseInt(phone);
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return " Name: " + this.name ;
    }

}
