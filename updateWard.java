import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 

public class updateWard extends JFrame{
	private Container c;
	
	
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, dateOfBirthLabel,  dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel usernameError, firstNameError, lastNameError,  balanceError, phoneError, emailError, dateOfBirthError, genderError, passwordError, addressError; /*Warnings*/
	private JTextField usernameText, firstNameText, lastNameText,  balanceText, phoneText, emailText, dateOfBirthText, genderText, addressText,passText;
	
	private JButton signpButton, clearButton, cancelButton, backButton;
	
	updateWard(int x, int y)
	{
		
		

		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Update Values");
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



		
		//******************  WARD_NO	 ******************
		usernameLabel = new JLabel("WARD_NO");
		usernameLabel.setBounds(60,50,150,50);
		usernameLabel.setFont(labelFont);
		c.add(usernameLabel);


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
		
		
		//****************** CENTER_ID ******************
		emailLabel = new JLabel("CENTER_ID");
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
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(200, 850, 100,50);
		c.add(cancelButton);
		
		
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
		

		// UPDATE Button **********

		signpButton = new JButton("UPDATE");
		signpButton.setBackground(new Color(0,153,0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Gotham",Font.BOLD,25));
		signpButton.setBounds(400, 850, 200,50);
		c.add(signpButton);
		
		
		
		
		signpButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){

			String username = usernameText.getText();
			int WARD_NO = Integer.parseInt(username);
			String CENTER_ID = emailText.getText();
			
			
			update(CENTER_ID, WARD_NO);
			
			
		    }
			
		});
		
		
	}
	
	 private static void update(String CENTER_ID, int WARD_NO) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            PreparedStatement stmt = con.prepareStatement("update ward set CENTER_ID = ? where WARD_NO = ?");
            stmt.setString(1, CENTER_ID);
            stmt.setInt(2, WARD_NO);
            stmt.execute();
            if (stmt.getUpdateCount() == 1) {
                System.out.println("Update Successful!!!");
			}   
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	
	
	public static void main(String[] args)
		{
			new updateWard (1000,1000);
		}
	
}