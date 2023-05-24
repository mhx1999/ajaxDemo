package com.ajax.servlet;

import com.ajax.Service.UserService;
import com.ajax.entity.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }


    private  UserService userService =new UserService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  System.out.println("sdasd");
        String username = request.getParameter("mhx1999");
        System.out.println(username);

        response.setContentType("text/html;charset=utf-8");


        User user = userService.getUserByName(username);
        if(user!=null){
            //该用户名存在，返回该user的json格式数据字符串
            Gson gson = new Gson();
            String s = gson.toJson(user);
            response.getWriter().write(s);


        }else {

            response.getWriter().write("");

        }


//        if("king".equals(username)){
//            //不能使用king用户名
//            //后面这个信息要从DB获取
//            User king = new User(100, "king", "166", "king@sohu.com");
//            //把king转成json格式
//            String strking = new Gson().toJson(king);
//            //返回
//            response.getWriter().write(strking);
//
//        }else{
//            //若用户可以用，返回“”
//            response.getWriter().write("");
//        }
    }
}
