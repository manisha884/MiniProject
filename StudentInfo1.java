import java.io.*;
import java.sql.*;
import java.util.*;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StudentInfo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			int i;
			File f=new File("data.txt");
			FileWriter fw= new FileWriter("data.txt");
			fw.write("Neha,hadpsar, 2011");
			fw.write("\n Jyoti, shivaji nagar,1994");
			fw.write("\n Manisha,delhi,1997");
			fw.write("\n Ram,pune,2000");
			fw.close();
			
			if(f.createNewFile()){
				System.out.println("File Created Sucefully");
			}
			else{
				System.out.println("Already exist");

			}
			
			FileReader fr=new FileReader("data.txt");
			while((i=fr.read())!=-1){
				System.out.print((char)i);
			}
			System.out.println("\n");
			StringTokenizer st =new StringTokenizer("Neha,hadpsar, 2011", ",");
		        while (st.hasMoreTokens()){
		        System.out.println(st.nextToken());
		        }
		        System.out.println("\n");
				StringTokenizer st1=new StringTokenizer("Jyoti, shivaji nagar,1994", ",");
		        while (st1.hasMoreTokens()){
		            System.out.println(st1.nextToken());
		        }
		        System.out.println("\n");

	            StringTokenizer st2 =new StringTokenizer("Manisha,delhi,1997", ",");
	            while (st2.hasMoreTokens()){
		            System.out.println(st2.nextToken());
		        }
		        System.out.println("\n");

	            StringTokenizer st3 =new StringTokenizer(" Ram,pune,2000", ",");
	            while (st3.hasMoreTokens()){
		            System.out.println(st3.nextToken());

		        }
	            
	            ArrayList<String> al=new ArrayList<String>();
	    		al.add("Neha,hadpsar, 2011");
	    		al.add("Jyoti, shivaji nagar,1994");
	    		al.add("Manisha,delhi,1997");
	    		al.add(" Ram,pune,2000");
	    		
	    		Iterator<String> itr=al.iterator();
	    		while(itr.hasNext())
	    		{
	    		System.out.println(itr.next());	
	    		}
	    		System.out.println("\n");
	    		
	    		Class.forName("com.mysql.jdbc.Driver");
	    		String url="jdbc:mysql://localhost:3306/";
	    		String databaseName="studentinfo";
	    		String username="root";
	    		String password ="";
	    		
	    		Connection con=(Connection) DriverManager.getConnection(url+databaseName,username,password);
	    		
	    		if(con!= null)
	    		{
	    			System.out.println("Connected to database");
	    		}else{
	    			System.out.println("Failed connection");
	    		}
	    	
	    		PreparedStatement stmt=(PreparedStatement) con.prepareStatement("Insert into studentinfo(name,address,dob) values(?,?,?)");
	    		stmt.setString(1, "Neha");
	    		stmt.setString(2,"hadpsar");
	    		stmt.setString(3,"2011");
	    		
			int j=stmt.executeUpdate();
			
	    		stmt.setString(1, "Jyoti");
	    		stmt.setString(2,"shivaji nagar");
	    		stmt.setString(3,"1994");
	    		
	                j=stmt.executeUpdate();
			
	    		stmt.setString(1, "Manisha");
	    		stmt.setString(2,"delhi");
	    		stmt.setString(3,"1997");
	    		
			j=stmt.executeUpdate();
			
	    		stmt.setString(1, "Ram");
	    		stmt.setString(2,"pune");
	    		stmt.setString(3,"2000");
	    		

	    		 j=stmt.executeUpdate();  
	    		System.out.println(j+" records inserted");  
	    		System.out.println("\n");
	    		
	    		ResultSet rs=stmt.executeQuery("select * from StudentInfo");
	    		while(rs.next())
	    		{
	    			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
	    		}
	    		con.close();
	         
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
