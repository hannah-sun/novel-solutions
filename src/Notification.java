/**
 * Class for the notification system in the book inventory program
 * @author Hannah
 *
 */
public class Notification {

	private int numBooks;
	private String teacher, title, status;
	private int room;
	boolean borrow;
	
	/**
	 * 
	 * @param title
	 * @param copies
	 * @param lastName
	 * @param roomNum
	 * @param takeOut
	 */
	public Notification(String title, int copies, String lastName, int roomNum,
			boolean takeOut, String response) {
		this.title = title;
		numBooks = copies;
		teacher = lastName;
		room = roomNum;
		borrow = takeOut;
		status = response;
	}

	/**
	 * 
	 * @param line
	 */
	public Notification(String line) {
		String[] info = line.split("; ");
		title = info[0];
		numBooks = numOfBook(info);
		teacher = info[2];
		room = roomNum(info);
		if (info[4].equals("to Borrow"))
			borrow = true;
		else
			borrow = false;
		status = info[5];
	}

	/**
	 * 
	 * @return the number of books in the database as an integer.
	 */
	public int getNumBooks() {
		return numBooks;

	}

	/**
	 * 
	 * @return the # of books in the databse as a string.
	 */
	public String getStringNumBooks() {
		return "" + numBooks;
	}

	/**
	 * Sets variable
	 * @param numBooks
	 */
	public void setNumBooks(int numBooks) {
		this.numBooks = numBooks;
	}

	/**
	 * 
	 * @return
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * Sets variable
	 * @param teacher
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * 
	 * @return the title of the book.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets variable
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return the room # of the book as an integer.
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * 
	 * @return the room # of the book as a string.
	 */
	public String getStringRoom() {
		return "" + room;
	}
	
	/**
	 * 
	 * @return whether the book is requested for checkout or return.
	 */
	public String getIfBorrow() {
		if (borrow)
			return "Request for Check-Out";
		else
			return "Request for Return";
	}
	
	/**
	 * Sets variable
	 * @param room
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	
	/**
	 * 
	 * @return whether the book has been borrowed or not.
	 */
	public boolean isBorrow() {
		return borrow;
	}
	/**
	 * Sets variable
	 * @param borrow
	 */
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}

	/**
	 * 
	 * @return the status of the notification
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets variable
	 * @param teacher
	 */
	public void setStatus(String response) {
		this.status = response;
	}

	
/**
 * 
 * @param arr
 * @return the number of books
 */
	private int numOfBook(String[] arr) {
		String temp = arr[1];
		int r = Integer.parseInt(temp);
		return r;
	}
/**
 * 
 * @param arr
 * @return the book's room #
 */
	private int roomNum(String[] arr) {
		String temp = arr[3];
		return Integer.parseInt(temp);
	}
/**
 * 
 * @return the title of the book being requested or returned 
 * along with the teacher requesting or returning the book.
 */
	public String toString() {
		if (borrow)
			return (title + " - " + teacher);
		else
			return (title + " - " + teacher);
	}
	
	public String toFileString() {
		return title + "; " + numBooks + "; " + teacher + "; " + room + "; " + borrow + "; " + status + "\n";
	}
}
