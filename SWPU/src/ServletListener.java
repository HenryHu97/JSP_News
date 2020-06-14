import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class ServletListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private Integer onlineNumber;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        this.onlineNumber++;
        setContext(event);
        System.out.println(String.format("\n\n\nCreated    %d\n\n\n", this.onlineNumber));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        this.onlineNumber--;
        setContext(event);
        System.out.println(String.format("\n\n\nDestroyed     %d\n\n\n", this.onlineNumber));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.onlineNumber = 0;
        System.out.println(String.format("\n\n\nInitialized       %d\n\n\n", this.onlineNumber));
    }

    public void setContext(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("onLine", this.onlineNumber);
    }
}