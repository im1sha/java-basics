package by.bsuir.ovchelupov.task15;


import by.bsuir.ovchelupov.task12.task.Book;
import by.bsuir.ovchelupov.task15.task.BookPriceComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Tests BookPriceComparator class
 */
class BookPriceComparatorTest {

    /**
     * Test book title
     */
    private static final String DEFAULT_TITLE = "title";

    /**
     * Test book author
     */
    private static final String DEFAULT_AUTHOR = "author";

    /**
     * Test book ISBN
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book
     *
     * @param price Price of test book
     * @return New test book
     */
    private Book createTestBook(int price) {
        return new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, price, DEFAULT_ISBN);
    }

    /**
     * Tests compare() method
     */
    @Test
    void compare() {
        BookPriceComparator comparator = new BookPriceComparator();

        Book book1 = createTestBook(1);
        Book book2 = createTestBook(2);
        Book book3 = createTestBook(3);

        LinkedList<Book> manuallySortedList = new LinkedList<>();
        LinkedList<Book> comparatorSortedList = new LinkedList<>();

        Assertions.assertEquals(0, comparator.compare(book1, book1));
        Assertions.assertTrue(comparator.compare(book1, book2) < 0);
        Assertions.assertTrue(comparator.compare(book3, book2) > 0);

        manuallySortedList.add(book1);
        manuallySortedList.add(book2);
        manuallySortedList.add(book3);

        comparatorSortedList.add(book3);
        comparatorSortedList.add(book2);
        comparatorSortedList.add(book1);

        comparatorSortedList.sort(comparator);

        Assertions.assertEquals(manuallySortedList, comparatorSortedList);
    }
}