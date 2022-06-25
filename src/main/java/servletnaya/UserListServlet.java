package servletnaya;

import dao.UserDao;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users-list")
public class UserListServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));

        try {
            userDao.save(new User(name, surname, age));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = userDao.findAll();
            req.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/users-list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        int id = Integer.parseInt(req.getParameter("user_id"));
//
//        User user = new User(id);
//        userDao.delete(user);
//        resp.sendRedirect("/");
//
//    }



//    private void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        int id = Integer.parseInt(req.getParameter("user_id"));
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        int age = Integer.parseInt(req.getParameter("age"));
//
//        User user = new User(id, name, surname, age);
//        userDao.update(user);
//        resp.sendRedirect("/");
//    }

//    try {
//        req.setAttribute("users", userDao.findAll());
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//    getServletContext().getRequestDispatcher("/users-list.jsp").forward(req, resp);


}
