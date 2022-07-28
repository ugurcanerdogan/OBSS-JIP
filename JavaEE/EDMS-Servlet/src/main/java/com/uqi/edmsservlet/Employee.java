package com.uqi.edmsservlet;

//public record Employee(int id, String name, String surname, String title, int birth_year) {
//}

public class Employee {

    public int id;
    public String name;
    public String surname;
    public String title;
    public int birth_year;

    public Employee(int id, String name, String surname, String title, int birth_year) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.birth_year = birth_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }
}

