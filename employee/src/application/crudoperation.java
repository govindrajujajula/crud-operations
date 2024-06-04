package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class crudoperation {
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	 private static final String username ="root";
	 private static final String password ="rootGovind@014";
	 
	public static void main(String[] args) {
		
		int ch;
		do {
			System.out.println("CRUD Opertions");
			System.out.println("***************");
			display();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter yours choice :");
			ch = Integer. parseInt(sc.next());
			System.out.println("********************");
			switch(ch) {
			case 1: 
				Create_DataBase();
				break;
			case 2:
				Drop_DataBase();
				break;
			case 3: 
				Create_Table();
				break;
			case 4:
				Drop_Table();
				break;
			case 5: 
				Insert_into_Table();
				break;
			case 6:
				Delete_record_from_Table();
				break;
			case 7: 
				Update_Table();
				break;
			case 8: 
				Get_by_Record();
				break;
			case 9: 
				Get_all_Data();
				break;
			case 10: 
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid");
				break;
			}
		} while (ch>0);
		
	}

	private static void Get_all_Data() {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + sc.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Table Name :");
			String name ="select*from " + sc.next();
			PreparedStatement pmst = conn.prepareStatement(name);
		    ResultSet X=pmst.executeQuery();
		    while(X.next()) {
		    System.out.println("*");
		    System.out.println("ID : "+X.getInt("id"));
		    System.out.println("Name : "+X.getString("name"));
		    System.out.println("Age : "+X.getInt("age"));
		    System.out.println("Email : "+X.getString("email"));
		    System.out.println("*");
		    }
		    pmst.close();
		    conn.close();		    		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Get_by_Record() {
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Table Name :");
			String name ="select*from " + src.next() +" where email= ?";
			PreparedStatement pmst = conn.prepareStatement(name);
			System.out.println("Enter the Email : ");
			pmst.setString(1, src.next());
		    ResultSet X=pmst.executeQuery();
		    while(X.next()) {
		    System.out.println("*");
		    System.out.println("ID : "+X.getInt("id"));
		    System.out.println("Name : "+X.getString("name"));
		    System.out.println("Age : "+X.getInt("age"));
		    System.out.println("Email : "+X.getString("email"));
		    System.out.println("*");
		    }
		    pmst.close();
		    conn.close();		    		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Update_Table() {
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Table Name :");
			String name ="update " + src.next()+" set name= ?, email= ?, age = ? where id = ?";
			PreparedStatement pmst = conn.prepareStatement(name);			
			System.out.println("Enter the Name : ");
			pmst.setString(1, src.next());
			System.out.println("Enter the Email : ");
			pmst.setString(2, src.next());
			System.out.println("Enter the Age : ");
			pmst.setInt(3, src.nextInt());
			System.out.println("Enter Id : ");
			pmst.setInt(4, src.nextInt());
		    int i = pmst.executeUpdate();		    
		   if(i>0) {
			   System.out.println("Table Updated Successfully");
		   }
		   else {
			   System.out.println("Table Not Updated");
		   }
		    pmst.close();
		    conn.close();		    		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Delete_record_from_Table() {
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Table Name :");
			String name ="delete from " + src.next()+" where email= ? ";
			PreparedStatement pmst = conn.prepareStatement(name);
			System.out.println("Enter the Email : ");
			pmst.setString(1, src.next());
		    int i = pmst.executeUpdate();
		    
		   if(i>0) {
			   System.out.println("Record Deleted");
		   }
		   else {
			   System.out.println("Record Not Deleted");
		   }
		    pmst.close();
		    conn.close();		    		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Insert_into_Table() {
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );
			
			System.out.println("Enter Table Name :");
			String name ="drop table " + src.next();
			PreparedStatement pmst = conn.prepareStatement(name);
		    int i = pmst.executeUpdate();
		    
		   if(i==0) {
			   System.out.println("Table Deleted");
		   }
		   else {
			   System.out.println("Table Not Deleted");
		   }
		    pmst.close();
		    conn.close();		    
		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Drop_Table() {
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );
			
			System.out.println("Enter Table Name :");
			String name ="drop table " + src.next();
			PreparedStatement pmst = conn.prepareStatement(name);
		    int i = pmst.executeUpdate();
		    
		   if(i==0) {
			   System.out.println("Table Deleted");
		   }
		   else {
			   System.out.println("Table Not Deleted");
		   }
		    pmst.close();
		    conn.close();		    
		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}

	private static void Create_Table() {
		
		
		try {
			Scanner src = new Scanner(System.in);
			System.out.println("Enter Database Name :");
			String url ="jdbc:mysql://localhost:3306/" + src.next();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Table Name :");
			String name ="Create table " + src.next()+ "(id int, name varchar(20), age int, email varchar(30))";
			PreparedStatement pmst = conn.prepareStatement(name);
		    int i = pmst.executeUpdate();
		    
		   if(i==0) {
			   System.out.println("Table Created");
		   }
		   else {
			   System.out.println("Table Not Created");
		   }
		    pmst.close();
		    conn.close();		    
		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }

	}

	private static void Drop_DataBase() {
		
		try {
			Scanner src = new Scanner(System.in);
		    String url ="jdbc:mysql://localhost:3306/";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url , username  , password );		
			System.out.println("Enter Database Name :");
			String name ="Drop database " + src.next();
			PreparedStatement pmst = conn.prepareStatement(name);
		    int i = pmst.executeUpdate();
		    
		   if(i==0) {
			   System.out.println("Database Deleted");
		   }
		   else {
			   System.out.println("Database Not Deleted");
		   } 
		    pmst.close();
		    conn.close();		    
		    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
	}
	
	private static void Create_DataBase() {
		
		try {
			Scanner src = new Scanner(System.in);
		    String url ="jdbc:mysql://localhost:3306/";
			Class.forName(driver);		
			Connection conn = DriverManager.getConnection(url , username  , password );			
			System.out.println("Enter Database Name :");
			String name ="Create database " + src.next();
			PreparedStatement pmst = conn.prepareStatement(name);		
			int i = pmst.executeUpdate();
		    
		   if(i>0) {
			   System.out.println("Database Created");
		   }
		   else {
			   System.out.println("Database Not Created");
		   }	    
		    pmst.close();
		    conn.close();		    	    
		} 
		catch (Exception e) {
		 e. printStackTrace();
	    }
		
	}

	private static void display() {
		System.out.println("\t1.Create DataBase");
		System.out.println("\t2.Drop DataBase");
		System.out.println("\t3.Create Table");
		System.out.println("\t4.Drop Table");
		System.out.println("\t5.Insert Records into Table");
		System.out.println("\t6.Delete Records into Table");
		System.out.println("\t7.Update Table");
		System.out.println("\t8.GetbyRecord");
		System.out.println("\t9.GetallData");
		System.out.println("\t10.EXIT");
	}
}