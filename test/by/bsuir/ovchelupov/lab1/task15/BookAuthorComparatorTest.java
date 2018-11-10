package by.bsuir.ovchelupov.lab1.task15;


import by.bsuir.ovchelupov.lab1.task12.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Tests for BookAuthorComparator class
 */
class BookAuthorComparatorTest {
    /**
     * Test book title
     */
    private static final String DEFAULT_TITLE = "title";

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
     * @param author Author of test book
     * @return New test book
     */
    private Book createTestBook(String author) {
        return new Book(DEFAULT_TITLE, author, DEFAULT_PRICE, DEFAULT_ISBN);
    }

    /**
     * Tests for compare() method
     */
    @Test
    void compare() {
        BookAuthorComparator comparator = new BookAuthorComparator();
        Book book1 = createTestBook("first"),
                book2 = createTestBook("second"),
                book3 = createTestBook("third");
        ArrayList<Book> manuallySortedList = new ArrayList<>(),
                comparatorSortedList = new ArrayList<>();

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