
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
class DBConnection {
     String host="jdbc:mysql://localhost:3306/sports" ;
    String user="root";
    String pass="";
    Connection conn = getConnection();
    
   
     //initialise connection object
       
    public static void main(String[] args) {
       
    
    }
   
    public Connection getConnection(){
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

   
     public void insertsports(String first_name,String last_name,
             String sir_name, String username,String email,String team,
             String level, String number, String password,String dob, 
             String gender) {
         String q="INSERT into users(first_name,last_name,sir_name,username,"
                 + "email,team,level,number,password,dob,gender)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
         
         try{
             int k=0;
             PreparedStatement st=getConnection().prepareStatement(q);
            
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
    

    if(st.executeUpdate()>k){
        JOptionPane.showMessageDialog(null,username+"  signed up successfully");
    }

             
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
     
}
     }
     
     
     
     
      public ResultSet getsports()
 {
         String q="SELECT *FROM  users";
       
         try{
         Statement st=getConnection().createStatement();
         ResultSet rs=st.executeQuery(q);
       
        return rs;
                   
      }
catch(SQLException ex)
{
   
JOptionPane.showMessageDialog(null,ex.getMessage());
 return null;
}
 }
       public void updatesports( String first_name,String last_name,
             String sir_name, String username,String email,String team,
             String level, String number, String password,String dob, 
             String gender){
         String q="UPDATE  users SET first_name=?,last_name=?,sir_name=?,"
                 + "email=?,team=?,level=?,number=?,password=?,dob=?,gender=? WHERE username=?";
       
           
         try{
                int k=0;
          PreparedStatement st=getConnection().prepareStatement(q);
      
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

     public void deletesports(String username) {
         String q="DELETE FROM  users WHERE username=?";
         try{
          int k=0;
                PreparedStatement st=getConnection().prepareStatement(q);
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
