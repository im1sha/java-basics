package by.bsuir.ovchelupov.task15;

import by.bsuir.ovchelupov.task12.task.Book;
import by.bsuir.ovchelupov.task15.task.BookTitleAuthorComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests BookTitleAuthorComparator class
 */
class BookTitleAuthorComparatorTest {

    /**
     * Test book price
     */
    private static final int DEFAULT_PRICE = 0;

    /**
     * Test book ISBN
     */
    private static final String DEFAULT_ISBN = "978-0-00-000000-0";

    /**
     * Creates test book
     *
     * @param title  Title of book
     * @param author Author of book
     * @return New test book
     */
    private Book createTestBook(String title, String author) {
        return new Book(title, author, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Tests compare() method
     */
    @Test
    void compare() {

        BookTitleAuthorComparator comparator = new BookTitleAuthorComparator();

        Book book11 = createTestBook("first", "first");
        Book book12 = createTestBook("first", "second");
        Book book21 = createTestBook("second", "first");
        Book book22 = createTestBook("second", "second");

        LinkedList<Book> manuallySortedList = new LinkedList<>();
        LinkedList<Book> comparatorSortedList = new LinkedList<>();

        assertEquals(0, comparator.compare(book11, book11));

        /* comparing by titles */
        Assertions.assertTrue(comparator.compare(book11, book22) < 0);
        Assertions.assertTrue(comparator.compare(book22, book12) > 0);

        /* comparing by authors, if titles are same */
        Assertions.assertTrue(comparator.compare(book11, book12) < 0);
        Assertions.assertTrue(comparator.compare(book22, book21) > 0);

        manuallySortedList.add(book11);
        manuallySortedList.add(book12);
        manuallySortedList.add(book21);
        manuallySortedList.add(book22);

        comparatorSortedList.add(book21);
        comparatorSortedList.add(book22);
        comparatorSortedList.add(book11);
        comparatorSortedList.add(book12);

        comparatorSortedList.sort(comparator);

        Assertions.assertEquals(manuallySortedList, comparatorSortedList);
    }
}