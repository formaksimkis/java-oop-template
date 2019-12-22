package com.epam.izh.rd.online.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс содержащий информацию об авторе.
 *
 * Необходимо:
 * 1) Создать список полей с указанными типами ровно в этом порядке:
 * - name с типом String и приватным модификатором доступа
 * - lastName с типом String и приватным модификатором доступа
 * - birthdate с типом LocalDate и приватным модификатором доступа
 * - country с типом String и приватным модификатором доступа
 * 2) Создать дефолтный конструктор (без параметров) (не забывайте alt+inset)
 * 3) Создать конструктор со всеми параметрами (в том порядке в котором перечислены) (не забывайте alt+inset)
 * 4) Создать геттеры и сеттеры (не забывайте alt+inset)
 * 5) Переопределить методы equals и hashCode - используйте генерацию (не забывайте alt+inset)
 * 6) Переопределить метод toString с выводом всех полей (не забывайте alt+inset)
 */
public class Author {

    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String country;

    /**
     * Constructor by default
    */
    public Author() {
        name = "";
        lastName = "";
        birthdate = LocalDate.MAX;
        country = "";
    }

    /**
     * Constructor with params
     */
    public Author(String name, String lastName, LocalDate birthdate, String country) {
        this.name = (name != null) ? name : "";
        this.lastName = (lastName != null) ? lastName : "";
        this.birthdate = (birthdate != null) ? birthdate : LocalDate.MAX;
        this.country = (country != null) ? country : "";
    }

    /**
     * Get author's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get author's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get author's birth date
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Get country where the author from
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set author's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set author's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set author's birth date
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Set country where the author from
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Compare two author's objects  by name, last name, birth date, country
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) &&
                lastName.equals(author.lastName) &&
                birthdate.equals(author.birthdate) &&
                country.equals(author.country);
    }

    /**
     * Get author's object hash code calculated from name, lastName, birthDate, country
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthdate, country);
    }

    /**
     *  Get string representing of author's object
     */
    @Override
    public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", birthDate=" + birthdate +
                    ", country='" + country + '\'' +
                    '}';
    }
}
