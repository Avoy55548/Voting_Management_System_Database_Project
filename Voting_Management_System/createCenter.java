import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;    




public class createCenter extends JFrame{
	private Container c;
	
	
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, dateOfBirthLabel,  dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel usernameError, firstNameError, lastNameError,  balanceError, phoneError, emailError, dateOfBirthError, genderError, passwordError, addressError; /*Warnings*/
	private JTextField usernameText, firstNameText, lastNameText,  balanceText, phoneText, emailText, dateOfBirthText, genderText, addressText,passText;
	
	private JButton signpButton, clearButton, cancelButton, backButton;
	
	createCenter (int x, int y)
	{

		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create New Account");
		this.setBounds(x,y, 1000,1000);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.setVisible(true);
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		
		/**************************************************/


		//******************  Fonts ******************

		labelFont = new Font("Gotham",Font.BOLD,20);
		Font textFont = new Font("Gotham",Font.PLAIN,20);
		errorFont = new Font("Ariel", Font.ITALIC+Font.BOLD,12);



		//******************  CENTER_ID ******************
		usernameLabel = new JLabel("CENTER_ID");
		usernameLabel.setBounds(60,50,150,50);
		usernameLabel.setFont(labelFont);
		c.add(usernameLabel);

		JLabel finalUsername = new JLabel("[ ID cannot change later]");
		finalUsername.setBounds(530,100,400,25);
		c.add(finalUsername);

		usernameError = new JLabel("");
		usernameError.setBounds(360, 100, 200,25);
		usernameError.setForeground(Color.RED);
		usernameError.setFont(errorFont);
		c.add(usernameError);

		////textFiled ******************

		usernameText = new JTextField("");
		usernameText.setFont(textFont);
		usernameText.setBounds(350, 50, 550,50);
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		c.add(usernameText);


		

		//****************** CENTER_NAME ******************
		emailLabel = new JLabel("CENTER_NAME");
		emailLabel.setBounds(60,250,150,50);
		emailLabel.setFont(labelFont);
		c.add(emailLabel);
		emailError = new JLabel("");
		emailError.setBounds(360, 300, 200,25);
		emailError.setForeground(Color.RED);
		emailError.setFont(errorFont);
		c.add(emailError);

		////textFiled ******************

		emailText = new JTextField("");
		emailText.setFont(textFont);
		emailText.setHorizontalAlignment(JTextField.CENTER);
		emailText.setBounds(350, 250, 550,50);
		c.add(emailText);


	



	

		// ****************** Buttons ******************

		//INSERT Button **********

		signpButton = new JButton("INSERT");
		signpButton.setBackground(new Color(0,153,0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Gotham",Font.BOLD,25));
		signpButton.setBounds(400, 850, 200,50);
		c.add(signpButton);

		clearButton = new JButton("Clear");
		clearButton.setBackground(new Color(255,128,0));
		clearButton.setForeground(Color.WHITE);
		clearButton.setBounds(700, 850, 100,50);
		c.add(clearButton);


		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(200, 850, 100,50);
		c.add(cancelButton);
		
		
		
		clearButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				usernameText.setText("");
				usernameError.setText("");
				
				emailText.setText("");
				emailError.setText("");
				



			}
		});
		
		
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				 main.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		
		
		signpButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				String username = usernameText.getText();
				 int CENTER_ID = Integer.parseInt(username);
				 String CENTER_NAME = emailText.getText();
				 
				
				 
				 create(CENTER_ID, CENTER_NAME);
		   
			}
			
		});
		
		
		
	}
	
	
	private static void create(int CENTER_ID, String CENTER_NAME) {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
        PreparedStatement stmt = con.prepareStatement("insert into 	center (center_id, center_name) values (?, ?)");
        stmt.setInt(1, CENTER_ID);
        stmt.setString(2, CENTER_NAME);
        
        stmt.execute();
        if (stmt.getUpdateCount() == 1) {
            System.out.println("Create Successful!!!");
        }
        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}






	public static void main(String[] args)
		{
			new createCenter(1000,1000);
		}
	
}