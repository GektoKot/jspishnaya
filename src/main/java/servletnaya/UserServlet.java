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

@WebServlet("/user")
public class UserServlet extends HttpServlet {

//    private final UserDao userDao = new UserDao();
    private final UserDaoHibernate userDaoHibernate = new UserDaoHibernate();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button =req.getParameter("button");
        String id = req.getParameter("user_id");
        User user = userDaoHibernate.findById(id).orElseThrow();
        if (button.equals("add_pet")) {
            String petName = req.getParameter("pet");
            Pet pet = new Pet();
            pet.setName(petName);
            user.getPet().add(pet);
            userDaoHibernate.update(user);
            doGet(req, resp);
        }
        if (button.equals("add_hobby")) {
            String hobbyName = req.getParameter("hobby");
            Hobby hobby = new Hobby();
            hobby.setName(hobbyName);
            user.getHobby().add(hobby);
            userDaoHibernate.update(user);
            doGet(req, resp);
        }

        if (button.equals("delete")) {
//            try {
//                int id = Integer.parseInt(req.getParameter("user_id"));
//                User user = new User(id);
//                userDao.delete(user);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            userDaoHibernate.delete(user);
        }
        if ((button.equals("update"))) {
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
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            userDaoHibernate.update(user);
        }
        resp.sendRedirect("/jspishnaya/users-list");
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
