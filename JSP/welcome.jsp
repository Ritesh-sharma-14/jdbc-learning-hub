//JSP is used to embedded Java in html for dynamic Pages
<%@ page ContentType="text/html"%>
  <html>
  <body>
   <h2>Welcome , <%=request.getParameter("username") %></h2>
  </body>
  </html>
