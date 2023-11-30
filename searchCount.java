import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import javax.swing.table.DefaultTableModel; 
import java.sql.ResultSet;


public class searchCount extends JFrame{
	private Container c;
	private JTable table;
    private DefaultTableModel tableModel;
	
	private JLabel firstNameLabel, lastNameLabel, nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, dateOfBirthLabel,  dateOfBirthLabel_2, genderLabel, addressLabel;
	private JLabel usernameError, firstNameError, lastNameError,  balanceError, phoneError, emailError, dateOfBirthError, genderError, passwordError, addressError; /*Warnings*/
	private JTextField usernameText, firstNameText, lastNameText,  balanceText, phoneText, emailText, dateOfBirthText, genderText, addressText,passText;
	
	private JButton signpButton, clearButton, cancelButton, backButton;



    searchCount(int x, int y)
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



		
		//******************  BALLOT_SERIAL ******************
		usernameLabel = new JLabel("BALLOT_SERIAL");
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
		
		
		
		

		// Search Button **********

		signpButton = new JButton("SEARCH");
		signpButton.setBackground(new Color(0,153,0));
		signpButton.setForeground(Color.WHITE);
		signpButton.setFont(new Font("Gotham",Font.BOLD,25));
		signpButton.setBounds(400, 850, 200,50);
		c.add(signpButton);
		
		
		
		
		
		
		
		//***************************Vote_Count table***********************
		
		 
			
			
		
		String[] columnNames={"BALLOT_SERIAL","PARTY_NOMINEE","PARTY_NAME","AGENT_ID"};
		
		tableModel = new DefaultTableModel(columnNames,0);
		table=new JTable(tableModel);
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(160,200,750,615);
		c.add(scrollPane);
		
		
		
		
		signpButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){

			String username = usernameText.getText();
			int BALLOT_SERIAL = Integer.parseInt(username);
			
			getUser(BALLOT_SERIAL);
		    }
			
		});
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private void getUser(int BALLOT_SERIAL) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            PreparedStatement stmt = con.prepareStatement("select * from vote_count where BALLOT_SERIAL = ?");
            stmt.setInt(1, BALLOT_SERIAL);
            ResultSet rs = stmt.executeQuery();  
            while (rs.next())
			{
               String[] rowData = {
				   
				   rs.getString(1),
				   rs.getString(2),
				   rs.getString(3),
				   rs.getString(4)
				   
			   };
			   
			   tableModel.addRow(rowData);
		    }
			
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }









    public static void main(String[] args)
		{
			new searchCount (1000,1000);
		}

}
