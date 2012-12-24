/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import database.Player;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        try
        {
            //try
            //{
            String userPath = request.getServletPath();
            String url = null;
            JdbcConnectionSource connectionSource;
            Dao<Player,Integer> playerDao;
            
            connectionSource = new JdbcPooledConnectionSource("jdbc:mysql://localhost:3306/checkers", "root", "");
            playerDao = DaoManager.createDao(connectionSource, Player.class);
            
            if (userPath.equals("/autorization"))
            {
                //QueryBuilder<Player, Integer> queryBuilder = playerDao.queryBuilder();
                List<Player> player = playerDao.queryBuilder().where()
                        .eq(Player.NAME_FIELD_NAME, request.getAttribute("Login"))
                        .and()
                        .eq(Player.PASSWORD_FIELD_NAME, request.getAttribute("Password")).query();
                
                if(player.size() == 1)
                {
                    userPath = "/registration";
                    url = "/WEB-INF/view" + userPath + ".jsp";
                }
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
            //}
            //catch()
        } catch (SQLException ex)
        {
            Logger.getLogger(ControllServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //}
        //catch()
    }

    @Override
    public String getServletInfo()
    {
        return "Controll servlet";
    }// </editor-fold>
}
