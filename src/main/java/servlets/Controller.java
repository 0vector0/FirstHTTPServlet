package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formHandler")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 4821121089141927458L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("TEXT/HTML");

        String name = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                    break;
                }
            }
        }
        if (name == null) {
            name = req.getParameter("name");
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(10000);
            resp.addCookie(cookie);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("hello " + name);
        printWriter.println("</body></html>");
        printWriter.close();


    }
}
