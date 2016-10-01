package controller;

import service.Command;
import service.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginHandler")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 4821121089141927458L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory factory = CommandFactory.getInstance();
        Command com = factory.getCommand("login");
        String page = com.execute(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}
