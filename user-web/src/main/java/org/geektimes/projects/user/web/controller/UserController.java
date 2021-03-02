package org.geektimes.projects.user.web.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 用户注册功能
 */
@Path("/user")
public class UserController  implements PageController {

    @Override
    @GET
    @Path("/toregister")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "register.jsp";
    }

}
