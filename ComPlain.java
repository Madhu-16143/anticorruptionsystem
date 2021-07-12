

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
 * Servlet implementation class ComPlain
 */
@WebServlet("/ComPlain")
public class ComPlain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComPlain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nam=request.getParameter("name");
		String fath=request.getParameter("father");
		String adder=request.getParameter("address");
		String mob=request.getParameter("contact");
		String mail=request.getParameter("address");
		String complain=request.getParameter("complain");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhukar","root","");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into complain1 values ('"+nam+"','"+fath+"','"+adder+"','"+mob+"','"+mail+"','"+complain+"')");
			if(i>0)
			{
				//System.out.println("registration suceccssfull");
				response.sendRedirect("successfull.html");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
