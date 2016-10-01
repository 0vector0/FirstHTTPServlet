package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formHandler")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 4821121089141927458L;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("userName");
        req.setAttribute("userName", name);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        dispatcher.forward(req, resp);
    }


}
