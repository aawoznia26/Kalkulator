package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return (Library)super.clone();

    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library copiedLibrary = (Library)super.clone();
        copiedLibrary.books = new HashSet<>();
        for(Book book : books){
            copiedLibrary.getBooks().add(new Book(book.getTitle(),book.getAuthor(), book.getPublicationDate()));
        }
        return copiedLibrary;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" +
                '\n' +
                books +
                '}';
    }
}
