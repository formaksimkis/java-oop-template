package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

public class SimpleAuthorService implements AuthorService {
    /**
     * Repository for manipulation with authors
     */
    private AuthorRepository authorRepository;

    /**
     * Constructor by default
     */
    public SimpleAuthorService() {
        authorRepository = new SimpleAuthorRepository();
    }

    /**
     * Constructor with params
     */
    public SimpleAuthorService(AuthorRepository authorRepository) {
        if (authorRepository != null) {
            this.authorRepository = authorRepository;
        } else this.authorRepository = new SimpleAuthorRepository();

    }

    /**
     * Save the author by using the same method in SimpleAuthorRepository class
     */
    @Override
    public boolean save(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Find the author by name and last name using the same method in SimpleAuthorRepository class
     */
    @Override
    public Author findByFullName(String name, String lastname) {
        return authorRepository.findByFullName(name, lastname);
    }

    /**
     * Remove the author by using the same method in SimpleAuthorRepository class
     */
    @Override
    public boolean remove(Author author) {
        return authorRepository.remove(author);
    }

    /**
     * Count of the authors repository by using the same method in SimpleAuthorRepository class
     */
    @Override
    public int count() {
        return authorRepository.count();
    }
}
