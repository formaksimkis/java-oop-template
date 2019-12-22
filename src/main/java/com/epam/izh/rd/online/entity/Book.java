package com.epam.izh.rd.online.entity;

import java.util.Objects;

/**
 * Базовая сущность для книги. Содержит базовые поля.
 *
 * Необходимо:
 * 1) Создать список полей с указанными типами ровно в этом порядке:
 * - numberOfPages с типом int и приватным модификатором доступа
 * - name с типом String и приватным модификатором доступа
 * 2) Создать дефолтный конструктор (без параметров) (не забывайте alt+inset)
 * 3) Создать конструктор со всеми параметрами (в том порядке в котором перечислены) (не забывайте alt+inset)
 * 4) Создать геттеры и сеттеры (не забывайте alt+inset)
 * 5) Переопределить методы equals и hashCode - используйте генерацию (не забывайте alt+inset)
 * 6) Переопределить метод toString с выводом всех полей (не забывайте alt+inset)
 */
public abstract class Book {
    private int numberOfPages;
    private String name;

    /**
     * Constructor by default
     */
    public Book() {
        numberOfPages = 0;
        name = "";
    }

    /**
     * Constructor with params
     */
    public Book(int numberOfPages, String name) {
        this.numberOfPages = numberOfPages;
        this.name = (name != null) ? name : "";
    }

    /**
     * Get number of pages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Get book's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set book's number of pages
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Set book's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compare two book's objects by name and number of pages
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages &&
                Objects.equals(name, book.name);
    }

    /**
     * Get book's object hash code calculated from name and number of pages
     */
    @Override
    public int hashCode() {
        return Objects.hash(numberOfPages, name);
    }

    /**
     *  Get string representing of book's object
     */
    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                ", name='" + name + '\'' +
                '}';
    }
}
