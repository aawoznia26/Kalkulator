package com.kodilla.testing.library;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOf1Book() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);

        Map<LibraryUser, List<Book>> booksInHandsOf = new HashMap<LibraryUser, List<Book>>();

        LibraryUser user1 = new LibraryUser("Marcin", "Krasnodębski", "8392837272743");
        LibraryUser user2 = new LibraryUser("Kacper", "Baran", "8499372637484");

        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1987);

        List<Book> user1List = new ArrayList<>(Arrays.asList(book1));
        List<Book> user2List = new ArrayList<>(Arrays.asList(book2, book3, book4,book5));


        booksInHandsOf.put(user1, user1List);
        booksInHandsOf.put(user2, user2List);


        when(libraryDatabaseMock.listBooksInHandsOf(user1))
                .thenReturn(user1List);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user1);

        // Then
        assertEquals(1, theListOfBooks.size());

    }

    @Test
    public void testListBooksInHandsOf5Book() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);

        Map<LibraryUser, List<Book>> booksInHandsOf = new HashMap<LibraryUser, List<Book>>();

        LibraryUser user1 = new LibraryUser("Marcin", "Krasnodębski", "8392837272743");
        LibraryUser user2 = new LibraryUser("Kacper", "Baran", "8499372637484");

        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1987);

        List<Book> user1List = new ArrayList<>(Arrays.asList());
        List<Book> user2List = new ArrayList<>(Arrays.asList(book1, book2, book3, book4,book5));


        booksInHandsOf.put(user1, user1List);
        booksInHandsOf.put(user2, user2List);


        when(libraryDatabaseMock.listBooksInHandsOf(user2))
                .thenReturn(user2List);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user2);

        // Then
        assertEquals(5, theListOfBooks.size());

    }


    @Test
    public void testListBooksInHandsOf0Book() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);

        Map<LibraryUser, List<Book>> booksInHandsOf = new HashMap<LibraryUser, List<Book>>();

        LibraryUser user1 = new LibraryUser("Marcin", "Krasnodębski", "8392837272743");
        LibraryUser user2 = new LibraryUser("Kacper", "Baran", "8499372637484");

        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1987);

        List<Book> user1List = new ArrayList<>(Arrays.asList());
        List<Book> user2List = new ArrayList<>(Arrays.asList(book1, book2, book3, book4,book5));


        booksInHandsOf.put(user1, user1List);
        booksInHandsOf.put(user2, user2List);


        when(libraryDatabaseMock.listBooksInHandsOf(user1))
                .thenReturn(user1List);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user1);

        // Then
        assertEquals(0, theListOfBooks.size());

    }
}
