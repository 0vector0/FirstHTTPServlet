package service;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.getUserDao();
        if(session.getAttribute("user") == null) {
            User user = new User();
            user.setLogin(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));
            userDao.createUser(user);
            return "index.jsp";
        } else {
            List<User> users = userDao.getAll();
            session.setAttribute("users", users);
            return "users.jsp";
        }

    }
}
