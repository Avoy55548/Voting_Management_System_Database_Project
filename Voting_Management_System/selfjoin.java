import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import javax.swing.table.DefaultTableModel; 
import java.sql.ResultSet;


public class selfjoin extends JFrame{
	private Container c;
	
	
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, dateOfBirthLabel,  dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel usernameError, firstNameError, lastNameError,  balanceError, phoneError, emailError, dateOfBirthError, genderError, passwordError, addressError; /*Warnings*/
	private JTextField usernameText, firstNameText, lastNameText,  balanceText, phoneText, emailText, dateOfBirthText, genderText, addressText,passText;
	
	private JButton signpButton, clearButton, cancelButton, backButton;



    selfjoin(int x, int y)
	{
		
		

		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Search Values");
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
		
				//**********************Button********************************
		
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(450, 850, 100,50);
		c.add(cancelButton);
		
		
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				joining main = new joining(x,y);
				 main.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		
		
		//************************** Table ************************************************


		String[] columnNames={"VOTER_ID","VOTER_NAME"};
		String[][] data1=getData1(); 
		
		DefaultTableModel tableModel = new DefaultTableModel(data1,columnNames);
		JTable table=new JTable(tableModel);
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(160,200,750,615);
		c.add(scrollPane);






	}
	
	private String[] [] getData1()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select v.voter_id,c.voter_name from votes v, votes c where v.voter_id=c.voter_id and c.candidate_id=10001");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
          }
		
		
		  // Create a two-dimensional array to hold the data
		 String[][] data1 = new String[rowCount][2];
		  int index = 0;
		  
		  rs = stmt.executeQuery("select v.voter_id,c.voter_name from votes v, votes c where v.voter_id=c.voter_id and c.candidate_id=10001"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data1[index][0] = rs.getString(1);
               data1[index][1] = rs.getString(2);
               
               
               index++;
		    }
            con.close();
			return data1;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	
	
	
	
	 public static void main(String[] args)
		{
			new selfjoin (1000,1000);
			
		}
}