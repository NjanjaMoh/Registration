
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class BDConnection {

    /**
     * @param args the command line arguments
     */
     String host="jdbc:mysql://localhost:3306/k254sports2";
    String user="root";
    String pass="";
    Connection conn;
   
     //initialise connection object
       
    public static void main(String[] args) {
        // TODO code application logic her
    
    //declare connection object
    
    }
   
    public Connection getConnect(){
        try {
            conn =DriverManager.getConnection(host, user, pass);
            JOptionPane.showMessageDialog(null,"connection Successful");
            return conn;
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
          return null;  
        }
    }

   
     public void insertk254sports2(String first_name,String last_name,
             String sir_name, String username,String email,String team,
             String level, String number, String password,String dob, 
             String gender, String prof_pic, String cover_pic, 
             String description, String user_reg_date, String posts) {
         String q="INSERT into users(first_name,last_name,sir_name,username,"
                 + "email,team,level,number,password,dob,gender,prof_pic,"
                 + "cover_pic,description,user_reg_date,post)VALUES(?,?,?,?,?,?,?,?)";
         
         try{
             int k=0;
             PreparedStatement st=getConnect().prepareStatement(q);
             
              st.setString(2,first_name);
               st.setString(3,last_name);
                st.setString(4,sir_name);
                st.setString(5,username);
                st.setString(6,email);
                st.setString(7,team);               
                st.setString(8,level);
                st.setString(9,number);
                st.setString(10,password);
                st.setString(11,dob);
                st.setString(12,gender);
                st.setString(13,prof_pic);
                st.setString(14,cover_pic);
                st.setString(15, description);  
                st.setString(16, user_reg_date);
                st.setString(17, posts);

    if(st.executeUpdate()>k){
        JOptionPane.showMessageDialog(null,username+"  signed up successfully");
    }

             
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
     
}
     }
     
     
     
     
      public ResultSet getk254sports2()
 {
         String q="SELECT *FROM  users";
       
         try{
         Statement st=getConnect().createStatement();
         ResultSet rs=st.executeQuery(q);
       
        return rs;
                   
      }
catch(SQLException ex)
{
   
JOptionPane.showMessageDialog(null,ex.getMessage());
 return null;
}
 }
       public void updatek254sports2(String user_id, String first_name,String last_name,
             String sir_name, String username,String email,String team,
             String level, String number, String password,String dob, 
             String gender, String prof_pic, String cover_pic, 
             String description, String user_reg_date, String posts){
         String q="UPDATE  users SET first_name=?,last_name=?,sir_name=?,username=?,"
                 + "email=?,team=?,level=?,number=?,password=?,dob=?,gender=?,prof_pic=?,"
                 + "cover_pic=?,description=?,user_reg_date=?,post=? WHERE user_id=?";
       
           
         try{
                int k=0;
          PreparedStatement st=getConnect().prepareStatement(q);
      
              st.setString(1,first_name);
               st.setString(2,last_name);
                st.setString(3,sir_name);
                st.setString(4,username);
                st.setString(5,email);
                st.setString(6,team);               
                st.setString(7,level);
                st.setString(8,number);
                st.setString(9,password);
                st.setString(10,dob);
                st.setString(11,gender);
                st.setString(12,prof_pic);
                st.setString(13,cover_pic);
                st.setString(14, description);  
                st.setString(15, user_reg_date);
                st.setString(16, posts);
                st.setString(17,user_id);

         
 if(st.executeUpdate()>k)
           {
           JOptionPane.showMessageDialog(null,username+ "user record updated");
           }
}
catch(SQLException x)
           {
     JOptionPane.showMessageDialog(null,x.getMessage());
 }
 }

     public void deletek254sports2(String username) {
         String q="DELETE FROM  users WHERE username=?";
         try{
          int k=0;
                PreparedStatement st=getConnect().prepareStatement(q);
                st.setString(5,username);
           
       if(st.executeUpdate()>k){
               JOptionPane.showMessageDialog(null,username+"  user record deleted");
    }
}
catch(SQLException ex){
   
JOptionPane.showMessageDialog(null,ex.getMessage());
     
}
    


     }
     
    }
    

