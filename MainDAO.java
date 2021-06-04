 import java.sql.Connection;
 import java.sql.DriverManager;
 //import java.sql.ResultSet;
 import java.sql.PreparedStatement;
 //import java.sql.Statement;
 //import jakarta.servlet.http.HttpServletResponse;
  //import java.util.Random;

import java.sql.SQLException;

public class MainDAO {
	private String dbUrl = "jdbc:mysql://localhost:3306/csfproj";

	private String dbUname = "root";

	private String dbPassword = "root";

	private String dbDriver = "com.mysql.jdbc.Driver";

	//Customer_ID=0;	

	public void loadDriver(String dbDriver)

	{

		try {

			Class.forName(dbDriver);

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	

	public Connection getConnection()

	{

		Connection con = null;

		try {

			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return con;

	}
	

	public String insert_transfer(Member member)

	{

		loadDriver(dbDriver);

		Connection con = getConnection();

		String result = "Data entered successfully";
		String sql_2="insert into transfer values(?,?)";
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement(sql_2);

			ps1.setString(1, member.getAcc());

			ps1.setString(2, member.getAmt());
		     ps1.executeUpdate();
		}
		 catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

				result = "Data not entered";

			}
		return result;
	}
	public String insert_withdrawl(Member member)
	{
		loadDriver(dbDriver);

		Connection con = getConnection();

		String result = "Data entered successfully";
		String sql_3="insert into withdrawl values(?)";
		PreparedStatement ps2;
		try {
			ps2 = con.prepareStatement(sql_3);

			ps2.setString(1, member.getAmt());

		     ps2.executeUpdate();
		}
		 catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

				result = "Data not entered";

			}
		return result;
	}
	public String insert_deposit(Member member)
	{
		loadDriver(dbDriver);

		Connection con = getConnection();

		String result = "Data entered successfully";
		String sql_4="insert into deposit values(?)";
		PreparedStatement ps3;
		try {
			ps3 = con.prepareStatement(sql_4);

			ps3.setString(1, member.getAmt());

		     ps3.executeUpdate();
		}
		 catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

				result = "Data not entered";

			}
		return result;
	}
	   
	    public String update_address(Signin signin)
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Data entered successfully";
			 

		PreparedStatement ps;

		try {       
	        		String sql_1 = "update signup set Line1=?,line2=?,City=?,State=?,Pin=? where Customer_ID=?";
	        		ps = con.prepareStatement(sql_1);
		ps.setString(1, signin.getLine1());
		ps.setString(2, signin.getLine2());
		ps.setString(3, signin.getCity());

		ps.setString(4, signin.getState());
		ps.setString(5, signin.getPin());
		ps.setString(6, signin.getCid());
		ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			result = "Data not entered";

		}

		return result;

	}
	    public String insert_signin(Signin signin)
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Data entered successfully";
		String sql_1 = "insert into signin values(?,?)";

		PreparedStatement ps;

		try {

		ps = con.prepareStatement(sql_1);
        
		ps.setString(1, signin.getCid());

		ps.setString(2, signin.getPsw());
	    ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			//result = "Data not entered";

		}

		return result;

	}
	    public String insert_signup(Signin signin)
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Data entered successfully";
		String sql_1 = "insert into signup values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps;

		try {
        //Random rd=new Random();
		ps = con.prepareStatement(sql_1);
		ps.setString(1, signin.getFname());
		ps.setString(2, signin.getLname());
		ps.setString(3, signin.getLine1());

		ps.setString(4, signin.getLine2());
		ps.setString(5, signin.getCity());

		ps.setString(6, signin.getState());
		ps.setString(7, signin.getPin());
		ps.setString(8, signin.getPsw());
		//Customer_ID= 50+rd.nextInt(100);
		ps.setString(9, signin.getCid());
		//ps.setString(10, signin.getAmount());
		ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			result = "Data not entered";

		}

		return result;

	}
	    public String close()
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Account closed successfully";
		String sql_1 = "Delete from signin ";
		String sql_2 = "Delete from signup ";
		PreparedStatement ps;
		PreparedStatement ps1;
		try {

		ps = con.prepareStatement(sql_1);
		ps1=con.prepareStatement(sql_2);
	    ps.executeUpdate();
        ps1.executeUpdate();
		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			result = "Account not closed";

		}

		return result;


	    }
	    public String delete()
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Delete successfull";
		String sql_1 = "Delete from transfer";
		String sql_2 = "Delete from deposit";
		String sql_3 = "Delete from withdrawl";
		PreparedStatement ps;
		PreparedStatement ps1;
		PreparedStatement ps2;
		try {

		ps = con.prepareStatement(sql_1);
		ps1=con.prepareStatement(sql_2);
		ps2=con.prepareStatement(sql_3);
		ps.executeUpdate();
        ps1.executeUpdate();
		ps2.executeUpdate();
		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			result = "Delete unsucessfull";

		}

		return result;


	    }
	   /* public String print()
	    {
	    	loadDriver(dbDriver);

			Connection con = getConnection();

			String result = "Data entered successfully";
		String sql_1 = "select * from deposit join withdrawl join transfer";
        try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql_1);
		System.out.println("<table border=1 width=50% height=50%>");  
        System.out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");  
			 while (rs.next()) {
                 String Amt_depo = rs.getString("Amount_Deposit");
                 String Amt_with = rs.getString("Amount_Withdrawl");
                 String acc = rs.getString("Account");
                 String amt = rs.getString("Amount");
                 System.out.println( Amt_depo+" "+
                        Amt_with+" "+acc+" "+amt+" ");			 
                 }
			 con.close();
	    } catch (SQLException s) {

			// TODO Auto-generated catch block

	    	System.out.println(
                    "SQL statement is not executed!");

			result = "Data not entered";

		}
		 catch (Exception e) {
			  
	            // General exception apart from SQLException are
	            // caught here
	            e.printStackTrace();
	        }
		return result;
		}*/
}