<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "madhukar";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data of the applicants</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>name</b></td>
<td><b>father</b></td>
<td><b>address</b></td>
<td><b>contact</b></td>
<td><b>email</b></td>
<td><b>complain</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM complain1";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("father") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("contact") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("complain") %></td>

</tr>


<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
<%
connection = null;
statement = null;
resultSet = null;
%>
<h3 align="center"><font><strong>Retrieve data of the employee</strong></font></h3>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>email</b></td>
<td><b>password</b></td>
<td><b>employeeid</b></td>
<td><b>contact</b></td>
<td><b>securityquestion</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM  employreg";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("password") %></td>
<td><%=resultSet.getString("employeeid") %></td>
<td><%=resultSet.getString("contact") %></td>
<td><%=resultSet.getString("securityquestion") %></td>

</tr>


<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
<% connection = null;
statement = null;
resultSet = null;
%>

<h3 align="center"><font><strong>Retrieve data of the users</strong></font></h3>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>email</b></td>
<td><b>password</b></td>
<td><b>securityquestion</b></td>
<td><b>contact</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM  regis1";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("password") %></td>
<td><%=resultSet.getString("securityquestion") %></td>
<td><%=resultSet.getString("contactno") %></td>

</tr>


<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>