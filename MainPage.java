

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainPage() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("print")!=null)
		{
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csfproj","root","root");  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from deposit join withdrawl join transfer");  
            out.println("<table border=1 width=30% height=30%>");  
            out.println("<tr><th>Amount_Deposit</th><th>Amount_Withdrawl</th><th>Transfer_Account</th><th>Transfer_Amount</th><th>Current_Balance</th><tr>");  
            String Amt_depo=null,Amt_with=null,acc=null,amt=null;
            int Amt_deposit=0,Amount_withdrwal=0,amt_transfer=0;
            while (rs.next()) 
            {    
            	Amt_depo = rs.getString("Amount_Deposit");
            	Amt_deposit = Integer.parseInt(rs.getString("Amount_Deposit"));
            	Amt_with = rs.getString("Amount_Withdrawl");
            	Amount_withdrwal=Integer.parseInt(rs.getString("Amount_Withdrawl"));
                acc = rs.getString("Account");
                amt = rs.getString("Amount");
                amt_transfer=Integer.parseInt(rs.getString("Amount"));
                //out.println("<tr><td>"+ "CURRENT BALANCE: Rs."+"</td><td>"+Balance_str+"</td></tr>");
            }
            int Balance=(int)(Amt_deposit-Amount_withdrwal-amt_transfer);
            String Balance_str=Integer.toString(Balance);
            out.println("<tr><td>" + Amt_depo + "</td><td>" + Amt_with + "</td><td>" + acc + "</td><td>"+ amt+"</td><td>"+Balance_str+"</td></tr>"); 
            out.println("</table>");
            
            out.println("</html></body>");  
     
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		MainDAO rDao = new MainDAO();
		if(request.getParameter("Deposit")!=null)
		{
		String amt = request.getParameter("amt");
Member member_1 = new Member(amt);
		
		String result =rDao.insert_deposit(member_1);

		response.getWriter().print(result);
		}
		else if(request.getParameter("Withdrawl")!=null)
		{
		String amt = request.getParameter("amt");
		Member member_2 = new Member(amt);		

		String result =rDao.insert_withdrawl(member_2);

		response.getWriter().print(result);
		}
		else if(request.getParameter("Transfer")!=null)
		{
			String amt = request.getParameter("amt");
			String acc=request.getParameter("acc");
			Member member_3 = new Member(amt,acc);

			String result=rDao.insert_transfer(member_3);

			response.getWriter().print(result);

		}
		else if(request.getParameter("Address")!=null)
		{
		String ID=request.getParameter("ID");
		String line1 = request.getParameter("line1");
		String line2 = request.getParameter("line2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin = request.getParameter("pin");
		 //Signin signin_3=new Signin();
        /*signin.setLine1(line1);
        signin.setLine2(line2);
        signin.setCity(city);
        signin.setState(state);
        signin.setPin(pin);*/
	        Signin signin_3 = new Signin(ID,line1,line2, city, state,pin);	 
		String result = rDao.update_address(signin_3);

      	response.getWriter().print(result);
		}
		else if(request.getParameter("signin")!=null)
		{
		String cid = request.getParameter("cid");
       
		String psw = request.getParameter("psw");
		
       Signin signin_2 = new Signin(cid,psw);
		

		String result=rDao.insert_signin(signin_2);

      	response.getWriter().print(result);
		}
		else if(request.getParameter("signup")!=null)
		{
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
		String line1 = request.getParameter("line1");
       
		String line2 = request.getParameter("line2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin = request.getParameter("pin");
		String ID=request.getParameter("ID");
		String psw = request.getParameter("psw");
		//String amt=request.getParameter("Amount");
        Signin signin_1 = new Signin(fname,lname,line1,line2, city, state,pin,ID,psw);
		

		String result = rDao.insert_signup(signin_1);

      	response.getWriter().print(result);
	}
		else if(request.getParameter("close")!=null)
		{
			
			String result=rDao.close();
			response.getWriter().print(result);
		}
		else if(request.getParameter("delete")!=null)
		{
			
			String result=rDao.delete();
			response.getWriter().print(result);
		}
}
}
