package News;

import java.util.Date;
public class News {
    int newsID;
    String newstitle;
    String newsWriter;
    String newsTime;
    String newsCon;
    Date newsDate;
    //ID
    public int getNewsID(){
        return newsID;
    }
    public void setNewsID(int newsID){
        this.newsID = newsID;
    }
    //news
    public String getNewsTitle(){
        return newstitle;
    }
    public void setNewsTitle(String newstitle){
        this.newstitle = newstitle;
    }
    //作者
    public String getNewsWriter(){ return newsWriter; }
    public void setNewsWriter(String newsWriter){
        this.newsWriter = newsWriter;
    }
    //类型
    public String getNewsCon(){
        return newsCon;
    }
    public void setNewsCon(String newsCon){
        this.newsCon = newsCon;
    }
    //时间
    public Date getNewsDate(){
        return newsDate;
    }
    public void setNewsDate(Date newsDate){
        this.newsDate = newsDate;
    }
}
