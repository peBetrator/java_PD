package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        String sid = req.getParameter("id");
        User user;
        if (sid != null) {
            int id = Integer.parseInt(sid);
            user = model.getUserById(id);
            req.setAttribute("name", user.getName());
            req.setAttribute("pass", user.getPassword());
            req.setAttribute("id", sid);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        String sid = req.getParameter("id");

        if (sid != null) {
            int id = Integer.parseInt(sid);
            String newName = req.getParameter("name");
            String newPass = req.getParameter("pass");
            model.getUserById(id).setName(newName);
            model.getUserById(id).setPassword(newPass);
            req.setAttribute("edit", 1);
        }
        doGet(req, resp);
    }
}