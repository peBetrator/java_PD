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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        String sid = req.getParameter("id");
        if (sid != null) {
            int id = Integer.parseInt(sid);
            model.remove(id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("list");
            requestDispatcher.forward(req, resp);
        }
        doGet(req, resp);
    }
}