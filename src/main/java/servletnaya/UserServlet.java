package servletnaya;

import dao.UserDao;
import dao.UserDaoHibernate;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

//    private final UserDao userDao = new UserDao();
    private final UserDaoHibernate userDaoHibernate = new UserDaoHibernate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button =req.getParameter("button");
        if (button.equals("delete")) {
//            try {
//                int id = Integer.parseInt(req.getParameter("user_id"));
//                User user = new User(id);
//                userDao.delete(user);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            int id = Integer.parseInt(req.getParameter("user_id"));
            User user = new User(id);
            userDaoHibernate.delete(user);
            resp.sendRedirect("/jspishnaya/users-list");
        } else {
//            try {
//                int id = Integer.parseInt(req.getParameter("user_id"));
//                String name = req.getParameter("name");
//                String surname = req.getParameter("surname");
//                int age = Integer.parseInt(req.getParameter("age"));
//                User user = new User(id, name, surname, age);
//                userDaoH.update(user);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            int id = Integer.parseInt(req.getParameter("user_id"));
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            int age = Integer.parseInt(req.getParameter("age"));
            User user = new User(id, name, surname, age);
            userDaoHibernate.update(user);
            resp.sendRedirect("/jspishnaya/users-list");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            User user = userDao.findById(req.getParameter("user_id")).orElseThrow();
//            req.setAttribute("user", user);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        User user = userDaoHibernate.findById(req.getParameter("user_id")).orElseThrow();
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
