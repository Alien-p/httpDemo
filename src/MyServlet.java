import com.mysoft.DAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Ildar on 14.12.2016.
 */
@javax.servlet.annotation.WebServlet(name = "MyServlet", urlPatterns = "/posts")
public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.setAttribute("posts", DAO.getPosts());
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/posts.jsp").forward(request,response);
        //response.sendRedirect("ya,ru");
    }
}
