package by.bsuir.ovchelupov.lab1.task15;

import by.bsuir.ovchelupov.lab1.task12.Book;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparator that compares two books by title, then by author
 */
public class BookTitleAuthorComparator implements Comparator<Book> {
    /**
     * Full comparator that contains two others
     */
    private final Comparator<Book> fullComparator;

    /**
     * Compares two books
     *
     * @param book1 First book
     * @param book2 Second book
     * @return Negative integer, zero, or a positive integer as the first book is less than, equal to, or greater than
     * the second
     */
    @Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return fullComparator.compare(book1, book2);
    }

    /**
     * Generates string representation of comparator
     *
     * @return String representation of comparator
     */
    @Override
    public String toString() {
        return getClass().getName();
    }

    /**
     * Checks if comparator equals to specified object
     *
     * @param obj Object to check
     * @return True if comparator equals to specified object, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (getClass() == obj.getClass());
    }

    /**
     * Generates hash code of comparator
     *
     * @return Hash code of comparator
     */
    @Override
    public int hashCode() {
        return Objects.hash(fullComparator);
    }

    /**
     * Constructor of comparator
     */
    public BookTitleAuthorComparator() {
        fullComparator = new BookTitleComparator().thenComparing(new BookAuthorComparator());
    }
}

