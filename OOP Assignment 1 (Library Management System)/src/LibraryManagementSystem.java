//Relavant Class Imports 
import Book.Book;
import User.User;
import Library.Library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//LibraryManagementSystem class Definition
public class LibraryManagementSystem { 
   //Main begins. Start of Library Management System Program
    public static void main(String[] args) { 
        Library library = new Library(); //Object 'library' of Library class created
        Scanner scanner = new Scanner(System.in); //Object scanner of Scanner class created for taking input from user
        int choice; //Variable 'choice' declared that stores user's choice of operation in the library system
        //Do-while loop begins that iterates until the Librarian decides to exit the system
        do {
            //Library menu that has different task options 
            System.out.println("\n\t\t\t\t\t\tWelcome to the Library Management System\n Please select one of the options listed below:" );
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
             
            //Error handling. This allows user to enter only numeric values
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume non-integer input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            //Switch statement that facilitate the user's option 
            switch (choice) {
                //User chooses to Add a Book
                case 1:
                    //User enters credentials of the book. A "newbook" object of class Book is created that stores the added book's attributes. 
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    if (!isNumeric(bookId)) {
                        System.out.println("Book ID must be numeric.");
                        break;
                    }
                    if (library.checkBookIdExists(bookId)) {
                        System.out.println("Book with this ID already exists.");
                        break;
                    }
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    if (isNumeric(author)) {
                        System.out.println("Author name cannot be numeric.");
                        break;
                    }
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    if (isNumeric(genre)) {
                        System.out.println("Genre cannot be numeric.");
                        break;
                    }
                    // A "newbook" object of class Book is created that stores the added book's attributes. 
                    Book newBook = new Book(bookId, title, author, genre, true);
                    //addBook function is called through the library object that adds the newbook to the library
                    library.addBook(newBook);
                    break;
                //User chooses to Add a Library User
                case 2:
                    //User enters credentials of the new user
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    if (!isNumeric(userId)) {
                        System.out.println("User ID must be numeric.");
                        break;

                    }
                    if (library.checkUserIdExists(userId)) {
                        System.out.println("User with this ID already exists.");
                        break;
                    }
                    
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                   String contact;
                   do {
                       System.out.print("Enter contact number: ");
                       contact = scanner.nextLine();
                       if (!isNumeric(contact) || contact.length() != 11) {
                           System.out.println("Contact must be numeric and 11 digits long.");
                       }
                    } while (!isNumeric(contact) || contact.length() != 11);

                    // A "newuser" object of class User is created that stores the added User's attributes. 
                    User newUser = new User(userId, name, contact);
                    // addUser function is called through the library object that adds the newuser to the library
                    library.addUser(newUser);
                    break;
                //User chooses to display all books available in the library
                case 3:
                    //displayBooks function is called through the library object that displays all the books of the library
                    System.out.println("Available Books:");
                    library.displayBooks();
                    break;
                //User chooses to Borrow a book from the Library
                case 4:
                    //User enters user Id of the person who wants to borrow the book and the book Id of the book to be borrowed
                    System.out.print("Enter user ID: ");
                    String borrowUserId = scanner.nextLine();
                    if (!isNumeric(borrowUserId)) {
                        System.out.println("User ID must be numeric.");
                        break;

                    }
                    System.out.print("Enter book ID to borrow: ");
                    String borrowBookId = scanner.nextLine();
                    if (!isNumeric(borrowBookId)) {
                        System.out.println("Book ID must be numeric.");
                        break;
                    }
                    //borrowBook function is called through the library object that allows the user to borrow a book from the library
                    library.borrowBook(borrowUserId, borrowBookId);
                    break;
                //User chooses to return a book to the Library
                case 5:
                    //User enters user Id of the person who wants to return the book and the book Id of the book to be returned
                    System.out.print("Enter user ID: ");
                    String returnUserId = scanner.nextLine();
                    if (!isNumeric(returnUserId)) {
                        System.out.println("User ID must be numeric.");
                        break;

                    }
                    System.out.print("Enter book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    if (!isNumeric(returnBookId)) {
                        System.out.println("Book ID must be numeric.");
                        break;
                    }
                    //returnBook function is called through the library object that allows the user to return a book to the library
                    library.returnBook(returnUserId, returnBookId);
                    break;
                //User chooses to exit the system
                case 6:
                    System.out.println("Exited");
                    break;
                //If the user enters any option other than 1-6, an error message is displayed
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 6); //Loop condition. The loop keeps iterating until the user chooses option 6.
    }
    
       // Define the isNumeric method
       private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); 
        
    }
}

