package nl.brianvermeer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "urlservlet",
        urlPatterns = "/url"
)
public class UrlServlet extends HttpServlet {

    private static final SiteInfo siteInfo = new SiteInfo();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getParameter("url");
        req.setAttribute("url", url);
        req.setAttribute("source", siteInfo.getSiteInfo(url));
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }

}
