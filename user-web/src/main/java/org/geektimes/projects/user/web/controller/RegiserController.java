package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.RestController;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/account")
public class RegiserController implements RestController {

    private UserService userService = new UserServiceImpl();

    /**
     * 注入不成功
     * @throws Throwable
     */
    //@Resource(name = "bean/UserService")
    //private UserService userService;


    @POST
    @Path("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phonenumber);
        boolean ret = userService.register(user);
        ServletContext servletContext = request.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(request.getContextPath()+"/hello/world");
        if(ret){
            request.setAttribute("success","ok");
        }else{
            request.setAttribute("success","error");
        }
        requestDispatcher.forward(request, response);
    }

}
