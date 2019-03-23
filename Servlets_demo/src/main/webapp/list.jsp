<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
            <h2>Users</h2>
        </div>
        <%
            List<User> users = (List<User>) request.getAttribute("users");

            if (users != null && !users.isEmpty()) {
                out.println("<table><tr><th>ID</th><th>user</th><th>pass</th><th>action</th></tr>");
                for (int i = 0; i < users.size(); i++) {
                    out.println("<tr><td>" + users.get(i).getId() + "</td>");
                    out.println("<td>" + users.get(i).getName() + "</td>");
                    out.println("<td>" + users.get(i).getPassword() + "</td>");
                    out.println("<td>" + "<form method=" +
                            "get" + " action='edit'" +
                            "><input type=" +
                            "submit" + " value=" +
                            "Edit" + " />" +
                            "<input type=" +
                            "hidden" + " name=" +
                            "id" + " value=" +
                            users.get(i).getId() + " />" +
                            "</form></td></tr>");

                }
                out.println("</table>");
            } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/src/main/'">Back to main</button>
</div>
</body>
</html>