/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author Alina
 */
public class DB
{
    private static final String databaseUrl = "jdbc:mysql://vragov.com:3306/checkers";
    
    public JdbcConnectionSource CreateConnectionSource() throws SQLException
    {
        try
        {
            JdbcConnectionSource connectionSource = new JdbcPooledConnectionSource(databaseUrl);
            return connectionSource;
        }
        catch(SQLException exception)
        {
            System.out.println("DBConnectionError");
        }
        return null;
    }
}
