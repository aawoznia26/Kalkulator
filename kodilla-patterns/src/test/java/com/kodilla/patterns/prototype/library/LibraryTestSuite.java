package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Ekonomia");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Książka " + n, "Autor " + n,
                        LocalDate.of(1998, 8, 1 + n))));

        Book toRemoveBook = new Book ("Do usunięcia", "Do usunięcia",
                LocalDate.of(1900,1,1));
        library.getBooks().add(toRemoveBook);

        //When
        Library shallowLibraryCopy = null;
        try {
            shallowLibraryCopy = library.shallowCopy();
            shallowLibraryCopy.setName("shallowLibraryCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepLibraryCopy = null;
        try {
            deepLibraryCopy = library.deepCopy();
            deepLibraryCopy.setName("deepLibraryCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(toRemoveBook);
        //Then

        System.out.println(library);
        System.out.println(shallowLibraryCopy);
        System.out.println(deepLibraryCopy);

        Assert.assertEquals(5, shallowLibraryCopy.getBooks().size());
        Assert.assertEquals(6, deepLibraryCopy.getBooks().size());
    }
}
