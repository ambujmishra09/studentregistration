package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Statement;

public class StudentRegistration {
	
	
	public static void main(String[] args) {
		System.out.println("1.INSERT RECORD");
		System.out.println("2UPDATE RECORD");
		System.out.println("3.DELETE RECORD");
		System.out.println("4.VIEW RECORD");
		System.out.println("5.EXIT");
		
		Scanner sc = new Scanner(System.in);
		char a;
		
        
        do {
        System.out.println("CHOOSE ANY OPERATION FROM 1 TO 5");
        int n = sc.nextInt();
	       switch(n) {
	       case 1 : try
			{
	   		Class.forName("com.mysql.jdbc.Driver");
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","#ambuj09");
	   		PreparedStatement stmt = con.prepareStatement("insert into regform values(?,?,?,?)");
	   		System.out.println("Enter Student ID");
	   		int id = sc.nextInt();
	   		System.out.println("Enter Student Name");
			String name = sc.next();
			System.out.println("Enter Student Email");
			String email = sc.next();
			System.out.println("City");
			String city = sc.next();
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3,email);
			stmt.setString(4,city);
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			  
			con.close(); 
			break;
			  
			}catch(Exception e){ System.out.println(e);}  
			  
	       case 2 :
	    	   try
				{
		   		Class.forName("com.mysql.jdbc.Driver");
		   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","#ambuj09");
		   	    String sqlUpdate = "update regform set name =? ,  email =? , city = ? where id =?";
		   	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    
		   	    System.out.println("Enter Student Name");
		   	    String name = br.readLine();
		   	    System.out.println("Enter Student Email");
		   	    String email= br.readLine();
		   	    System.out.println("City");
		   	    String city= br.readLine();
		   	   
		   	    System.out.println("Enter Student ID");
		   	    int id = Integer.parseInt(br.readLine());
				PreparedStatement stmt=con.prepareStatement(sqlUpdate);
				
			
				
				stmt.setString(1,name);
				stmt.setString(2,email);
				stmt.setString(3,city);
				stmt.setInt(4,id);
				
				
				
				stmt.executeUpdate();  
				System.out.println(" records updated");  
				    
				con.close(); 
				
				break;
				  
				}catch(Exception e){ System.out.println(e);}  
	       case 3 :
	    	   try
	   		{
	   		Class.forName("com.mysql.jdbc.Driver");
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","#ambuj09");
	   		PreparedStatement stmt=con.prepareStatement("delete from regform where id=?");  
	   		System.out.println("Enter Student ID");
	   		int id = sc.nextInt();
	   		stmt.setInt(1,id);  
	   		  
	   		int i=stmt.executeUpdate();  
	   		System.out.println(i+" records deleted"); 
	        
	        break;

	   		}
	   		catch(Exception e)
	   		{
	   			System.out.println(e);
	   		}
	       case 4:
	    	   try
		   		{
		   		Class.forName("com.mysql.jdbc.Driver");
		   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","#ambuj09");
		   		Statement s=con.createStatement();
		   		ResultSet rs=s.executeQuery("select * from regform");
		   		while(rs.next())
		   		{
		   			System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email") + "\t" + rs.getString("city")  );
		   		}
		   		}
	    	   catch(Exception e)
	    		{
	    			System.out.println(e);
	    		}
	    	   break;
	       case 5 :
	    	   System.exit(0);
			}
	    
	    System.out.println("Continue(Y/N)");
        a = sc.next().charAt(0);

} while(a=='Y'|| a=='y');
 
	

		
		

	       


	       
	}
}

