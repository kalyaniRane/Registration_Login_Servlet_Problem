import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/RegistrationSuccess"}
)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String password=request.getParameter("pwd");
        String confirmPassword=request.getParameter("cpwd");

        if(name!=null && name.matches("^[A-Z][a-z]{3,}$")){
            if (lastName!=null && lastName.matches("^[A-Z][a-z]{3,}$")){
                if(email!=null && email.matches("^([a-zA-Z]{3,}([.|_|+|-]?[a-zA-Z0-9]+)?[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}([.]?[a-zA-Z]{2,3})?)$")){
                    if (number!=null && number.matches("^[1-9]{2}[[' ']][1-9]{1}[0-9]{9}$")){
                        if (password!=null && password.matches("^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9\\W\\_]{8,})$")){
                            if(confirmPassword!=null && confirmPassword.equals(password)) {
                                request.setAttribute("name", name);
                                request.setAttribute("lastName", lastName);
                                request.setAttribute("email", email);
                                request.setAttribute("number", number);
                                request.setAttribute("pwd", password);
                                request.getRequestDispatcher("RegistrationSuccess.jsp").forward(request, response);
                            }else
                            {
                                PrintWriter writer = response.getWriter();
                                writer.println("<font color=red>Password Not Match.</font>");
                            }
                        }else
                        {
                            PrintWriter writer = response.getWriter();
                            writer.println("<font color=red>Invalid Password.</font>");
                        }
                    }else
                    {
                        PrintWriter writer = response.getWriter();
                        writer.println("<font color=red>Invalid Contact Number.</font>");
                    }
                }else
                {
                    PrintWriter writer = response.getWriter();
                    writer.println("<font color=red>Invalid Email ID.</font>");
                }
            }else
            {
                PrintWriter writer = response.getWriter();
                writer.println("<font color=red>First Letter Must Be Capital.</font>");
            }
        }else
        {
            PrintWriter writer = response.getWriter();
            writer.println("<font color=red>First Letter Must Be Capital.</font>");
        }

    }
}
