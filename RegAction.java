
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegAction")
public class RegAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password=request.getParameter("psw");
		String email=request.getParameter("email");
		String security=request.getParameter("enter security question");
		String contact=request.getParameter("mobileno");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhukar","root","");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into regis1 values ('"+email+"','"+password+"','"+security+"','"+contact+"')");
			if(i>0)
			{
				//System.out.println("registration suceccssfull");
				response.sendRedirect("log.html");
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


