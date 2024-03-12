package Book;
//Book class definition
public class Book {
        //Instance variables (attributes) of the class Book are declared
        private String id;
        private String title;
        private String author;
        private String genre;
        private boolean available;

        //Constructor of Book class that takes the class' attributes as parameter
        public Book(String id, String title, String author, String genre, boolean available) {
            //Assigning values passed through constructor to corresponding instance variables
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
        }
        //Getter method for retrieving the ID of the book
        public String getId() {
            return id;
        }
        //Getter method for retrieving the title of the book
        public String getTitle() {
            return title;
        }
        //Getter method for retrieving the author of the book
        public String getAuthor() {
            return author;
        }
        //Getter method for retrieving the genre of the book
        public String getGenre() {
            return genre;
        }
        //Getter method for checking the availability of the book
        public boolean isAvailable() {
            return available;
        }
        //Setter method for updating the availability of the book
        public void setAvailable(boolean available) {
            this.available = available;
        }
    }
