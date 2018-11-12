package by.bsuir.ovchelupov.task15;


import by.bsuir.ovchelupov.task12.task.Book;
import by.bsuir.ovchelupov.task15.task.BookAuthorTitlePriceComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Tests for BookAuthorTitlePriceComparator class
 */
class BookAuthorTitlePriceComparatorTest {

    /**
     * Test book ISBN
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book
     *
     * @param title  Title of book
     * @param author Author of book
     * @param price  Price of book
     * @return New test book
     */
    private Book createTestBook(String title, String author, int price) {
        return new Book(title, author, price, DEFAULT_ISBN);
    }

    /**
     * Tests compare() method
     */
    @Test
    void compare() {
        BookAuthorTitlePriceComparator comparator = new BookAuthorTitlePriceComparator();

        Book book111 = createTestBook("first", "first", 1);
        Book book112 = createTestBook("first", "first", 2);
        Book book121 = createTestBook("first", "second", 1);
        Book book122 = createTestBook("first", "second", 2);
        Book book211 = createTestBook("second", "first", 1);
        Book book212 = createTestBook("second", "first", 2);
        Book book221 = createTestBook("second", "second", 1);
        Book book222 = createTestBook("second", "second", 2);

        LinkedList<Book> manuallySortedList = new LinkedList<>();
        LinkedList<Book> comparatorSortedList = new LinkedList<>();

        Assertions.assertEquals(0, comparator.compare(book111, book111));

        /* comparing by authors */
        Assertions.assertTrue(comparator.compare(book111, book121) < 0);
        Assertions.assertTrue(comparator.compare(book122, book112) > 0);

        /* comparing by titles, if authors are same */
        Assertions.assertTrue(comparator.compare(book111, book211) < 0);
        Assertions.assertTrue(comparator.compare(book221, book121) > 0);

        /* comparing by price, if authors are same and titles are same */
        Assertions.assertTrue(comparator.compare(book111, book112) < 0);
        Assertions.assertTrue(comparator.compare(book222, book221) > 0);

        manuallySortedList.add(book111);
        manuallySortedList.add(book112);
        manuallySortedList.add(book211);
        manuallySortedList.add(book212);
        manuallySortedList.add(book121);
        manuallySortedList.add(book122);
        manuallySortedList.add(book221);
        manuallySortedList.add(book222);

        comparatorSortedList.add(book111);
        comparatorSortedList.add(book112);
        comparatorSortedList.add(book121);
        comparatorSortedList.add(book122);
        comparatorSortedList.add(book211);
        comparatorSortedList.add(book212);
        comparatorSortedList.add(book221);
        comparatorSortedList.add(book222);

        comparatorSortedList.sort(comparator);

        Assertions.assertEquals(manuallySortedList, comparatorSortedList);
    }
}