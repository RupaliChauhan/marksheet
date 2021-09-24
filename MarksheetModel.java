import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarksheetModel
{
  
  public static void add(MarksheetBean bean) throws Exception
  {
	  Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		 conn.setAutoCommit(false);
		try {
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRoll_no());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());
	
		ps.executeUpdate();
		System.out.println("Inserted");
		
		conn.commit();
		ps.close();
		}
		catch(SQLException e)
		{
			conn.rollback();
		}
		
		conn.close();
	
  }
  
  public static void update(MarksheetBean bean) throws Exception 
  {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	conn.setAutoCommit(false);
	PreparedStatement ps = conn.prepareStatement("update marksheet set Roll_no=?, fname=?,lname=?,physics=?,chemistry=?,maths=? where id =?");
	try
	{
	ps.setString(1, bean.getRoll_no());
	ps.setString(2, bean.getFname());
	ps.setString(3, bean.getLname());
	ps.setInt(4, bean.getPhysics());
	ps.setInt(5, bean.getChemistry());
	ps.setInt(6, bean.getMaths());
	ps.setInt(7, bean.getId());
	
	ps.execute();
	System.out.println("updated");
	conn.close();
	ps.close();
	conn.commit();
	}
	catch(SQLException e)
	{
		conn.rollback();
	}
  }
  
  public static void delete(MarksheetBean bean) throws Exception 
  {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	conn.setAutoCommit(false);
	PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");
	try {
	ps.setInt(1, bean.getId());
	
	ps.execute();
	System.out.println("Deleted");
	conn.close();
	ps.close();
	conn.commit();
	}
	
	catch(SQLException e)
	{
		conn.rollback();
	}
  }

  static void getbycolumn() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select roll_no from marksheet");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			System.out.println(rs.getString("roll_no"));
			
		
		}
		rs.close();
		conn.close();
		
	}
	
  
  public  ArrayList<MarksheetBean> select() throws Exception 
  {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	PreparedStatement ps = conn.prepareStatement("select* from marksheet");
	ResultSet rs =ps.executeQuery();
	
	ArrayList<MarksheetBean> list= new ArrayList<MarksheetBean>();
	while(rs.next())
	{
	MarksheetBean bean=new MarksheetBean();
	 bean.setId(rs.getInt("id"));
	bean.setRoll_no(rs.getString("roll_no"));
	bean.setFname(rs.getString("fname"));
	bean.setLname(rs.getString("lname"));
	bean.setPhysics(rs.getInt("physics"));
	bean.setChemistry(rs.getInt("chemistry"));
	bean.setMaths(rs.getInt("maths"));
	list.add(bean);
	}
	
	rs.close();
	conn.close();
	
	return list;
}

  public void getMerrit () throws Exception
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	  PreparedStatement ps= conn.prepareStatement("select*,(physics+chemistry+maths) as Total,((physics+chemistry+maths)/3) as Percentage from marksheet order by Percentage desc limit 0,3");
	  ResultSet rs= ps.executeQuery();
	  System.out.println("\tID"+"\tROLL_NO"+"\tFNAME"+"\tLNAME"+"\tPHY"+"\tCHEM"+"\tMATHS");
	  System.out.println(" ");
	  while(rs.next())
	  {
		  
		  System.out.print("\t"+rs.getInt("id"));
		  System.out.print("\t"+rs.getString("roll_no"));
		  System.out.print("\t"+rs.getString("fname"));
		  System.out.print("\t"+rs.getString("lname"));
		  System.out.print("\t"+rs.getInt("physics"));
		  System.out.print("\t"+rs.getInt("chemistry"));
		  System.out.println("\t"+rs.getInt("maths"));
	  }
	  conn.close();
	  ps.close();
  }

  public ArrayList <MarksheetBean>getMerritlist() throws Exception
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	  PreparedStatement ps= conn.prepareStatement("select*,((physics+chemistry+maths)/3) as Percentage from marksheet order by Percentage desc limit 0,3");

	  ResultSet rs= ps.executeQuery();
	  ArrayList< MarksheetBean> list = new ArrayList<MarksheetBean>();
	  
	  while(rs.next())
	  {
		  MarksheetBean bean =new MarksheetBean();
		 bean.setId(rs.getInt(1));
		 bean.setRoll_no(rs.getString(2));
		 bean.setFname(rs.getString(3));
		 bean.setFname(rs.getString(4));
		 bean.setId(rs.getInt(5));
		 bean.setId(rs.getInt(6));
		 bean.setId(rs.getInt(7));
		 
		 list.add(bean);
	  }
		
	  ps.close();
	  conn.close();
	  return list;
  }
}

