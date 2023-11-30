import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.*; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class showPage extends JFrame{
	
	private final JTabbedPane tabs;
	private final Container c;
	private final ImageIcon icon;
	private ImageIcon homeIcon;
	private JPanel voterPanel, historyPanel, withdrawPanel, depositPanel, transferPanel, updatePanel, deletePanel;
	private JLabel labelDelete, withdrawAmountLabel, depositAmountLabel, transferAccontLabel, transferAmountLabel, labelTransferPassword;
	private JLabel infoUsername, infoName, infoBalance, infoEmail, infoPhone, infoAddress, infoDateOfBirth, infoGender;
	private JLabel withdrawMessage, depositMessage, transferMessage;
	private JTextField withdrawText, depositText, balanceText, transferAccountText, transferAmountText;
	private JPasswordField withdrawPass, depositPass, passwordTransfer, deletePass;
	private JButton withdrawOk, depositOk, transferOk, deleteOk, buttonLogOut;



showPage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Show All Table");
		this.setBounds(x,y, 1000,1000);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.setVisible(true);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/

		Font textFont = new Font("Gotham",Font.PLAIN,20);
		

		tabs = new JTabbedPane(JTabbedPane.LEFT);
		tabs.setBackground(Color.WHITE);
		tabs.setBounds(15,100,960,730);

		
		voterPanel = new JPanel();
		Color voterPanelColor = new Color (204,255,204);
		voterPanel.setBackground(Color.WHITE);
		voterPanel.setLayout(null);

		historyPanel = new JPanel();
		historyPanel.setBackground(Color.WHITE);
		historyPanel.setLayout(null);

		withdrawPanel = new JPanel();
		withdrawPanel.setBackground(Color.WHITE);
		withdrawPanel.setLayout(null);


		depositPanel = new JPanel();
		depositPanel.setBackground(Color.WHITE);
		depositPanel.setLayout(null);


		transferPanel = new JPanel();
		transferPanel.setBackground(Color.WHITE);
		transferPanel.setLayout(null);


		

		tabs.addTab("VOTER",voterPanel);
		tabs.addTab("CANDIDATES",historyPanel);
		tabs.addTab("COUNT", withdrawPanel);
		tabs.addTab("CENTER",depositPanel);
		tabs.addTab("WARD",transferPanel);
		
		
		
		JLabel voter = new JLabel("VOTER");
		voter.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(0,voter);
		
		JLabel history = new JLabel("CANDIDATES");
		history.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(1,history);
		
		JLabel withdraw = new JLabel("COUNT");
		withdraw.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(2,withdraw);
		
		JLabel deposit = new JLabel("CENTER");
		deposit.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(3,deposit);
		
		JLabel transfer = new JLabel("WARD");
		transfer.setPreferredSize(new Dimension(200, 100));
		tabs.setTabComponentAt(4,transfer);
		
		
		
		
		c.add(tabs);
		
		//************************************* VOTER *************************************

		JLabel voterLabel = new JLabel("VOTER");
		voterLabel.setBounds(250,20, 400, 50);
		voterLabel.setFont(new Font("Gotham",Font.BOLD,45));
		voterPanel.add(voterLabel);
		
		String[][] data1=getData1(); 
			
			
		
		String[] columnName1={"VOTER_ID","VOTER_NAME","DOB","CENTER_ID"};
		
		DefaultTableModel tableModel1 = new DefaultTableModel(data1,columnName1);
		JTable table1=new JTable(tableModel1);
		
		JScrollPane scrollPane1=new JScrollPane(table1);
		scrollPane1.setBounds(8,100,715,615);
		voterPanel.add(scrollPane1);
		
		//************************************* CANDIDATES ************************************* 

		JLabel historyLabel = new JLabel("CANDIDATES");
		historyLabel.setBounds(200,20, 400, 50);
		historyLabel.setFont(new Font("Gotham",Font.BOLD,45));
		historyPanel.add(historyLabel);
		
		String[][] data2=getData2(); 
			
			
		
		String[] columnName2={"CANDIDATE_ID","CANDIDATE_NAME","VOTE_COUNT"};
		
		DefaultTableModel tableModel2 = new DefaultTableModel(data2,columnName2);
		JTable table2=new JTable(tableModel2);
		
		JScrollPane scrollPane2=new JScrollPane(table2);
		scrollPane2.setBounds(8,100,715,615);
		historyPanel.add(scrollPane2);
		
		
		
		
		//************************************* COUNT ************************************* 

		JLabel withdrawLabel = new JLabel("COUNT");
		withdrawLabel.setBounds(200,20, 700, 50);
		withdrawLabel.setFont(new Font("Gotham",Font.BOLD,45));
		withdrawPanel.add(withdrawLabel);
		
		String[][] data3=getData3(); 
		
		
		String[] columnName3={"BALLOT_SERIAL","PARTY_NOMINEE","PARTY_NAME","AGENT_ID"};
		
		DefaultTableModel tableModel3 = new DefaultTableModel(data3,columnName3);
		JTable table3=new JTable(tableModel3);
		
		JScrollPane scrollPane3=new JScrollPane(table3);
		scrollPane3.setBounds(8,100,715,615);
		withdrawPanel.add(scrollPane3);
		
		
		
		//************************************* CENTER ***********************************
		
		JLabel depositLabel = new JLabel("CENTER");
		depositLabel.setBounds(200,20, 700, 50);
		depositLabel.setFont(new Font("Gotham",Font.BOLD,45));
		depositPanel.add(depositLabel);
		
		String[][] data4=getData4(); 
		
		
		String[] columnName4={"CENTER_ID","CENTER_NAME"};
		
		DefaultTableModel tableModel4 = new DefaultTableModel(data4,columnName4);
		JTable table4=new JTable(tableModel4);
		
		JScrollPane scrollPane4=new JScrollPane(table4);
		scrollPane4.setBounds(8,100,715,615);
		depositPanel.add(scrollPane4);
		
		
		
		//************************************* WARD ************************************* 
		
		JLabel transferLabel = new JLabel("WARD");
		transferLabel.setBounds(200,20, 700, 50);
		transferLabel.setFont(new Font("Gotham",Font.BOLD,45));
		transferPanel.add(transferLabel);
		
		
		String[][] data5=getData5(); 
		
		
		String[] columnName5={"WARD_NO","CENTER_ID","POSTAL_CODE"};
		
		DefaultTableModel tableModel5 = new DefaultTableModel(data5,columnName5);
		JTable table5=new JTable(tableModel5);
		
		JScrollPane scrollPane5=new JScrollPane(table5);
		scrollPane5.setBounds(8,100,715,615);
		transferPanel.add(scrollPane5);
		
		
		
		
		//_________________________________________ PANEL ENDS  ______________________________________________________________________________

	

		JButton zero = new JButton();  // Captures first Button
		zero.setBounds(0,0,0,0);
		c.add(zero);


		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(425,850,150,50);
		refreshButton.setFont(new Font("Gotham",Font.BOLD,25));
		refreshButton.setForeground(Color.WHITE);
		refreshButton.setBackground(new Color(0,153,0));
		c.add(refreshButton);	


		//Logout Button *************************************************************************

		buttonLogOut = new JButton("Back");
		buttonLogOut.setBounds(800,25, 150,50);
		buttonLogOut.setBackground(Color.RED);
		buttonLogOut.setForeground(Color.WHITE);
		buttonLogOut.setFont(new Font("Gotham",Font.BOLD,25));
		c.add(buttonLogOut);

		buttonLogOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				main.setVisible(true);
				dispose();


			}
		});


		refreshButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				
				showPage main = new showPage(x,y);
				main.setVisible(true);
				dispose();


			}
		});
		
	
	}
	
	
	
	
	//*********************************** EXTRA CLASSES OUTSIDE THE SHOWPAGE FOR THE TABLE SHOWING GETALL() METHODE *************************************************
	
	//************************************* SHOW VOTER TABLE ************************************* 
	private String[] [] getData1()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from voter");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
          }
		
		
		  // Create a two-dimensional array to hold the data
		 String[][] data1 = new String[rowCount][4];
		  int index = 0;
		  
		  rs = stmt.executeQuery("SELECT * FROM voter"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data1[index][0] = rs.getString(1);
               data1[index][1] = rs.getString(2);
               data1[index][2] = rs.getString(3);
               data1[index][3] = rs.getString(4);
               index++;
		    }
            con.close();
			return data1;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	//************************************* SHOW CANDIDATES TABLE ************************************* 
	private String[] [] getData2()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from candidates");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
        }
		
		
		// Create a two-dimensional array to hold the data
		 String[][] data2 = new String[rowCount][3];
		  int index = 0;
		  
		  rs = stmt.executeQuery("select * from candidates"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data2[index][0] = rs.getString(1);
               data2[index][1] = rs.getString(2);
               data2[index][2] = rs.getString(3);
               //data[index][3] = rs.getString(4);
               index++;
		    }
            con.close();
			return data2;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	
	//************************************* SHOW COUNT TABLE ************************************* 
	private String[] [] getData3()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vote_count");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
        }
		
		
		// Create a two-dimensional array to hold the data
		 String[][] data3 = new String[rowCount][4];
		  int index = 0;
		  
		  rs = stmt.executeQuery("SELECT * FROM vote_count"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data3[index][0] = rs.getString(1);
               data3[index][1] = rs.getString(2);
               data3[index][2] = rs.getString(3);
               data3[index][3] = rs.getString(4);
               index++;
		    }
            con.close();
			return data3;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	
	
	//************************************* SHOW CENTER TABLE ************************************* 
	private String[] [] getData4()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from center");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
        }
		
		
		// Create a two-dimensional array to hold the data
		 String[][] data4 = new String[rowCount][2];
		  int index = 0;
		  
		  rs = stmt.executeQuery("select * from center"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data4[index][0] = rs.getString(1);
               data4[index][1] = rs.getString(2);
               //data2[index][2] = rs.getString(3);
               //data[index][3] = rs.getString(4);
               index++;
		    }
            con.close();
			return data4;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	
	
	
	
	//************************************* SHOW WARD TABLE ************************************* 
	private String[] [] getData5()
	{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ward");
			
			// Count the number of rows in the ResultSet
			int rowCount = 0;
			while (rs.next()) {
            rowCount++;
        }
		
		
		// Create a two-dimensional array to hold the data
		 String[][] data5 = new String[rowCount][3];
		  int index = 0;
		  
		  rs = stmt.executeQuery("select * from ward"); // Re-execute the query
		  
		  
            while (rs.next())
			{
               data5[index][0] = rs.getString(1);
               data5[index][1] = rs.getString(2);
               data5[index][2] = rs.getString(3);
              
               index++;
		    }
            con.close();
			return data5;

        } catch (Exception e) {
            System.out.println(e);
			return null;
        }
	}
	
	
	
	
	
	
	
	

	
	
	public static void main(String[] args)
		{
			new showPage(1000,1000);
			
		}
		
}