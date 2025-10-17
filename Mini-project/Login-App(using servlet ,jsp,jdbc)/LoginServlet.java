import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
     private static final String DB_URL="jdbc:mysql://localhost:3307/userdb";
     private static final String DB_USER="root";
     private static final String DB_pass=" ";

   @Override
  protected void doPOST(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");

  try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
      PreparedStatement ps= conn.preparedStatement(
        "SELECT * FROM users WHERE username = ? AND password=?");
    ps.setString(1,username);
    ps.setString(2,password);

    ResultSet rs= ps.executeQuery();

    if(rs.next()){
       HttpSession session = req.getSession();
       session.setAttribute("username",username);
       resp.sendRedirect("welcome.jsp");
    }else{
       resp.getWriter().println("<h3>Invalid username or password</h3> ");
    }
    conn.close();
  }catch(Exception e){
     e.printStackTrace();
     resp.getWriter().println("Error:" e.getMessage());
  }
  }
}



















         
