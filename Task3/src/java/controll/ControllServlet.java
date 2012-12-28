/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import database.Country;
import database.Player;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
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
urlPatterns =
{
    "/autorization",
    "/registration",
    "/cancel",
    "/sendReg",
    "/saveChanges",
    "/cancelChanges"
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
        JdbcConnectionSource connectionSource = null;
        try
        {
            String userPath = request.getServletPath();
            String url = null;
            Dao<Player, Integer> playerDao;
            Dao<Country, Integer> countryDao;
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            connectionSource = new JdbcConnectionSource("jdbc:mysql://localhost:3306/checkers?useUnicode=true&characterEncoding=utf8", "root", "");
            playerDao = DaoManager.createDao(connectionSource, Player.class);
            countryDao = DaoManager.createDao(connectionSource, Country.class);

            if (userPath.equals("/autorization"))
            {
                //String att = request.getParameterValues("login")[0];
                    /*QueryBuilder<Player, Integer> queryBuilder = playerDao.queryBuilder();
                 SelectArg selectArg = new SelectArg();
                 queryBuilder.where().like(Player.NAME_FIELD_NAME, selectArg);
                 PreparedQuery<Player> preparedQuery = queryBuilder.prepare();
                 selectArg.setValue(request.getParameterValues("login")[0]);
                 List<Player> list = playerDao.query(preparedQuery);*/
                String name = request.getParameterValues("login")[0];
                String pass = request.getParameterValues("pass")[0];
                List<Player> player = playerDao.queryBuilder().where()
                        .eq(Player.NAME_FIELD_NAME, request.getParameterValues("login")[0])
                        .and()
                        .eq(Player.PASSWORD_FIELD_NAME, request.getParameterValues("pass")[0]).query();

                if (player.size() == 1)
                {
                    request.getSession().setAttribute("login", request.getParameterValues("login")[0]);
                    request.getSession().setAttribute("user_id", player.get(0).getId());
                    userPath = "/country";
                    url = "/country";
                }
                else
                {
                    request.setAttribute("loc", "Wrong login or password");
                    url = "index.jsp";
                }
            }
            else if (userPath.equals("/registration"))
            {
                url = "/WEB-INF/view" + userPath + ".jsp";
            }
            else if (userPath.equals("/cancel"))
            {
                url = "index.jsp";
            }
            else if (userPath.equals("/sendReg"))
            {
                List<Player> player = playerDao.queryBuilder().where()
                        .eq(Player.NAME_FIELD_NAME, request.getParameterValues("Login")[0])
                        .and()
                        .eq(Player.PASSWORD_FIELD_NAME, request.getParameterValues("Password")[0]).query();

                int c_id = countryDao.queryBuilder().where().eq(Country.COUNTRY_NAME, request.getParameterValues("Country")[0]).query().get(0).getId();

                if (player.size() == 0)
                {
                    playerDao.create(new Player(request.getParameterValues("Login")[0], request.getParameterValues("Password")[0], request.getParameterValues("Name")[0], request.getParameterValues("Email")[0], c_id));
                }
                else
                {
                    request.setAttribute("er", "A user with this login is already registered");
                    url = "/registration";
                }
            }
            else if (userPath.equals("/saveChanges"))
            {
                Player pl = playerDao.queryForId((Integer) request.getSession().getAttribute("user_id"));
                pl.setActual_name(request.getParameterValues("Name")[0]);
                pl.setEmail(request.getParameterValues("Email")[0]);
                pl.setId_country(countryDao.queryBuilder().where().eq(Country.COUNTRY_NAME, request.getParameterValues("Country")[0]).query().get(0).getId());
                if (pl.getPassword().equals(request.getParameterValues("Password_old")[0]))
                {
                    pl.setPassword(request.getParameterValues("Password_new")[0]);
                    playerDao.update(pl);
                    url = "/country";
                }
                else
                {
                    request.setAttribute("wrong_pass", "Old password is wrong");
                    request.setAttribute("country", request.getParameterValues("Country")[0]);
                    request.setAttribute("name", request.getParameterValues("Name")[0]);
                    request.setAttribute("email", request.getParameterValues("Email")[0]);
                    url = "/WEB-INF/view/changeInfo.jsp";
                }
            }
            else if (userPath.equals("/cancelChanges"))
            {
                //ссылка на страницу, с которой вызывали изменение профиля
                url = "/country";
            }
            else
            {
                url = "/WEB-INF/view" + userPath + ".jsp";
            }
            request.getRequestDispatcher(url).forward(request, response);

        }
        catch (SQLException ex)
        {        
            
            request.setAttribute("error_text", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
            //response.getWriter().println("MySQL error: ");
            //ex.printStackTrace(response.getWriter());
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

    @Override
    public String getServletInfo()
    {
        return "Controll servlet";
    }// </editor-fold>
}
