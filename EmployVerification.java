

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogAction")
public class EmployVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password=request.getParameter("id");
		String mail=request.getParameter("uname");
		//System.out.print(mail);
		//System.out.print(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhukar","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from employreg");
		
			//System.out.print(rs.getString());
			int j=0;
			while(rs.next())
			{
				
				
				String x=rs.getString(2);
				
				String y=rs.getString(3);
				
				if(y.equals(mail)){
					
				if(x.equals(password)){
					
				j=1;
					break;
			}
				else {
					break;
				}
			}
			else {
			}
				
			}
			if(j>0)
			{
				response.sendRedirect("EmpDe.jsp");
			}
			else
			{
				response.sendRedirect("loginfail.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
