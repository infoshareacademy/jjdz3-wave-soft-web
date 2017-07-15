import usersList.PersistenceUserStorage;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

    @Inject
    @Default
    private PersistenceUserStorage persistenceUserStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("listOfusers", persistenceUserStorage.getAllUsers());
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }

}
