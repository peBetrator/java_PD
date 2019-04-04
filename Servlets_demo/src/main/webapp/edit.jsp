<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div>
    <h1 class='container-fluid'>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Edit user</h2>
        </div>
        <%
            if (request.getAttribute("edit") != null) out.println("<p>User was edited!</p>");
            else {
                String name = (String) request.getAttribute("name");
                String pass = (String) request.getAttribute("pass");
                String id = (String) request.getAttribute("id");

                if (name != null && pass != null) {
                    out.print("<form method=\"post\">");
                    out.print("<label>Name:");
                    out.print("<input type=\"text\" name=\"name\" value=" + name + "></br></label>");
                    out.print("<label>Password:");
                    out.print("<input type=\"text\" name=\"pass\" value=" + pass + "></br></label>");
                    out.print("<input type=\"hidden\" name=\"id\" value=" + id + ">");
                    out.println("<button type=\"submit\">Submit</button>");
                    out.println("</form>");
                    out.print("<div><a href='DeleteServlet?id=" + id + "'>delete</a></div>");
                } else out.println("<p>Something went wrong!</p>");
            }
        %>
    </div>
</div>

<div>
    <button onclick="location.href='list'">Back to user list</button>
</div>
</body>
</html>