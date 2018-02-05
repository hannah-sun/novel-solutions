import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

/**
 * The class that constitutes the login portion of the GUI.
 * Not meant to be a reusable class object, but can be used
 * in other classes.  
 * 
 * @author Cosmic42 (Wally)
 *
 */
public class LoginGUI extends JFrame {
	
	private ArrayList<Teacher> users;
	private JPanel login;
	private JTextField username;
	private JPasswordField password; 
	private JButton loginButton;
	private Teacher user;
	private GUIHandler handler;

	/**
	 * The constructor for the login GUI that initializes the fields.
	 * @throws IOException
	 */
	public LoginGUI() throws IOException{
		super("Book Inventory");
		
		FileReader fileReader = new FileReader("Database/users.txt");
		BufferedReader bufferReader = new BufferedReader(fileReader);
		users = new ArrayList<Teacher>();
        String line;
		while((line = bufferReader.readLine()) != null)
            users.add(new Teacher(line.split("\t")[0], line.split("\t")[1], line.split("\t")[2], Boolean.valueOf(line.split("\t")[3])));
      
        bufferReader.close();
        
		handler = new GUIHandler();
		login = new JPanel();
		username = new JTextField(); password = new JPasswordField();
		loginButton = new JButton("Login");
		username.addActionListener(handler);
		password.addActionListener(handler);
		loginButton.addActionListener(handler);

		loginScreen();
		add(login);
	}

	/**
	 * Creates the JPanel for the login screen. Uses GroupLayout for format. 
	 * 
	 */
	public void loginScreen(){
		JLabel label1 = new JLabel("Username: ");
		JLabel label2 = new JLabel("Password: ");
		JLabel label3 = new JLabel("");

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		        

		GroupLayout layout = new GroupLayout(login);
		login.setLayout(layout);

		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                	.addComponent(label1)
                	.addComponent(label2)
                	.addComponent(label3))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addComponent(password)
                    .addComponent(loginButton)));
            
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                	.addComponent(label1)
                	.addComponent(username))
                .addGroup(layout.createParallelGroup()
                	.addComponent(label2)
                	.addComponent(password))
                .addGroup(layout.createParallelGroup()
                    .addComponent(label3)
                  	.addComponent(loginButton)));
	}
	
	/**
	 * Boolean method that takes in a username string and a password string,
	 * and compares them to the list of users in the database.
	 * Returns true if it matches and saves the user, returns false
	 * if there is no match. 
	 * 
	 * @param username	Username in the input
	 * @param password	Password in the input
	 * @return a boolean variable for whether the user entered 
	 * password and username correctly or not
	 */
	public boolean checkUser(String username, String password){
		for(Teacher teacher : users)
			if(teacher.getUsername().toLowerCase().equals(username.toLowerCase()) && teacher.getPassword().equals(password)){
				user = teacher;
				return true;
			}
		return false;
	}
	
	/**
	 * Method that closes this JFrame and begins to setup the 
	 * main GUI. Placed in a separate method instead of with 
	 * the actionListeners for organizational purposes. 
	 * @throws IOException
	 */
	public void setInventoryGUI() throws IOException{
		this.dispose();
		
		GUI inventoryGUI = new GUI(user);
		ImageIcon logo = new ImageIcon("src/NS_Icon.png");
		
		inventoryGUI.setIconImage(logo.getImage());
		inventoryGUI.setSize(800, 500);
		inventoryGUI.setVisible(true);
		inventoryGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryGUI.setResizable(false);
		inventoryGUI.setLocationRelativeTo(null);


	}

public class GUIHandler implements ActionListener{

	/**
	 * Action Listeners for buttons and text fields.
	 * If the login username and password don't match any
	 * logins in the database, then reject. Otherwise, continue
	 * and setup the main GUI. 
	 */
	
	public void actionPerformed(ActionEvent event){
		if(checkUser(username.getText(), new String(password.getPassword())))
			try {
				setInventoryGUI();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			JOptionPane.showMessageDialog(null, "Error: Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);

	}
 
}
}