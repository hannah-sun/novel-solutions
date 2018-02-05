/**
 * This class represents a teacher, or user. Includes a name, password, username,
 * and admin status
 * @author Henry & Kevin
 *
 */
public class Teacher{
	
	private String name, username, password;
	private boolean admin;
	/**
	 * 
	 * @param name Name of the teacher
	 * @param username Username of the teacher
	 * @param password Password of the teacher
	 * @param admin Admin status
	 */
	public Teacher(String name, String username, String password, boolean admin){
		this.name = name;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	/**
	 * 
	 * @return True if teacher is admin, otherwise returns false.
	 */
	public boolean isAdmin(){
		return admin;
	}
	/**
	 * 
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}
/**
 * 
 * @param username
 */
	public void setUsername(String username) {
		this.username = username;
	}
/**
 * 
 * @return the password.
 */
	public String getPassword() {
		return password;
	}
/**
 * 
 * @param password
 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	public String toString(){
		return name;
	}
	
}