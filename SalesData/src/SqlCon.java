import java.sql.*; 


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
}
