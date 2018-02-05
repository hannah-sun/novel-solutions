/**
 * This class contains the messages for requests on returning
 * and requesting
 * @author Hannah
 *
 */
public class Message {
	private Notification notification;
	public boolean accepted;
	
	/**
	 * Constructor for the class. 
	 * @param given	The type of notification
	 * @param ifAccept	Status of  the request
	 */
	public Message(Notification given, boolean ifAccept){
		notification = given;
		accepted = ifAccept;
	}
	
	/**
	 * Overloaded constructor for reading from text file.
	 * @param line Line of the reading from the text file
	 */
	public Message(String line){
		int index = line.lastIndexOf(";");
		String noti = line.substring(0, index+1);
		String accept = line.substring(index+2);
		notification = new Notification(noti);
		if (accept.equals("true"))
			accepted = true;
		else
			accepted = false;
	}
	
	/**
	 * 
	 * @return number of books
	 */
	public String getCopies(){
		return notification.getStringNumBooks();
	}
	
	/**
	 * 
	 * @return the title of the book
	 */
	public String getTitle(){
		return notification.getTitle();
	}
	
	/**
	 * 
	 * @return the status of request
	 */
	public String getAcceptance(){
		if(accepted)
			return "Accepted";
		else
			return "Declined";
	}
	
	/**
	 * 
	 * @return the teacher
	 */
	public String getTeacher(){
		return notification.getTeacher();
	}
	
	/**
	 * 
	 * @return if the book is to borrow or to return
	 */
	public String toBorrow(){
		if (notification.isBorrow())
			return "Borrow";
		else
			return "Return";
	}
	
	/**
	 * String representation of the object
	 */
	public String toString(){
		return notification.getTitle() + " - " + notification.getNumBooks() + " copies";
	}

}
