package by.bsuir.ovchelupov.task12;

import by.bsuir.ovchelupov.utils.Scanner;

public class Runner {

    /**
     * Creates book by user input
     *
     * @return Book generated by user input
     */
    private static Book inputAndCreateBook() {
        String author;
        String title;
        int price;
        String isbn;

        var Scanner = new Scanner();

        System.out.print("Enter book title: ");
        title = Scanner.getString();

        System.out.print("Enter book author: ");
        author = Scanner.getString();

        System.out.print("Enter book price: ");
        price = Scanner.getNonNegativeInt();

        System.out.print("Enter book ISBN: ");
        isbn = Scanner.getString();

        return new Book(title, author, price, isbn);
    }

    /**
     * Starts application
     *
     * @param args command line arguments, not in use
     */
    public static void main(String[] args) {
        Book book1;
        Book book2;

        try {
            System.out.println("Fill book 1 info");
            book1 = inputAndCreateBook();

            System.out.println("Fill book 2 info");
            book2 = inputAndCreateBook();

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
            return;
        }

        System.out.print("Enter book edition: ");
        var Scanner = new Scanner();
        Book.setEdition(Scanner.getNonNegativeInt());

        System.out.println("Are books equal? " + book1.equals(book2));

        System.out.println("Books hash codes:");
        System.out.println("\tBook 1: " + book1.hashCode());
        System.out.println("\tBook 2: " + book2.hashCode());

        System.out.println("Books string representation:");
        System.out.println("\tBook 1: " + book1.toString());
        System.out.println("\tBook 2: " + book2.toString());

        System.out.println("Book 1 to book 2 compare result: " + book1.compareTo(book2));
    }

    /**
     * Constructor to avoid instance creation
     */
    private Runner() {
    }
}
