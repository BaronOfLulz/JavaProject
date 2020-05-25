import java.sql.*;
import java.util.Stack; 


public class SqlCon 
{
	
	public void myCon(SalesGraph graph) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select s.name,flavor,type,count(id) from snackitems as s"
				+ " join snackbought as l using(name) group by s.name;");
		while(rs.next())
		{
		graph.addItem(new SnackItem(rs.getString(1),rs.getString(2),rs.getString(3)),new Integer(rs.getInt(4)));
		}
		con.close();
		
		}
		catch(Exception e) {System.out.println(e);}
	}
	
	
	
	
	
	
	public void myConFilterAge(SalesGraph graph,int start, int end)
	{
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select s.name,flavor,type,count(id) from snackitems as s"
				+ " join snackbought as l using(name)" +" join snackbuyer as t using(Id) "+" where (t.Age < "+Integer.toString(end)+" and t.age > "+ Integer.toString(start) +") group by s.name;");
		while(rs.next())
		{
		graph.addItem(new SnackItem(rs.getString(1),rs.getString(2),rs.getString(3)),new Integer(rs.getInt(4)));
		}
		con.close();
		
		}
		catch(Exception e) {System.out.println(e);}
		
	}
	
	
	public void myConCustomerDataNoAge(Stack<Customer> customers) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from snackbuyer;");
		while(rs.next())
		{
		customers.push(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		con.close();
		
		}
		catch(Exception e) {System.out.println(e);}
	}
	
	public void myConProductNoFilter(Stack<SnackItem> Items) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from snackitems;");
		while(rs.next())
		{
		Items.push(new SnackItem(rs.getString(1),rs.getString(2),rs.getString(3)));
		}
		con.close();
		
		}
		catch(Exception e) {System.out.println(e);}
	}
	
	
	public void myConInsertCustomer(int id,String firstname,String lastname, int age) throws Exception
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into snackbuyer(Id,FirstName,LastName,Age) Values("+Integer.toString(id)+",\""+firstname +"\",\""+lastname+"\","+Integer.toString(age)+");");
		
		con.close();
		
		}
		catch(Exception e) {throw e; }
	}
	
	public void myConInsertProduct(String name,String flavor,String type) throws Exception
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into snackitems(Name,Flavor,Type) values(\""+name+"\",\""+flavor+"\",\""+type+"\")");
		
		con.close();
		
		}
		catch(Exception e) {throw e; }
	}
	
	public void myConInsertPurchase(int id,String Snackname) throws Exception 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into snackbought values ("+id+",\""+Snackname+"\")");
			
		}
		catch(Exception e) {throw e;}
	}
	
}
