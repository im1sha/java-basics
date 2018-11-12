package by.bsuir.ovchelupov.task12;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Class for Book representation
 */
public class Book implements Comparable<Book>, Cloneable {

    /**
     * Book title
     */
    private String title;

    /**
     * Book author
     */
    private String author;

    /**
     * Book price
     */
    private int price;

    /**
     * Book edition
     */
    private static int edition;

    /**
     * Book ISBN
     */
    private String isbn;

    /**
     * Parts of ISBN
     */
    private final static int ISBN_PARTS = 5;

    /**
     * Checks if books equals
     *
     * @param object Object to compare
     * @return True if objects are the same, otherwise false
     */
    @Override
    public boolean equals(Object object) {
        Book book;

        if (object == this) {
            return true;
        }
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }

        book = (Book) object;
        return Objects.equals(book.author, this.author) &&
                Objects.equals(book.title, this.title) &&
                Objects.equals(book.isbn, this.isbn) &&
                (book.price == this.price);
    }

    /**
     * Generates hash code of this book
     *
     * @return Hash code of this book
     */
    @Override
    public int hashCode() {

        return Objects.hash(title, author, price, edition, isbn);
    }

    /**
     * Generates string representation of this book
     *
     * @return String representation of this book
     */
    @Override
    public String toString() {
        return getClass().getName() + "@title: " + title + ", author: " + author +
                ", price: " + price + ", edition: " + edition + ", ISBN: " + isbn;
    }

    /**
     * Creates and returns a copy of this object
     *
     * @return Copy of this object
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    /**
     * Sets edition of all the books
     *
     * @param edition Edition to set
     */
    public static void setEdition(int edition) {

        if (edition <= 0) {
            throw new IllegalArgumentException("Edition should be positive number");
        }

        Book.edition = edition;
    }

    /**
     * Gets book title
     *
     * @return Book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets book author
     *
     * @return Book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets book price
     *
     * @return Book price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets book edition
     *
     * @return Book edition
     */
    public static int getEdition() {
        return edition;
    }

    /**
     * Gets book ISBN
     *
     * @return Book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Checks if ISBN is correct
     *
     * @param isbn ISBN to check
     * @return True if ISBN is correct, otherwise false
     */
    private static boolean isIsbnCorrect(String isbn) {

        String[] splittedIsbn = isbn.split(Pattern.quote("-"));

        final int PARTS_IN_OLD_ISBN = 4;
        final int PARTS_IN_NEW_ISBN = 5;
        final int REQUIRED_LENGTH = 13;

        int indent = 0; // 1 if prefix 978 or 979 used
        int isbnLength = 0;

        if ((splittedIsbn.length != PARTS_IN_NEW_ISBN) &&
                (splittedIsbn.length != PARTS_IN_OLD_ISBN)) {
            return false;
        }

        // first part of new Isbn should be 978 or 979
        if (splittedIsbn.length == PARTS_IN_NEW_ISBN) {
            if (!splittedIsbn[0].matches("^97[89]$")) {
                return false;
            }
            indent = 1;
        }

        if (splittedIsbn.length == PARTS_IN_OLD_ISBN) {
            isbnLength += 3;
        }

        for (String s : splittedIsbn) {
            isbnLength += s.length();
        }

        return (isbnLength == REQUIRED_LENGTH)
                && splittedIsbn[indent].matches("^\\d{1,5}$")
                && splittedIsbn[1 + indent].matches("^\\d{2,7}$")
                && splittedIsbn[2 + indent].matches("^\\d{1,6}$")
                && splittedIsbn[3 + indent].matches("^[0-9X]$");
    }

    /**
     * Splits ISBN string to int array
     *
     * @param isbn ISBN string
     * @return Splitted ISBN
     */
    private static int[] splitIsbnToIntArray(String isbn) {

        final int DEFAULT_ISBN_FIRST_PART = 978;

        int[] result = new int[ISBN_PARTS];

        String[] splittedIsbn = isbn.replace("X", "10").split("-");
        int indent = 0;

        /* handling old 4-part ISBN */
        if (splittedIsbn.length == ISBN_PARTS - 1) {
            result[0] = DEFAULT_ISBN_FIRST_PART;
            indent = 1;
        }

        for (int i = indent; i < ISBN_PARTS; i++) {
            result[i] = Integer.parseInt(splittedIsbn[i - indent]);
        }

        return result;
    }

    /**
     * Compares two books by ISBN
     *
     * @param book Book to compare to this book
     * @return A negative integer, zero, or a positive integer as this book is less than,
     * equal to, or greater than the specified book
     */
    @Override
    public int compareTo(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("argument shouldn't be null");
        }

        int compareResult = 0;

        int[] thisIsbn = splitIsbnToIntArray(this.isbn);
        int[] otherIsbn = splitIsbnToIntArray(book.isbn);

        for (int i = 0; i < ISBN_PARTS; i++) {
            compareResult = Integer.compare(thisIsbn[i], otherIsbn[i]);
            if (compareResult != 0) {
                break;
            }
        }
        return compareResult;
    }

    /**
     * Constructor of book
     *
     * @param title  Title of book
     * @param author Author of book
     * @param price  Price of book
     * @param isbn   Book's isbn
     */
    public Book(String title, String author, int price, String isbn) {
        if (title == null) {
            throw new IllegalArgumentException("Title shouldn't be null");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author shouldn't be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN shouldn't be null");
        }
        if (!isIsbnCorrect(isbn)) {
            throw new IllegalArgumentException(("ISBN is not correct"));
        }

        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }
}