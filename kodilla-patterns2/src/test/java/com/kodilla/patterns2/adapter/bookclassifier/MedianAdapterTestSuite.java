package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian(){
        //Given
        Set<Book> booksA = new HashSet<>();
        booksA.add(new Book("Jim Brown", "Under Pressure", 2009, "HSNDKOS"));
        booksA.add(new Book("Katrin Johns", "Be quiet", 2017, "NJKSIID"));
        booksA.add(new Book("Michael Stat", "Nothing at all", 1999, "OAJNNE9"));
        booksA.add(new Book("Katrin Johns", "Be quiet", 1936, "NJKSIID"));
        booksA.add(new Book("Michael Stat", "Nothing at all", 1956, "OAJNNE9"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(booksA);

        //Then
        System.out.println(median);
        assertEquals(median, 1999);
    }
}
