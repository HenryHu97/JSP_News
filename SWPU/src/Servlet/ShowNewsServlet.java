package Servlet;

import News.News;
import Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/ShowNewsServlet")
public class ShowNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsService newsService=new NewsService();
        try {
            List<News> lstNews=newsService.QueryNews();
            for(News n:lstNews){
                System.out.print(n.getNewsCon());
            }
            request.setAttribute("lstNews",lstNews);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
