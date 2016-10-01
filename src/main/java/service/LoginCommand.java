package service;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.getUserDao();
        if (session.getAttribute("user") == null) {
            User user = userDao
                    .getUserByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));
            if (user != null) {
                session.setAttribute("user", user);
            } else {
                return "error.jsp";
            }
        }
        List<User> users = userDao.getAll();
        session.setAttribute("users", users);
        System.out.println(users.get(0).getLogin());
        return "users.jsp";
    }
}
