package controller;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserGetAllServlet extends HttpServlet {

    UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = userService.findAll();
        System.out.println(userList);
        request.setAttribute("users", userList);
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }
}
