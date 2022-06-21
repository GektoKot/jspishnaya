package servletnaya;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/users-list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> users = new ArrayList<>() {{
            add(new User("Vasya","Pupkin"));
            add(new User("Petya","Petushok"));
            add(new User("Tetya","Dyadya"));
            add(new User("Dril","Biba"));
            add(new User("Gnyava","Buba"));
            add(new User("Gnyava","Buba"));
            add(new User("Gnyava","Buba"));
            add(new User("Gnyava","Buba"));
            add(new User("Shmiga","Boba"));
            add(new User("Motya","Kotya"));
            add(new User("chupa","chups"));
        }};

        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users-list.jsp").forward(req,resp);
    }
}
