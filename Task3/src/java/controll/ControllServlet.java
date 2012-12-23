/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alina
 */
@WebServlet(name = "ControllServlet", 
        loadOnStartup = 1,
        urlPatterns ={"/autorization", 
                      "/registration",
                      "/cancel"
                                     })
public class ControllServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String userPath = request.getServletPath();
        String url = null;
        
        if (userPath.equals("/autoriation"))
        {
            //TODO: работа с бд
        } 
        else if(userPath.equals("/registration"))
        {
            url = "/WEB-INF/view" + userPath + ".jsp";
        }
        else if(userPath.equals("/cancel"))
        {
            url = "index.jsp";
        }
        else
        {
            url = "/WEB-INF/view" + userPath + ".jsp";
        }
        
        //String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Controll servlet";
    }// </editor-fold>
}
