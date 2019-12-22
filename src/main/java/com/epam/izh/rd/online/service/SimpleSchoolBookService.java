package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;

public class SimpleSchoolBookService implements BookService{
    /**
     * Schoolbook repository for manipulation with schoolbooks (save, remove, find)
     */
    private BookRepository<SchoolBook> schoolBookBookRepository;

    /**
     * Execute business logic and working with authors and interacting with authors repository
     */
    private AuthorService authorService;

    /**
     * Constructor by default
     */
    public SimpleSchoolBookService() {
        schoolBookBookRepository = new SimpleSchoolBookRepository();
        authorService = new SimpleAuthorService();
    }

    /**
     * Constructor with params
     */
    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = (schoolBookBookRepository != null) ? schoolBookBookRepository : new SimpleSchoolBookRepository();
        this.authorService = (authorService != null) ? authorService : new SimpleAuthorService();
    }

    /**
     * Save schoolbook if it's not null and the author of this book contained in authors repository
     * Return true if success, false in other cases
     */
    @Override
    public boolean save(Book book) {
        book = (book instanceof SchoolBook) ? ((SchoolBook) book) : null;
        if ((book != null) && (authorService.findByFullName(((SchoolBook) book).getAuthorName(),
                ((SchoolBook) book).getAuthorLastName())) != null) {
           return schoolBookBookRepository.save((SchoolBook) book);
        } else return false;
    }

    /**
     * Find the schoolbook by name
     * using the same method in SimpleSchoolBookRepository class
     */
    @Override
    public Book[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    /**
     * Find the schoolbook number by name using the method
     * findByName() in SimpleSchoolBookRepository class
     */
    @Override
    public int getNumberOfBooksByName(String name) {
        return schoolBookBookRepository.findByName(name).length;
    }

    /**
     * Remove the schoolbook number by name using the same method
     * in SimpleSchoolBookRepository class
     */
    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    /**
     * Calculate count of schoolbooks in repository
     */
    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }

    /**
     * Find author in authors repository by book's name in books repository
     */
    @Override
    public Author findAuthorByBookName(String name) {
        return (schoolBookBookRepository.findByName(name).length > 0) ?
                (authorService.findByFullName(schoolBookBookRepository.findByName(name)[0].getAuthorName(),
                        schoolBookBookRepository.findByName(name)[0].getAuthorLastName())) : null;
    }
}
