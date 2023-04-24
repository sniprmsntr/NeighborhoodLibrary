package org.yearup;

import java.util.Scanner;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create inventory of books
        Book[] inventory = new Book[5];
        inventory[0] = new Book(1, "9780143108274", "To Kill a Mockingbird");
        inventory[1] = new Book(2, "9780307277679", "The Catcher in the Rye");
        inventory[2] = new Book(3, "9780486424619", "Pride and Prejudice");
        inventory[3] = new Book(4, "9780061120084", "1984");
        inventory[4] = new Book(5, "9780547928227", "The Hobbit");

        // Loop to allow users to check out and check in books
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("What would you like to do?");
            System.out.println("1. Check out a book");
            System.out.println("2. Check in a book");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the title of the book you want to check out:");
                    String title = scanner.nextLine();
                    for (Book book : inventory) {
                        if (book.getTitle().equals(title)) {
                            System.out.println("Enter your name:");
                            String name = scanner.nextLine();
                            book.checkOut(name);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the title of the book you want to check in:");
                    title = scanner.nextLine();
                    for (Book book : inventory) {
                        if (book.getTitle().equals(title)) {
                            book.checkIn();
                            break;
                        }
                    }
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thanks for using the Neighborhood Library!");
    }
}

class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Methods
    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println(title + " checked out to " + name);
        } else {System.out.println(title + " is already checked out by " + checkedOutTo);
        }
    }

    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println(title + " checked in.");
        } else {
            System.out.println(title + " is already checked in.");
        }
    }}

