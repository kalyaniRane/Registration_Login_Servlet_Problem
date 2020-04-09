import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user",value = "kalyani"),
                @WebInitParam(name = "pass",value = "123")
        }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");

        String userID = getServletConfig().getInitParameter("user");
        String  password = getServletConfig().getInitParameter("pass");

        if(userID.equals(user) && password.equals(pass))
        {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req,resp);
        }else{
            RequestDispatcher reqD=getServletContext().getRequestDispatcher("/login.html");
            PrintWriter writer = resp.getWriter();
            writer.println("<font color=red> Either User Name Or Password Is Wrong</font>");
            reqD.include(req,resp);
        }
    }
}
