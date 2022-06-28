package servletnaya;

import dao.UserDaoHibernate;
import entity.Hobby;
import entity.Pet;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/users-list")
public class UserListServlet extends HttpServlet {

//    private final UserDao userDao = new UserDao();
    private final UserDaoHibernate userDaoHibernate = new UserDaoHibernate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

//        try {
//            userDao.save(new User(name, surname, age));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        userDaoHibernate.save(new User(name, surname, new HashSet<>(), new ArrayList<>()));
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            List<User> users = userDao.findAll();
//            req.setAttribute("users", users);
//            getServletContext().getRequestDispatcher("/users-list.jsp").forward(req, resp);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        List<User> users = userDaoHibernate.findAll();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users-list.jsp").forward(req, resp);
    }
}
