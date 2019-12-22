package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {
    /**
     * Mass of authors for keeping
     */
    private Author[] authors;

    /**
     * Constructor by default
     */
    public SimpleAuthorRepository() {
        authors = new Author[0];
    }

    /**
     * Constructor with params
     */
    public SimpleAuthorRepository(Author[] authors) {
        this.authors = new Author[0];
        for (Author elem : authors) {
            this.save(elem);
        }
    }

    /**
     * Save the author to the end of mass if it's not null, name and last name not empty
     * and if this author is unique for mass (repository)
     * return mass with (size + 1) if success
     */
    @Override
    public boolean save(Author author) {
        if ((author != null) && !author.getName().equals("") && !author.getLastName().equals("")
                && (this.findByFullName(author.getName(), author.getLastName()) == null)) {
            Author[] copyOfAuthors = new Author[authors.length + 1];
            for (int i = 0; i < authors.length; i++) {
                copyOfAuthors[i] = authors[i];
            }
            copyOfAuthors[copyOfAuthors.length - 1] = author;
            authors = copyOfAuthors;
            return true;
        } else return false;
    }

    /**
     * Find the author by his name and last name
     * There is no need to check empty or null name and last name, because
     * repository saved only authors with not empty and not null name and last name
     */
    @Override
    public Author findByFullName(String name, String lastname) {
        for(Author author : authors) {
            if ((author.getName().equals(name)) && (author.getLastName().equals(lastname))){
                return author;
            } else continue;
        }
        return null;
    }

    /**
     * Remove the author if it's not null and it's contained
     * inside the repository, return mass with (size - 1) if success
     */
    @Override
    public boolean remove(Author author) {
        if (author != null) {
            int counterOfCopied = 0;
            Author[] copyOfAuthors = {};
            Author findAuthorForRemove = this.findByFullName(author.getName(), author.getLastName());
            if ((findAuthorForRemove) != null) {
                copyOfAuthors = new Author[authors.length - 1];
                for (Author elem : authors) {
                    if (!(elem.getName().equals(findAuthorForRemove.getName()) &&
                            elem.getLastName().equals(findAuthorForRemove.getLastName()))) {
                        copyOfAuthors[counterOfCopied] = elem;
                        counterOfCopied++;
                    } else continue;
                }
                authors = copyOfAuthors;
                return true;
            } else return false;
        } else return false;
    }

    /**
     * Return count of author's repository
     */
    @Override
    public int count() {
        return ((authors != null) ? authors.length : 0);
    }
}
