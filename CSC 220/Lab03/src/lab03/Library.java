 package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library {

  private ArrayList<LibraryBook> library;

  public Library() {
    library = new ArrayList<LibraryBook>();
  }

  /**
   * Add the specified book to the library, assume no duplicates.
   * 
   * @param isbn --
   *          ISBN of the book to be added
   * @param author --
   *          author of the book to be added
   * @param title --
   *          title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook(isbn, author, title));
  }
  

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

    try {
      Scanner fileIn = new Scanner(new File(filename));
      int lineNum = 1;

      while (fileIn.hasNextLine()) {
        String line = fileIn.nextLine();

        Scanner lineIn = new Scanner(line);
        lineIn.useDelimiter("\\t");

        if (!lineIn.hasNextLong())
          throw new ParseException("ISBN", lineNum);
        long isbn = lineIn.nextLong();

        if (!lineIn.hasNext())
          throw new ParseException("Author", lineNum);
        String author = lineIn.next();

        if (!lineIn.hasNext())
          throw new ParseException("Title", lineNum);
        String title = lineIn.next();

        toBeAdded.add(new LibraryBook(isbn, author, title));

        lineNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } catch (ParseException e) {
      System.err.println(e.getLocalizedMessage()
          + " formatted incorrectly at line " + e.getErrorOffset()
          + ". Nothing added to the library.");
      return;
    }

    library.addAll(toBeAdded);
  }

  /**
   * Returns the holder of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn --
   *          ISBN of the book to be looked up
   */
  public String lookup(long isbn) {
	  int index;
	  for(index = 0; index < library.size(); index++) {
		  if (library.get(index).getIsbn() != isbn && library.get(index).getHolder()!= null) {
			  return library.get(index).getHolder();
		  }
		
	  }// end of the for loop
	  System.out.println("Could not find anyone with a book with isbn: " + isbn);
	  System.out.println("Returning null");
    // Lab Part 3
    return null; //place holder
  }



  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked out, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked out
   * @param holder --
   *          new holder of the library book
   * @param month --
   *          month of the new due date of the library book
   * @param day --
   *          day of the new due date of the library book
   * @param year --
   *          year of the new due date of the library book
   */
  public boolean checkout(long isbn, String holder, int month, int day, int year) {
	  int index;
	  for(index = 0 ; index < library.size(); index++) {
		  LibraryBook current = library.get(index);
		  if (current.getIsbn() == isbn && current.getHolder() == null) {
			  GregorianCalendar date = new GregorianCalendar(year, month, day);
			  current.checkout(holder, date);
			  return true;
		  }
		  
		  
		  
		  
	  }// end of the for loop
	  System.out.println("can't find the book you're looking for silly goose!");
	  return false;
	  
	  
    //Lab Part 3
     // placeholder
  }
  
  // *********************************************************************
  // * you will implement the rest of the methods for your assignment    *
  // * don't touch them before finishing the lab portion                 *
  // *********************************************************************

  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder --
   *          holder whose checked out books are returned
   */
  public ArrayList<LibraryBook> lookup(String holder) {
    // Assignment Part 1
	  
	  // initialize empty arraylist of books 
	  ArrayList<LibraryBook> returnList = new ArrayList<LibraryBook>();
	  
	  
	  for(int index = 0; index < this.library.size(); index++) {
		  if (this.library.get(index).getHolder() == holder) {
			  returnList.add(this.library.get(index));
		  }
		  
		  
	  }// end of the for loop
	  
	  
	  return returnList; //placeholder
  }  

  /**
   * Unsets the holder and due date of the library book.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked in, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {
	  LibraryBook candidate;
	  for (int index = 0; index < this.library.size(); index++) {
		  if (this.library.get(index).getIsbn() == isbn) {
			  candidate = this.library.get(index);
			  if (candidate.getHolder() == null) {
				  System.out.println("This book is already checked in!");
				  
				  return false;
			  }
			  candidate.checkin();
			  return true;
		  }
		  
		  
		  
	  }// end of for loop
	  return false;
	  
	  
	  
    // Assignment Part 2.1
	  
  }

  /**
   * Unsets the holder and due date for all library books checked out by the
   * specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   * 
   * @param holder --
   *          holder of the library books to be checked in
   */
  public boolean checkin(String holder) {
	  // Assignment Part 2.1
	  int count = 0;
	  for (int index = 0; index < this.library.size(); index++) {
		  if (this.library.get(index).getHolder() == holder) {
			  boolean result = this.checkin(this.library.get(index).getIsbn());
			  if (result == true) {
				  System.out.println("Just checked in " + this.library.get(index));
				  count += 1;
			  }
		  }
		  
		  
	  }// end of for loop
	  if (count != 0) {
		  return true;
	  }else {
		  return false;
	  }
  }// end of checkin method
}