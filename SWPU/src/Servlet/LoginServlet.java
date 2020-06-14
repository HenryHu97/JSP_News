package Servlet;

import DataBase.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter(); //获得输出流

        String name = request.getParameter("name");
        String password = URLEncoder.encode(request.getParameter("password"),"utf-8");//password转码
        DataBase db = new DataBase();
        if (db.login(name, password)) {
            Object o = request.getSession().getAttribute("onLine");
            String success = "<br> 用户名： " + name + "<br> 密码：" + password + " <br> 登录成功 " + " <br> 当前在线人数： " + o;
            Log_Cookie(name, password, response);//Cookie
            System.out.println(name);
            System.out.println(password);
            System.out.println(o);
            out.println(success);
            out.println();
            request.getRequestDispatcher("/show.html").forward(request,response);//跳转至新闻管理页面
        } else {
            System.out.println(name);
            System.out.println(password);
            String fail = "<script type='text/javascript'>" +
                    "alert('用户名或密码错误！');" +
                    "location.href='login.html';</script>";
            out.println(fail);
        }
        db.Clocec();
        out.close();
    }
//#region
    protected void Log_Cookie(String name, String password, HttpServletResponse response) throws UnsupportedEncodingException {
        String cname = URLEncoder.encode(name, "UTF-8");//重新编码中文存入cookie
        Cookie cookienm = new Cookie("name", cname);
        cookienm.setMaxAge(60 * 60 * 30 * 24);
        response.addCookie(cookienm);//账号cookie

        String pname = URLEncoder.encode(password, "UTF-8");//重新编码中文存入cookie
        Cookie cookieps = new Cookie("password", pname);
        cookieps.setMaxAge(60 * 60 * 30 * 24);
        response.addCookie(cookieps);//密码cookie
    }

    protected void Log_Session(HttpServletResponse response) {

    }
//#endregion
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
