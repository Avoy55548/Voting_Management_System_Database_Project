import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame{

private Container c;
	
	private JButton zero,insert, signpButton,
	InsertButton,UpdateButton,DeleteButton,SearchButton,
	InsertButtonC,UpdateButtonC,DeleteButtonC,SearchButtonC,
	InsertButtonCO,UpdateButtonCO,DeleteButtonCO,SearchButtonCO,
	InsertButtonCE,UpdateButtonCE,DeleteButtonCE,SearchButtonCE,
	InsertButtonW,UpdateButtonW,DeleteButtonW,SearchButtonW,
	
	joiningButton,subqueryButton,showallButton,
	
	Voter,Candidates,Count,Ward,Center,exitButton;
	
	MainPage(int x,int y)
	{
		/*******************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Welcome");
		this.setBounds(x,y, 1100,1000);
		this.setVisible(true);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		
		/*********************LEVEL*********/
		
		zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);
		
		
		JLabel welcome = new JLabel("VOTING MANAGEMENT SYSTEM");
		welcome.setFont(new Font("Didot",Font.BOLD,27));
		welcome.setBounds(300, 2, 800,100);
		c.add(welcome);
		
		JLabel Voter = new JLabel("VOTER:");
		Voter.setFont(new Font("Didot",Font.BOLD,22));
		Voter.setBounds(10,95,200,30);
		c.add(Voter);
		
		JLabel Candidates = new JLabel("CANDIDATES:");
		Candidates.setFont(new Font("Didot",Font.BOLD,22));
		Candidates.setBounds(10,170,200,30);
		c.add(Candidates);
		
		JLabel Count = new JLabel("COUNT:");
		Count.setFont(new Font("Didot",Font.BOLD,22));
		Count.setBounds(10,245,200,30);
		c.add(Count);
		
		JLabel Center = new JLabel("CENTER:");
		Center.setFont(new Font("Didot",Font.BOLD,22));
		Center.setBounds(10,320,200,30);
		c.add(Center);
		
		JLabel Ward = new JLabel("WARD:");
		Ward.setFont(new Font("Didot",Font.BOLD,22));
	    Ward.setBounds(10,395,200,30);
		c.add(Ward);
		
		
		       /************"VOTER:"BUTTON*********/
			   
			   
			   
		InsertButton = new JButton("INSERT");
		InsertButton.setBackground(new Color(200,102,0));
		InsertButton.setForeground(Color.WHITE);
		InsertButton.setFont(new Font("Didot",Font.BOLD,25));
		InsertButton.setBounds(180,95,180,30);
		c.add(InsertButton);
		
		
		
		
		
		UpdateButton = new JButton("UPDATE");
		UpdateButton.setBackground(new Color(200,102,0));
		UpdateButton.setForeground(Color.WHITE);
		UpdateButton.setFont(new Font("Didot",Font.BOLD,25));
		UpdateButton.setBounds(420,95,180,30);
		c.add(UpdateButton);
		
		DeleteButton = new JButton("DELETE");
		DeleteButton.setBackground(new Color(200,102,0));
		DeleteButton.setForeground(Color.WHITE);
		DeleteButton.setFont(new Font("Didot",Font.BOLD,25));
		DeleteButton.setBounds(660,95,180,30);
		c.add(DeleteButton);
		
		SearchButton = new JButton("SEARCH");
		SearchButton.setBackground(new Color(200,102,0));
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setFont(new Font("Didot",Font.BOLD,25));
		SearchButton.setBounds(885,95,180,30);
		c.add(SearchButton);
		
		
		 /************"CANDIDATES:"BUTTON*********/
		
		InsertButtonC = new JButton("INSERT");
		InsertButtonC.setBackground(new Color(200,102,0));
		InsertButtonC.setForeground(Color.WHITE);
		InsertButtonC.setFont(new Font("Didot",Font.BOLD,25));
		InsertButtonC.setBounds(180,170,180,30);
		c.add(InsertButtonC);
		
		UpdateButtonC = new JButton("UPDATE");
		UpdateButtonC.setBackground(new Color(200,102,0));
		UpdateButtonC.setForeground(Color.WHITE);
		UpdateButtonC.setFont(new Font("Didot",Font.BOLD,25));
		UpdateButtonC.setBounds(420,170,180,30);
		c.add(UpdateButtonC);
		
		DeleteButtonC = new JButton("DELETE");
		DeleteButtonC.setBackground(new Color(200,102,0));
		DeleteButtonC.setForeground(Color.WHITE);
		DeleteButtonC.setFont(new Font("Didot",Font.BOLD,25));
		DeleteButtonC.setBounds(660,170,180,30);
		c.add(DeleteButtonC);
		
		SearchButtonC = new JButton("SEARCH");
		SearchButtonC.setBackground(new Color(200,102,0));
		SearchButtonC.setForeground(Color.WHITE);
		SearchButtonC.setFont(new Font("Didot",Font.BOLD,25));
		SearchButtonC.setBounds(885,170,180,30);
		c.add(SearchButtonC);
		
		
		/************"COUNT:"BUTTON*********/
		
	    InsertButtonCO = new JButton("INSERT");
		InsertButtonCO.setBackground(new Color(200,102,0));
		InsertButtonCO.setForeground(Color.WHITE);
		InsertButtonCO.setFont(new Font("Didot",Font.BOLD,25));
		InsertButtonCO.setBounds(180,245,180,30);
		c.add(InsertButtonCO);
		
		UpdateButtonCO = new JButton("UPDATE");
		UpdateButtonCO.setBackground(new Color(200,102,0));
		UpdateButtonCO.setForeground(Color.WHITE);
		UpdateButtonCO.setFont(new Font("Didot",Font.BOLD,25));
		UpdateButtonCO.setBounds(420,245,180,30);
		c.add(UpdateButtonCO);
		
		DeleteButtonCO = new JButton("DELETE");
		DeleteButtonCO.setBackground(new Color(200,102,0));
		DeleteButtonCO.setForeground(Color.WHITE);
		DeleteButtonCO.setFont(new Font("Didot",Font.BOLD,25));
		DeleteButtonCO.setBounds(660,245,180,30);
		c.add(DeleteButtonCO);
		
		SearchButtonCO = new JButton("SEARCH");
		SearchButtonCO.setBackground(new Color(200,102,0));
		SearchButtonCO.setForeground(Color.WHITE);
		SearchButtonCO.setFont(new Font("Didot",Font.BOLD,25));
		SearchButtonCO.setBounds(885,245,180,30);
		c.add(SearchButtonCO);
		
		
		/**********************"CENTER:"BUTTON*********/
		
		
		InsertButtonCE = new JButton("INSERT");
		InsertButtonCE.setBackground(new Color(200,102,0));
		InsertButtonCE.setForeground(Color.WHITE);
		InsertButtonCE.setFont(new Font("Didot",Font.BOLD,25));
		InsertButtonCE.setBounds(180,320,180,30);
		c.add(InsertButtonCE);
		
		UpdateButtonCE = new JButton("UPDATE");
		UpdateButtonCE.setBackground(new Color(200,102,0));
		UpdateButtonCE.setForeground(Color.WHITE);
		UpdateButtonCE.setFont(new Font("Didot",Font.BOLD,25));
		UpdateButtonCE.setBounds(420,320,180,30);
		c.add(UpdateButtonCE);
		
		DeleteButtonCE = new JButton("DELETE");
		DeleteButtonCE.setBackground(new Color(200,102,0));
		DeleteButtonCE.setForeground(Color.WHITE);
		DeleteButtonCE.setFont(new Font("Didot",Font.BOLD,25));
		DeleteButtonCE.setBounds(660,320,180,30);
		c.add(DeleteButtonCE);
		
		SearchButtonCE = new JButton("SEARCH");
		SearchButtonCE.setBackground(new Color(200,102,0));
		SearchButtonCE.setForeground(Color.WHITE);
		SearchButtonCE.setFont(new Font("Didot",Font.BOLD,25));
		SearchButtonCE.setBounds(885,320,180,30);
		c.add(SearchButtonCE);
		
		
		
		  /************"WARD:BUTTON"*********/
			   
		
		InsertButtonW = new JButton("INSERT");
		InsertButtonW.setBackground(new Color(200,102,0));
		InsertButtonW.setForeground(Color.WHITE);
		InsertButtonW.setFont(new Font("Didot",Font.BOLD,25));
		InsertButtonW.setBounds(180,395,180,30);
		c.add(InsertButtonW);
		
		UpdateButtonW = new JButton("UPDATE");
		UpdateButtonW.setBackground(new Color(200,102,0));
		UpdateButtonW.setForeground(Color.WHITE);
		UpdateButtonW.setFont(new Font("Didot",Font.BOLD,25));
		UpdateButtonW.setBounds(420,395,180,30);
		c.add(UpdateButtonW);
		
		DeleteButtonW = new JButton("DELETE");
		DeleteButtonW.setBackground(new Color(200,102,0));
		DeleteButtonW.setForeground(Color.WHITE);
		DeleteButtonW.setFont(new Font("Didot",Font.BOLD,25));
		DeleteButtonW.setBounds(660,395,180,30);
		c.add(DeleteButtonW);
		
		SearchButtonW = new JButton("SEARCH");
		SearchButtonW.setBackground(new Color(200,102,0));
		SearchButtonW.setForeground(Color.WHITE);
		SearchButtonW.setFont(new Font("Didot",Font.BOLD,25));
		SearchButtonW.setBounds(885,395,180,30);
		c.add(SearchButtonW);
		
        joiningButton = new JButton("JOINING");
        joiningButton.setBackground(Color.RED);  // Set the background color to red
        joiningButton.setForeground(Color.WHITE);
        joiningButton.setFont(new Font("Didot", Font.BOLD, 25));
        joiningButton.setBounds(470, 650, 240, 40); // Increase width and height for larger size
        c.add(joiningButton);
		
		
		subqueryButton= new JButton("SUBQUERY");
		subqueryButton.setBackground(Color.RED);
		subqueryButton.setForeground(Color.WHITE);
		subqueryButton.setFont(new Font("Didot",Font.BOLD,25));
		subqueryButton.setBounds(200,650,240,40);
		c.add(subqueryButton);
		
		showallButton= new JButton("SHOW ALL");
		showallButton.setBackground(Color.RED);
		showallButton.setForeground(Color.WHITE);
		showallButton.setFont(new Font("Didot",Font.BOLD,25));
		showallButton.setBounds(750,650,240,40);
		c.add(showallButton);
		
		
		
		
		
		//*********************Action listener***************************************************
		
		
		//************ Voter Actions*************************************************
		
		
		InsertButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				createVoter insertV = new createVoter(x,y);
				insertV.setVisible(true);
				dispose();
			}
		});
		
		
		UpdateButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				UpdateVoter updateV = new UpdateVoter(x,y);
				updateV.setVisible(true);
				dispose();
			}
		});
		
		DeleteButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				DeleteVoter deleteV = new DeleteVoter(x,y);
				deleteV.setVisible(true);
				dispose();
			}
		});
		
		SearchButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				searchVoter searchV = new searchVoter(x,y);
				searchV.setVisible(true);
				dispose();
			}
		});
		
		
		
		//****************Candidates Action***************************************
		
		
		InsertButtonC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				createCandidates insertC = new createCandidates(x,y);
				insertC.setVisible(true);
				dispose();
			}
		});
		
		
		UpdateButtonC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				updateCandidates updateC = new updateCandidates(x,y);
				updateC.setVisible(true);
				dispose();
			}
		});
		
		DeleteButtonC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				deleteCandidates deleteC = new deleteCandidates(x,y);
				deleteC.setVisible(true);
				dispose();
			}
		});
		
		SearchButtonC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				searchCandidates searchC = new searchCandidates(x,y);
				searchC.setVisible(true);
				dispose();
			}
		});
		
		
		
		//**********************Count Actions***************************************
		
		
				InsertButtonCO.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				createCount insertCO = new createCount(x,y);
				insertCO.setVisible(true);
				dispose();
			}
		});
		
		
		UpdateButtonCO.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				updateCount updateCO = new updateCount(x,y);
				updateCO.setVisible(true);
				dispose();
			}
		});
		
		DeleteButtonCO.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				deleteCount deleteCO = new deleteCount(x,y);
				deleteCO.setVisible(true);
				dispose();
			}
		});
		
		SearchButtonCO.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				searchCount searchCO = new searchCount(x,y);
				searchCO.setVisible(true);
				dispose();
			}
		});
		
		
		//***********************Center Action*****************************
		
		
		
		
				InsertButtonCE.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				createCenter insertCE = new createCenter(x,y);
				insertCE.setVisible(true);
				dispose();
			}
		});
		
		
		UpdateButtonCE.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				updateCenter updateCE= new updateCenter(x,y);
				updateCE.setVisible(true);
				dispose();
			}
		});
		
		DeleteButtonCE.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				deleteCenter deleteCE = new deleteCenter(x,y);
				deleteCE.setVisible(true);
				dispose();
			}
		});
		
		SearchButtonCE.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				searchCenter searchCE = new searchCenter(x,y);
				searchCE.setVisible(true);
				dispose();
			}
		});
		
	
	
	//**************************************Ward Actions***************************************
		
		
		
				InsertButtonW.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				createWard insertW = new createWard(x,y);
				insertW.setVisible(true);
				dispose();
			}
		});
		
		
		UpdateButtonW.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				updateWard updateW= new updateWard(x,y);
				updateW.setVisible(true);
				dispose();
			}
		});
		
		DeleteButtonW.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				deleteWard deleteW = new deleteWard(x,y);
				deleteW.setVisible(true);
				dispose();
			}
		});
		
		SearchButtonW.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				searchWard searchW = new searchWard(x,y);
				searchW.setVisible(true);
				dispose();
			}
		});
		
		
		
		//**************showall action*************************
	
		showallButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				showPage show = new showPage(x,y);
				show.setVisible(true);
				dispose();
			}
		});
		
		
		//***********subquery action*************************
		
		subqueryButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				subquery sub = new subquery(x,y);
				sub.setVisible(true);
				dispose();
			}
		});
		
		//***************joining action*****************************
		
		joiningButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				joining join = new joining(x,y);
				join.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		
		
		
	}



public static void main(String[] args) {
        new MainPage(1000,1000);
		
    }


}