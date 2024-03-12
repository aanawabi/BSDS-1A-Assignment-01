# BSDS-1A-Assignment-01-Library Management System
Library Management System 
> Description:
The Library Management System is a Java project designed to manage a library's inventory of books and users. It allows librarians to add books and users, display available books, borrow books, return books, and exit the system.

Setup and Running Instructions:
> Prerequisites:
1. Java Development Kit (JDK)
2. Text editor or an Integrated Development Environment (IDE) 

> Steps:
1.	Clone or download the project files from the repository.
2.	Open the project in your preferred IDE or text editor.
3.	Compile the Java files.
4.	Run the LibraryManagementSystem class to start the program.
5.	Follow the on-screen instructions to perform various library management tasks.

> Key Features and Functionalities:
1. User Class:
Represents a library user with attributes such as ID, name, contact, and a list of borrowed books and provides methods to add and return borrowed books.
2. Book Class:
Represents a book with attributes including ID, title, author, genre, and availability status and provides methods to retrieve book information and update availability.
3. Library Class:
Manages the library inventory, including lists of books and users and provides methods to add books and users, display available books, borrow books, return books, and find books or users by ID. It also reads data from and writes data to text files for persistent storage.
4. LibraryManagementSystem Class:
Contains the main method to run the library management system It presents a user-friendly interface to interact with the library, allowing users to add books and users, display available books, borrow books, return books, and exit the system. It implements error handling for invalid inputs and existing IDs during user interactions.

> Error Handling:
1. Invalid Input: The program ensures that users enter valid numeric inputs for IDs and contact numbers.
2. Existing ID: Checks if a book or user with the same ID already exists in the library before adding a new one.
___________________________________________________________________________________________________________________________________________________________________________

Method Descriptions:
> User Class Methods:
1. Constructor - public User(String id, String name, String contact)
•	Description: Initializes a new User object with the provided ID, name, and contact information.
•	Error Handling: Checks whether the user ID is numeric. Throws an IllegalArgumentException if it's not numeric and checks whether the contact number is numeric and 11 digits long. Throws an IllegalArgumentException if it's not numeric or not 11 digits long.
2. public String getId()
•	Description: Retrieves the ID of the user.
•	Returns: A string representing the user's ID.
3. public String getName()
•	Description: Retrieves the name of the user.
•	Returns: A string representing the user's name.
4. public String getContact()
•	Description: Retrieves the contact number of the user.
•	Returns: A string representing the user's contact number.
5. public List<String> getBorrowedBooks()
•	Description: Retrieves the list of borrowed books by the user.
•	Returns: A list of strings representing the IDs of the books borrowed by the user.
6. public void addBorrowedBook(String bookId)
•	Description: Adds a book to the user's list of borrowed books.
•	Parameters: bookId: A string representing the ID of the book to be added.
7. public void returnBook(String bookId)
•	Description: Removes a book from the user's list of borrowed books (i.e., returns the book).
•	Parameters: bookId: A string representing the ID of the book to be returned.
8. Private Helper Method - private static boolean isNumeric(String str)
•	Description: Checks if a given string is numeric.
•	Parameters: str: The string to be checked.
•	Returns: true if the string is numeric, false otherwise.

> Book Class Methods:
1. Constructor - public Book(String id, String title, String author, String genre, boolean available)
•	Description: Initializes a new Book object with the provided ID, title, author, genre, and availability status.
•	Parameters:
•	id: A string representing the book's ID.
•	title: A string representing the book's title.
•	author: A string representing the book's author.
•	genre: A string representing the book's genre.
•	available: A boolean indicating the availability status of the book.
2. public String getId()
•	Description: Retrieves the ID of the book.
•	Returns: A string representing the book's ID.
3. public String getTitle()
•	Description: Retrieves the title of the book.
•	Returns: A string representing the book's title.
4. public String getAuthor()
•	Description: Retrieves the author of the book.
•	Returns: A string representing the book's author.
5. public String getGenre()
•	Description: Retrieves the genre of the book.
•	Returns: A string representing the book's genre.
6. public boolean isAvailable()
•	Description: Checks if the book is available for borrowing.
•	Returns: true if the book is available, false otherwise.
7. public void setAvailable(boolean available)
•	Description: Updates the availability status of the book.
•	Parameters:
•	available: A boolean indicating the availability status of the book.

> Library Class Methods:
1. Constructor - public Library()
•	Description: Initializes a new Library object, loads books and users from files.
2. private void loadBooks()
•	Description: Loads books from a text file and initializes Book objects accordingly.
3. private void loadUsers()
•	Description: Loads users from a text file and initializes User objects accordingly.
4. public void addBook(Book book)
•	Description: Adds a book to the library and saves it to the books file.
•	Parameters:
•	book: The Book object to be added to the library.
5. public void addUser(User user)
•	Description: Adds a user to the library and saves it to the users file.
•	Parameters:
•	user: The User object to be added to the library.
6. public void saveBooks()
•	Description: Saves the list of books to a text file.
7. public void saveUsers()
•	Description: Saves the list of users to a text file.
8. public void displayBooks()
•	Description: Displays all available books in the library.
9. public void borrowBook(String userId, String bookId)
•	Description: Allows a user to borrow a book from the library.
•	Parameters:
•	userId: The ID of the user borrowing the book.
•	bookId: The ID of the book being borrowed.
10. public void returnBook(String userId, String bookId)
•	Description: Allows a user to return a borrowed book to the library.
•	Parameters:
•	userId: The ID of the user returning the book.
•	bookId: The ID of the book being returned.
11. public Book findBookById(String bookId)
•	Description: Finds a book in the library by its ID.
•	Parameters:
•	bookId: The ID of the book to be found.
•	Returns: The Book object with the specified ID, or null if not found.
12. public User findUserById(String userId)
•	Description: Finds a user in the library by their ID.
•	Parameters:
•	userId: The ID of the user to be found.
•	Returns: The User object with the specified ID, or null if not found.
13. public boolean checkBookIdExists(String bookId)
•	Description: Checks if a book with the given ID already exists in the library.
•	Parameters:
•	bookId: The ID of the book to be checked.
•	Returns: true if the book ID exists, false otherwise.
14. public boolean checkUserIdExists(String userId)
•	Description: Checks if a user with the given ID already exists in the library.
•	Parameters:
•	userId: The ID of the user to be checked.
•	Returns: true if the user ID exists, false otherwise.

> LibraryManagementSystem Class Methods:
1. Main Method - public static void main(String[] args)
•	Description: The entry point of the program, where the Library Management System is executed.
•	Error Handling: Ensures that users enter valid numeric inputs for menu options and user inputs.
2. Private Helper Method - private static boolean isNumeric(String str)
•	Description: Checks if a given string is numeric.
•	Parameters: str: The string to be checked.
•	Returns: true if the string is numeric, false otherwise.
These methods collectively provide the functionality for managing the library, including adding books and users, displaying available books, borrowing and returning books, and handling errors appropriately.
