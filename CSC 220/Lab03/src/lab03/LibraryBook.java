package lab03;
// Lab Part 2.2 What imports do you need to include? Put them here.
import java.util.GregorianCalendar;


/**
 * A LibraryBook is a subclass of Book that contains a holder (a String) and a due date
 * represented by a GregorianCalendar.
 */
public class LibraryBook extends Book { // Lab Part 2.1

    // A LibraryBook contains a holder (a String) and due date represented by
    // a GregorianCalendar
    
    /**
     * Constructs a LibraryBook with the specified ISBN, author, and title.
     *
     * @param isbn   The ISBN number of the book.
     * @param author The author of the book.
     * @param title  The title of the book.
     */
	private String holder;
	GregorianCalendar dateDue;
	
    public LibraryBook(long isbn, String author, String title) {
        //Lab Part 2.3.1
    	super(isbn, author, title);
    	this.holder = null;
    	this.dateDue = null;
    }

    /**
     * Returns the holder of the library book.
     *
     * @return A String representing the holder of the book, or null if the book is not checked out.
     */
    public String getHolder() {
        //Lab Part 2.3.2
        return this.holder; // placeholder
    }
    
    /**
     * Returns the due date of the library book.
     *
     * @return A GregorianCalendar object representing the due date of the book, or null if the book is not checked out.
     */
    public GregorianCalendar getDueDate() {
        //Lab Part 2.3.3
        return this.dateDue; // placeholder
    }
    
    /**
     * Checks in the library book by setting the holder and due date to null.
     */
    public void checkin() {
        //Lab Part 2.3.4
    	if (this.dateDue == null || this.holder == null) {
    		System.out.println("That book's already in the libary silly goose ");
    		
    	}
    	this.dateDue = null;
    	this.holder = null;
    }
    
    /**
     * Checks out the library book by setting the holder and due date to the specified values.
     *
     * @param holder   The name of the person who is checking out the book.
     * @param dueDate  The due date for the book's return.
     */
    public void checkout(String holder, GregorianCalendar dueDate){
        //Lab Part 2.3.5
    	if (this.holder != null || this.dateDue != null) {
    		System.out.println("Somebody already has this book checked out!");
    		System.out.println("This person: " + this.holder + "this date " + this.dateDue);
    		
    	}else {
    		this.dateDue = dueDate;
    		this.holder = holder;
    	}
    	
    }

    // Do not override the equals method in Book

}