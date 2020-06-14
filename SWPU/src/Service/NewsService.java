package Service;
import DataBase.DataBase;
import News.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsService {
    public static PreparedStatement pstmt(){

        return null;
    }
    public boolean AddNews(News news){

        String sql="insert into News (newsTitle,newsCon,newsWriter,newsDate) values ( '"+news.getNewsTitle()+"','"+news.getNewsCon()+"','"+news.getNewsWriter()+"','"+news.getNewsDate()+"')";
        boolean result=DataBase.executeUpdate(sql);
        return result;
    }
    public boolean DeleteNews(int newsID){
        String sql="delete from News where newsID="+newsID;
        boolean result= DataBase.executeUpdate(sql);
        return result;
    }
    public boolean updateNews(News news){
        String date=news.getNewsDate().toString();
        String sql="update News set newsTitle=  '"+news.getNewsTitle()+"', newsCon = '"+news.getNewsCon()+"', newsWriter = '"+news.getNewsWriter()+"', newsDate='"+new java.sql.Date(news.getNewsDate().getTime())+"' where newsID="+news.getNewsID();
        boolean result=DataBase.executeUpdate(sql);
        return result;
    }

    public List<News> QueryNews() throws SQLException {
        String sql="select * from News";
        ResultSet rs=DataBase.executeQuery(sql);
        List<News> lstNews=new ArrayList<>();
        while (rs.next()){
            News news=new News();
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
            lstNews.add(news);
        }
        return lstNews;
    }
    public News GetNews(int newsID) throws SQLException {
        String sql="select * from News where newsID="+newsID;
        ResultSet rs=DataBase.executeQuery(sql);
        News news=new News();
        if(rs.next()){
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
        }
        return news;
    }
}
