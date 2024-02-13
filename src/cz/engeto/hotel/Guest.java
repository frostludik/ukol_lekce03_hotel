package cz.engeto.hotel;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String name, surname;
    private LocalDate birthDate;

    public Guest(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return birthDate.format(formatter);
    }

    public String getNameAndSurnameWithBirthdate() {
        return name+" "+surname+" (birthdate: "+getFormattedDate()+")";
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        if(name == null) {
            return "no other guest";
        } else {
            return getNameAndSurnameWithBirthdate();
        }
    }
}
