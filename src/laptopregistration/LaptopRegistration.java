
package laptopregistration;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class LaptopRegistration extends JFrame 
{
   public LaptopRegistration(){
      
    setLayout(new GridLayout(1,8));
 
    
      final  JFrame logoutframe=new JFrame();
       logoutframe.setSize(400, 400);    
    
       final  JFrame mainframe=new JFrame();
       mainframe.setTitle("MAIN MENU");
      
       mainframe.setSize(400, 400);
       
       final  JFrame addframe=new JFrame();
       addframe.setSize(400, 400);
        addframe.setTitle("ADD LAPTOP");
       final  JFrame updateframe=new JFrame();
       updateframe.setSize(400, 400);
         updateframe.setTitle("UPDATE LAPTOP");
       final  JFrame removeframe=new JFrame();
       removeframe.setSize(400, 400);
       removeframe.setTitle("REMOVE LAPTOP");
        final  JFrame searchframe=new JFrame();
        searchframe.setSize(400, 400);
       searchframe.setTitle("SEARCH LAPTOP");
       
    JPanel plogin=new JPanel();
    plogin.setLayout(new GridLayout(5,2));
    plogin.setForeground(Color.red);
    plogin.setBackground(Color.cyan);
    
    JLabel lbmain=new JLabel( "             **WELL COME BACK**  " );  plogin.add(lbmain);
 lbmain.setHorizontalAlignment(SwingConstants.TRAILING);
    lbmain.setForeground(Color.red);
   
   JLabel lbmain2=new JLabel( "  " ); plogin.add(lbmain2);
    lbmain.setHorizontalTextPosition(JLabel.CENTER);
    lbmain2.setVerticalTextPosition(JLabel.BOTTOM);
    JLabel lb1=new JLabel("ADMINISTRATOR");  plogin.add(lb1);
    lb1.setHorizontalTextPosition(JLabel.CENTER);
    lb1.setVerticalTextPosition(JLabel.BOTTOM);
    JTextField txt1=new JTextField(5);
   txt1 .setHorizontalAlignment(SwingConstants.LEFT);
   
    plogin.add(txt1);
    JLabel lb2=new JLabel("PASSWORD");plogin.add(lb2);
    JPasswordField fieldPassword = new JPasswordField(20);plogin.add(fieldPassword);
    //JTextField txt2=new JTextField(10);plogin.add(txt2);
    JLabel lb3=new JLabel( "  " ); plogin.add(lb3);
    JButton but1=new JButton("LOGIN");plogin.add(but1);
    but1.setForeground(Color.black);
    but1.setBackground(Color.PINK);
    add(plogin);
    
     
    
     
    
  
    but1.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                     try
           {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          }
        catch(ClassNotFoundException c)
                {
                    System.out.println("class not found exception"+c);
                }
        try
          {
              
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ADM");
            
            String sql="Select * from ADMIN where ANAME=? and APASS=?";
            PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, txt1.getText()); 
       pst.setString(2,fieldPassword.getText());
            
            ResultSet rs = pst.executeQuery();                        
       if(rs.next()) {           
           dispose(); 
           txt1.setText("");
           fieldPassword.setText("");
          
       mainframe.setVisible(true);
       logoutframe.setVisible(false);
       
       }
       else {
               JOptionPane.showMessageDialog(null,"wrong pasword or user name");
               }
            }
       catch(SQLException x)
        {
            System.out.println("SQL exeption occures"+x);
        }

                   
                }
                
            });
  

    
    
    
    
    
    
    
    
    
    
  
    JPanel pmain=new JPanel();
     pmain.setVisible(true);
     
     
    pmain.setLayout(new GridLayout(8,7));
    JLabel lbspc=new JLabel(" main menu    ");  pmain.add(lbspc);
   
    lbspc.setHorizontalAlignment(SwingConstants.CENTER);
    JButton buttonadd=new JButton("add laptop pc");pmain.add(buttonadd);
    buttonadd.setBackground(Color.PINK);
     buttonadd.setHorizontalAlignment(SwingConstants.LEFT);
    JButton buttonupdate=new JButton("update laptop pc");pmain.add(buttonupdate);
    buttonupdate.setBackground(Color.PINK);
     buttonupdate.setHorizontalAlignment(SwingConstants.RIGHT);
    JButton buttonremove=new JButton("remove laptop pc");pmain.add(buttonremove);
    buttonremove.setBackground(Color.PINK);
      buttonremove.setHorizontalAlignment(SwingConstants.LEFT);
    JButton buttonsearch=new JButton("search laptop pc");pmain.add(buttonsearch);
    buttonsearch.setBackground(Color.PINK);
     buttonsearch.setHorizontalAlignment(SwingConstants.RIGHT);
    JButton buttonlogout=new JButton("logout");pmain.add(buttonlogout);
     buttonlogout.setBackground(Color.PINK);
     buttonlogout.setHorizontalAlignment(SwingConstants.CENTER);
   mainframe.add(pmain);
     
    
   buttonadd.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                    addframe.setVisible(true);
                   mainframe.setVisible(false);
          
            }
            
             });
    
   
   
    buttonremove.addActionListener((ActionEvent e) -> {
        
        removeframe.setVisible(true);
        mainframe. setVisible(false);
    });
     buttonupdate.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                    updateframe.setVisible(true);
                   mainframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
    
    
    
     buttonsearch.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                    searchframe.setVisible(true);
                   mainframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
      buttonlogout.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                   logoutframe.add(plogin);
                   logoutframe.setVisible(true);
                   mainframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
    
    
    
    
     
        
    JPanel padd=new JPanel();
    
     padd.setVisible(true);
     padd.setBackground(Color.CYAN);
     padd.setLayout(new GridLayout(9,10));
     JLabel lbfh=new JLabel("  ");  padd.add(lbfh);
     JLabel lbowr=new JLabel("  ");  padd.add(lbowr);
     
      JLabel lbowner=new JLabel("owner");  padd.add(lbowner);
    JTextField txtowner=new JTextField(5); padd.add(txtowner);
    JLabel lbposition=new JLabel("position");  padd.add(lbposition);
    JTextField txtposition=new JTextField(5); padd.add(txtposition);
    JLabel lbsn=new JLabel("serial number");  padd.add(lbsn);
    JTextField txtsn=new JTextField(5); padd.add(txtsn);
    JLabel lbid=new JLabel("id");  padd.add(lbid);
    JTextField txtid=new JTextField(5); padd.add(txtid);
    JLabel lblspc=new JLabel( "  " ); padd.add(lblspc);
    JButton buttonregister=new JButton("register");padd.add(buttonregister);
    buttonregister.setBackground(Color.PINK);
     JButton buttonback=new JButton("return");padd.add(buttonback);
   addframe.add(padd);
     buttonback.setBackground(Color.PINK);
    
    
    buttonregister.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
       try
        {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException c)
                {
                    System.out.println("class not found exception"+c);
                }
        try
        {
            String username=txtowner.getText();
            String userposition=txtposition.getText();
            String userid=txtid.getText();
            String laptopsn=txtsn.getText();
           
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/laptop");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT into laptop(uname,uposition,uid,usn)"
                    + "values ('"+username+"','"+userposition+"','"+userid+"','"+laptopsn+" ')");
           txtowner.setText("");
            txtposition.setText("");
           txtid.setText("");
            txtsn.setText("");
             dispose();
            
        }
        catch(SQLException x)
        {
            System.out.println("SQL exeption occures"+x);
             JOptionPane.showMessageDialog(null,"another laptop exists with given serial");
        }
                   
                   
                }
                
            });
   
    buttonback.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                   mainframe.setVisible(true);
                   addframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
   
   
  
   
       
     
     JPanel pupdate=new JPanel();
     pupdate.setVisible(true);
     pupdate.setBackground(Color.cyan);
     pupdate.setLayout(new GridLayout(12,13));
     JLabel lbOLDS=new JLabel("  ");  pupdate.add(lbOLDS);
     JLabel lbOLD=new JLabel("   ");  pupdate.add(lbOLD);
     
     
     JLabel lbOLDSND=new JLabel("OLD SERIAL NUMBER");  pupdate.add(lbOLDSND);
    JTextField txtOLD=new JTextField(5); pupdate.add(txtOLD);
      JLabel lbOLDSN=new JLabel("ENTER NEWER VALUES  ");  pupdate.add(lbOLDSN);
     JLabel lbOLDV=new JLabel("   ");  pupdate.add(lbOLDV);
    JLabel lbuowner=new JLabel("owner");  pupdate.add(lbuowner);
    JTextField txtuowner=new JTextField(5); pupdate.add(txtuowner);
    JLabel lbuposition=new JLabel("position");  pupdate.add(lbuposition);
    JTextField txtuposition=new JTextField(5); pupdate.add(txtuposition);
    JLabel lbusn=new JLabel("serial number");  pupdate.add(lbusn);
    JTextField txtusn=new JTextField(5); pupdate.add(txtusn);
    JLabel lbuid=new JLabel("id");  pupdate.add(lbuid);
    JTextField txtuid=new JTextField(5); pupdate.add(txtuid);
    JLabel lbluspc=new JLabel( "  " ); pupdate.add(lbluspc);
    JButton buttonuppdate=new JButton("update");pupdate.add(buttonuppdate);
   buttonuppdate.setBackground(Color.PINK);
    JButton buttonb=new JButton("return");pupdate.add(buttonb);
    buttonb.setBackground(Color.PINK);
    updateframe.add(pupdate);
    
    
    
   buttonuppdate.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                   try
        {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException c)
                {
                    System.out.println("class not found exception"+c);
                }
        try
        {
           
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/laptop");
            
           String query = "update laptop set UNAME = ? , UPOSITION = ? ,UID = ? ,USN = ?  where USN = ?";
           
           PreparedStatement stmt = con.prepareStatement(query); 
           stmt.setString(1,txtuowner.getText() );
          stmt.setString(2,txtuposition.getText()  );
          stmt.setString(3,txtuid.getText()   );
          stmt.setString(4,txtusn.getText()   );
          stmt.setString(5,txtOLD.getText());
            
            stmt.executeUpdate();
            
    JOptionPane.showMessageDialog(null,"laptop security information updated seccesfully");
        
            
            
            
        }
        catch(SQLException x)
        {
            System.out.println("SQL exeption occures"+x);
        }
                   
                   
                } 
                
                
            });
    
    
    
     buttonb.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                   mainframe.setVisible(true);
                   updateframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
    
      
      
      
      
    
    
    
    
     
      
       JPanel premove=new JPanel();
      
       premove.setBackground(Color.CYAN);
       premove.setLayout(new GridLayout(7,8));
       JLabel lbrsn=new JLabel("serial number");  premove.add(lbrsn);
    JTextField txtrsn=new JTextField(5); premove.add(txtrsn);
      JLabel lblrspc=new JLabel( "  " ); premove.add(lblrspc);
    JButton buttonremov=new JButton("remove");premove.add(buttonremov);
    buttonremov.setBackground(Color.PINK);
    JButton buttonbb=new JButton("return");premove.add(buttonbb);
    buttonbb.setBackground(Color.PINK);
     removeframe.add(premove);
     
 buttonremov.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                   try
        {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException c)
                {
                    System.out.println("class not found exception"+c);
                }
        try
        {
           
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/laptop");
            
           String sql = "delete from laptop where USN = ?";
           PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1,txtrsn.getText());
       
          stmt.executeUpdate( );
          txtrsn.setText(" ");
          
          JOptionPane.showMessageDialog(null,"laptop security information deleted seccesfuly");
          
           dispose();
        }
        catch(SQLException x)
        {
            System.out.println("SQL exeption occures"+x);
        }
                   
                   
                } 
                
                
            });
      buttonbb.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                   mainframe.setVisible(true);
                   removeframe.setVisible(false);
                   
                   
                    
            }
            
            
            
            });
    
     
     
     
     
      
      
     
     
     
     
      
      
      JPanel psearch=new JPanel();
       psearch.setVisible(true);
       psearch.setBackground(Color.CYAN);
     psearch.setLayout(new GridLayout(11,12));
     JLabel lbssnf=new JLabel("   ");  psearch.add(lbssnf);
     JLabel lbssnv=new JLabel("  ");  psearch.add(lbssnv);
     JLabel lbssn=new JLabel("serial number");  psearch.add(lbssn);
    JTextField txtssn=new JTextField(5); psearch.add(txtssn);
      JLabel lblsspc=new JLabel( "  " ); psearch.add(lblsspc);
    JButton buttonserch=new JButton("search");psearch.add(buttonserch);
        buttonserch.setBackground(Color.PINK);
      searchframe.add(psearch);
      
      JLabel lbownersearch=new JLabel("owner");  psearch.add(lbownersearch);
    JTextField txtownersearch=new JTextField(5); psearch.add(txtownersearch);
    JLabel lbpositionsearch=new JLabel("position");  psearch.add(lbpositionsearch);
    JTextField txtpositionsearch=new JTextField(5); psearch.add(txtpositionsearch);
    JLabel lbsnsearch=new JLabel("serial number");  psearch.add(lbsnsearch);
    JTextField txtsnsearch=new JTextField(5); psearch.add(txtsnsearch);
    JLabel lbidsearch=new JLabel("id");  psearch.add(lbidsearch);
    JTextField txtidsearch=new JTextField(5); psearch.add(txtidsearch);
    JButton buttonre=new JButton("return");psearch.add(buttonre);
    buttonre.setBackground(Color.PINK);
      
      
     buttonserch.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                   try
        {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch(ClassNotFoundException c)
                {
                    System.out.println("class not found exception"+c);
                }
        try
        {
           
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/laptop");
            PreparedStatement stmt;
             stmt = con.prepareStatement("select*from laptop where (USN=?)" );
             stmt.setString(1, txtssn.getText());
            ResultSet rs;
            rs=stmt.executeQuery();
            if(rs.next())
            {
             String username=rs.getString("UNAME");
            String userid=rs.getString("UID");
            String userposition=rs.getString("UPOSITION");
            String usersn=rs.getString("USN");
            
           txtownersearch.setText(username);
          txtidsearch.setText(userid);
            txtpositionsearch.setText(userposition);
          txtsnsearch.setText(usersn);
             dispose();
            }
            else
            {
              JOptionPane.showMessageDialog(null,"the laptop you searched is not found");   
            }
            
        }
        catch(SQLException x)
        {
            System.out.println("SQL exeption occures"+x);
        }
                   
                   
                } 
                
                
            });
     
     
     
     buttonre.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                   dispose();
                   mainframe.setVisible(true);
                 searchframe.setVisible(false);
                     
                    
            
            }
            
            
            
            });
    
      
      
    
    
   
      
      
      
      
      
   }
    
    public static void main(String[] args) 
    {
     
     LaptopRegistration    frame=new LaptopRegistration();
        frame.setTitle("laptop registration security system"); 
        
        
       
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
       
        
      }
    
}
