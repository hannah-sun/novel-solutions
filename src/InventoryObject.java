/**
 * This class represents a book in the inventory.
 * Includes the books name, grade, room, number, price,
 * and ISBN.
 * @author Cosmic42 (Wally)
 *
 */
public class InventoryObject {
	private String name;
	private String grade;
	private String room;
	private String[] num;
	private String price;
	private String ISBN;
	/**
	 * 
	 * @param line
	 */
	public InventoryObject(String line){
		num = new String[2];
		String[] data = line.split("\t");
		name = data[0];
		grade = data[1];
		room = data[2];
		num[0] = data[3]; num[1] = data[4];
		price = data[5];
		ISBN = data[6];
	}
	
	/**
	 * Returns the name as the conversion from object to string
	 * 
	 */
	public String toString(){
		return name;
	}
	
	public String toFileString(){
		return name + "\t" + 
	           grade + "\t" +
			   room + "\t" +
	           num[0] + "\t" + num[1] + "\t" +
			   price + "\t" + 
	           ISBN + "\n";
	}
	
	/**
	 * 
	 * @return the name of the book
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name	Name of the book
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the grade level of the book.
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 
	 * @param grade	Grade of the book
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * Returns the room # of the book
	 * @return
	 */
	public String getRoom() {
		return room;
	}
	/**
	 * 
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	/**
	 * 
	 * @return the number of books vs totla number of books in viewable form.
	 */
	public String getNumView() {
		return num[0] + "/" + num[1];
	}
	
	/**
	 * 
	 * @return the current number in inventory
	 */
	public String getNum() {
		return num[0];
	}
	
	/**
	 * 
	 * @return the total number in inventory
	 */
	public String getNumTotal() {
		return num[1];
	}

	/**
	 * Sets the total
	 * @param num array that stores the total and the current num in inventory
	 */
	public void setNumTotal(String num) {
		this.num[1] = num;
	}

	/**
	 * Sets the current num in inventory
	 * @param num array that stores the total and the current num in inventory
	 */
	public void setNum(String num) {
		this.num[0] = num;
	}
	
	/**
	 * Sets both the total and current num in inventory
	 * @param num array that stores the total and the current num in inventory
	 */
	public void setNum(String[] num) {
		this.num = num;
	}
	
	/**
	 * 
	 * @return the price of the book.
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 
	 * @return the ISBN # of the books.
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * 
	 * @param iSBN
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(InventoryObject other){
		String otherTitle = other.getName();
		String current = this.getName();
		if(current.equals(otherTitle))
			return true;
		else
			return false;
	}
}