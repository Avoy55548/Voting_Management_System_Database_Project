import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import javax.swing.table.DefaultTableModel; 
import java.sql.ResultSet;


public class joining extends JFrame{
	private Container c;
	
	
	private JButton  Button1 , Button2 , Button3, Button4, cancelButton;



    joining(int x, int y)
	{
		
		

		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Joining");
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
		
		
		//***********************Buttons************************
		
		Button1 = new JButton("EQUIJOIN");
		Button1.setBackground(new Color(204,0,0));
		Button1.setForeground(Color.WHITE);
		Button1.setBounds(300,100, 300,70);
		c.add(Button1);
		
		
		Button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				equijoin S1 = new equijoin(x,y);
				S1.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		
		
		Button2 = new JButton("OUTERJOIN-1");
		Button2.setBackground(new Color(204,0,0));
		Button2.setForeground(Color.WHITE);
		Button2.setBounds(300,300, 300,70);
		c.add(Button2);
		
		Button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				outerjoin1 S2 = new outerjoin1(x,y);
				 S2.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		
		
		
		Button3 = new JButton("OUTERJOIN-2");
		Button3.setBackground(new Color(204,0,0));
		Button3.setForeground(Color.WHITE);
		Button3.setBounds(300,500, 300,70);
		c.add(Button3);
		
		
		Button3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				outerjoin2 S3 = new outerjoin2(x,y);
				 S3.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		Button4 = new JButton("SELF-JOIN");
		Button4.setBackground(new Color(204,0,0));
		Button4.setForeground(Color.WHITE);
		Button4.setBounds(300,700, 300,70);
		c.add(Button4);
		
		
		Button4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				selfjoin S3 = new selfjoin(x,y);
				 S3.setVisible(true);
				dispose(); 


			}
		});
		
		
		
		
		//**************************Cancel Button****************	
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(400, 850, 100,50);
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
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	 public static void main(String[] args)
		{
			new joining (1000,1000);
		}
	
	
}