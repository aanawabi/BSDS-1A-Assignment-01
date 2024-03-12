package User;
//Relavant classes imported
import java.util.ArrayList;
import java.util.List;
//User class definition
public class User {
    //Instance variables (attributes) of the class User are declared
    private String id;
    private String name;
    private String contact;
    private List<String> borrowedBooks;
    ///Constructor of User class that takes the class' attributes as parameter
    public User(String id, String name, String contact) {
        //checks whether the user ID is numeric. If not, it throws an IllegalArgumentException.
        //checks whether the contact number is numeric and 11 digits long. If not, it throws an IllegalArgumentException.
        if (!isNumeric(id)) {
            throw new IllegalArgumentException("User ID must be numeric.");
        }
        if (!isNumeric(contact) || contact.length() != 11) {
            throw new IllegalArgumentException("Contact must be numeric and 11 digits long.");
        }
        //Assigning values passed through constructor to corresponding instance variables
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>();
    }
    //Getter method for retrieving the ID of the user 
    public String getId() {
        return id;
    }
    //Getter method for retrieving the name of the user
    public String getName() {
        return name;
    }
    //Getter method for retrieving the contact of the user
    public String getContact() {
        return contact;
    }
    //Getter method for retrieving the list of borrowed books by the user
    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }
    //Method to add a borrowed book to the user's list of borrowed books
    public void addBorrowedBook(String bookId) {
        borrowedBooks.add(bookId);
    }
    //Method to return a borrowed book and remove it from the user's list of borrowed books
    public void returnBook(String bookId) {
        borrowedBooks.remove(bookId);
    }
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}

