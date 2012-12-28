/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import java.sql.SQLException;

/**
 * тестовая версия, доделать сессии, убрать новые подключения
 * @author Alina
 */
public class DB
{
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/checkers";
    private JdbcConnectionSource connectionSource;
    
    //переделать!!! 
    public DB() { }
    
    public JdbcConnectionSource getConnectionSource()
    {
        return connectionSource;
    }
    
    public JdbcConnectionSource CreateConnectionSource() throws SQLException
    {
        try
        {
            connectionSource = new JdbcPooledConnectionSource(databaseUrl, "root", "");
            //Dao<Player,Integer> playerDao = DaoManager.createDao(connectionSource, Player.class);
            return connectionSource;
        }
        catch(SQLException exception)
        {
            System.out.println("DBConnectionError");
        }
        return null;
    }
    
    
}
