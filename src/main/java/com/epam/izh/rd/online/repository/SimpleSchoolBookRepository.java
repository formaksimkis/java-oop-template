package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    /**
     * Mass of school book for keeping
     */
    private SchoolBook[] schoolBooks;

    /**
     * Constructor by default
     */
    public SimpleSchoolBookRepository() {
        schoolBooks = new SchoolBook[0];
    }

    /**
     * Constructor with params
     */
    public SimpleSchoolBookRepository(SchoolBook[] schoolBooks) {
        this.schoolBooks = new SchoolBook[0];
        for (SchoolBook elem : schoolBooks) {
            this.save(elem);
        }
    }

    /**
     * Save schoolbook to the end of mass if it's not null, name not empty
     * and does not check this book is unique for mass (repository)
     * return mass with (size + 1) if success
     */
    @Override
    public boolean save(SchoolBook book) {
        if ((book != null) && (!book.getName().equals(""))){
            SchoolBook[] copyOfBooks = new SchoolBook[this.count() + 1];
            for (int i = 0; i < this.count(); i++) {
                copyOfBooks[i] = schoolBooks[i];
            }
            copyOfBooks[copyOfBooks.length - 1] = book;
            schoolBooks = copyOfBooks;
            return true;
        } else  return  false;
    }

    /**
     * Find schoolbook by name
     * There is no need to check empty or null name, because
     * repository saves only books with not empty and not null name of books
     */
    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] foundSchoolBook = new SchoolBook[this.count()];
        int countFoundBooks = 0;
        for (SchoolBook elem : schoolBooks) {
            if (elem.getName().equals(name)) {
                foundSchoolBook[countFoundBooks] = elem;
                countFoundBooks++;
            } else continue;
        }
        if (countFoundBooks > 0) {
            foundSchoolBook = Arrays.copyOfRange(foundSchoolBook, 0, countFoundBooks);
            return foundSchoolBook;
        } else {
            return new SchoolBook[0];
        }
    }

    /**
     * Remove schoolbook if it's not null and it's contained
     * inside the repository, return mass with (size - 1) if success
     */
    @Override
    public boolean removeByName(String name) {
        if (name != null) {
            int counterOfCopied = 0;
            SchoolBook[] copyOfBooks = {};
            SchoolBook[] findBooksForRemove = this.findByName(name);
            if ((findBooksForRemove.length) > 0) {
                copyOfBooks = new SchoolBook[this.count() - findBooksForRemove.length];
                for (SchoolBook elem : schoolBooks) {
                    if (!elem.getName().equals(name)) {
                        copyOfBooks[counterOfCopied] = elem;
                        counterOfCopied++;
                    } else continue;
                }
                schoolBooks = copyOfBooks;
                return true;
            } else return false;
        } else return false;
    }

    /**
     * Return count of schoolbook's repository
     */
    @Override
    public int count() {
        return ((schoolBooks != null) ? schoolBooks.length : 0);
    }
}
