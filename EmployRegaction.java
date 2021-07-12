

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployRegaction
 */
@WebServlet("/EmployRegaction")
public class EmployRegaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployRegaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String password=request.getParameter("psw");
		String email=request.getParameter("email");
		String security=request.getParameter("enter security question");
		String contact=request.getParameter("mobileno");
		String empid=request.getParameter("employee id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhukar","root","");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into employreg values ('"+email+"','"+password+"','"+empid+"','"+contact+"','"+security+"')");
			if(i>0)
			{
				//System.out.println("registration suceccssfull");
				response.sendRedirect("employeelogin.html");
			}
			else
			{
				System.out.print("saddy");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			}
	}


