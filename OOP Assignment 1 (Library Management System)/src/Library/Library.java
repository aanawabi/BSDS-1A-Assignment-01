package Library;
//Relavant classes imported
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Book.Book;
import User.User;

//Library class definition
public class Library {
    //Lists 'Books' and 'Users' created that hold books and users
    private List<Book> books;
    private List<User> users;
    //File paths for storing data
    private final String booksFile = "books.txt";
    private final String usersFile = "users.txt";
    //Constructor of the library class that is initializing lists and calling methods
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loadBooks();
        loadUsers();
    }
    //Method to load books from file
    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(booksFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], parts[2], parts[3], Boolean.parseBoolean(parts[4]));
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to load users from file
    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                User user = new User(parts[0], parts[1], parts[2]);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("Book has been added successfully!");
    }
    //Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
        saveUsers();
        System.out.println("User has been added successfully!");
    }
    // Method to save books to file
    public void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(booksFile))) {
            for (Book book : books) {
                bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.isAvailable());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to save users to file
    public void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(usersFile))) {
            for (User user : users) {
                bw.write(user.getId() + "," + user.getName() + "," + user.getContact());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + (book.isAvailable() ? "Available" : "Not Available") + ")");
        }
    }
    // Method to borrow a book by a user
    public void borrowBook(String userId, String bookId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available for borrowing!");
            return;
        }

        book.setAvailable(false);
        user.addBorrowedBook(bookId);
        saveBooks();
    }
    
    // Method to return a borrowed book by a user
    public void returnBook(String userId, String bookId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!user.getBorrowedBooks().contains(bookId)) {
            System.out.println("User hasn't borrowed this book!");
            return;
        }

        book.setAvailable(true);
        user.returnBook(bookId);
        saveBooks();
    }
     // Method to find a book by its ID
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
     // Method to find a user by ID
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
  // Method to check if a book with the given ID already exists
  public boolean checkBookIdExists(String bookId) {
    for (Book book : books) {
        if (book.getId().equals(bookId)) {
            return true; // Book ID exists
        }
    }
    return false; // Book ID does not exist
}
 // Method to check if a user with the given ID already exists
 public boolean checkUserIdExists(String userId) {
    for (User user : users) {
        if (user.getId().equals(userId)) {
            return true; // User ID exists
        }
    }
    return false; // User ID does not exist
}
}