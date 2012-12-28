/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import database.Player;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author totzhe
 */
@WebServlet(name = "StatControllerServlet",
loadOnStartup = 1,
urlPatterns =
{
    "/world",
    "/country",
    "/exit",
    "/edit"
})
public class StatControllerServlet extends HttpServlet
{

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String userPath = request.getServletPath();
        String url = null;
        
        JdbcConnectionSource connectionSource = null;
        Dao<Player, Integer> playerDao;
        
        try
        {
            connectionSource = new JdbcConnectionSource("jdbc:mysql://localhost:3306/checkers", "root", "");
            playerDao = DaoManager.createDao(connectionSource, Player.class);
            int player_id = 3; // TODO: Получить из сессии
            Player player = playerDao.queryForId(player_id);
            
            if (userPath.equals("/world"))
            {
                List<Player> players = playerDao.queryBuilder().orderBy(Player.WON_FIELD_NAME, false).orderBy(Player.LOST_FIELD_NAME, true).query();
                List<String[]> rows = new ArrayList<String[]>();
                for (Player p : players)
                {
                    rows.add(p.toStrings());
                }
                request.setAttribute("players", rows);
                request.setAttribute("player_name", player.getName());
                request.setAttribute("player_country", "Лихтенштейн"); // TODO: узнать, получив из БД по id
                url = "/WEB-INF/view" + userPath + ".jsp";
            }
            else if (userPath.equals("/country"))
            {
                List<Player> players = playerDao.queryBuilder()./*where().eq(Player.ID_COUNTRY_FIELD_NAME, player.getCountry_id).*/orderBy(Player.WON_FIELD_NAME, false).orderBy(Player.LOST_FIELD_NAME, true).query();
                List<String[]> rows = new ArrayList<String[]>();
                for (Player p : players)
                {
                    rows.add(p.toStrings());
                }
                request.setAttribute("players", rows);
                request.setAttribute("player_name", player.getName());
                request.setAttribute("player_country", "Лихтенштейн"); // TODO: узнать, получив из БД по id
                url = "/WEB-INF/view" + userPath + ".jsp";
            }
            else if (userPath.equals("/edit"))
            {
                url = "/edit";
            }
            else if (userPath.equals("/exit"))
            {
                // TODO: Заверишть сессию
                url = "index.jsp";
            }
            
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch (SQLException ex)
        {
            response.getWriter().println("MySQL error: ");
            ex.printStackTrace(response.getWriter());
        }
        finally
        {
            if (connectionSource != null)
            {
                try
                {
                    connectionSource.close();
                }
                catch (SQLException e)
                {
                }
            }
        }
    }
}
