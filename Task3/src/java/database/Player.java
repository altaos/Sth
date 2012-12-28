/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.*;

/**
 *
 * @author Alina
 */
@Entity(name = "PLAYER")
public class Player
{
    public static final String NAME_FIELD_NAME = "name";
    public static final String PASSWORD_FIELD_NAME = "password";
    public static final String ACTUAL_NAME_FIELD_NAME = "actual_name";
    public static final String EMAIL_FIELD_NAME = "email";
    public static final String ID_FIELD_NAME = "id";
    public static final String WON_FIELD_NAME = "won_games_count";
    public static final String LOST_FIELD_NAME = "lost_games_count";
    public static final String ID_COUNTRY = "id_country";
    
    public Player(){ }
    
    public Player(String name, String password, String actual_name,String email, int country_id)
    {
        this.name = name;
        this.password = password;
        this.actual_name = actual_name;
        this.email = email;
        this.won_games_count = 0;
        this.lost_games_count = 0;
        this.id_country = country_id;
    }
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false, columnDefinition=NAME_FIELD_NAME)
    private String name;
    
    @Column(nullable = false, columnDefinition=PASSWORD_FIELD_NAME)
    private String password;
    
    @Column(nullable = false, columnDefinition=ACTUAL_NAME_FIELD_NAME)
    private String actual_name;
    
    @Column(nullable = false, columnDefinition=EMAIL_FIELD_NAME)
    private String email;
    
    @Column(nullable = false, columnDefinition=WON_FIELD_NAME)
    private int won_games_count;
    
    @Column(nullable = false, columnDefinition=LOST_FIELD_NAME)
    private int lost_games_count;
    
    @Column(nullable = false, columnDefinition=ID_COUNTRY)
    private int id_country;

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @return the actual_name
     */
    public String getActual_name()
    {
        return actual_name;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @return the won_games_count
     */
    public int getWon_games_count()
    {
        return won_games_count;
    }

    /**
     * @return the lost_games_count
     */
    public int getLost_games_count()
    {
        return lost_games_count;
    }

    /**
     * @return the country_id
     */
    public int getCountry_id()
    {
        return id_country;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @param actual_name the actual_name to set
     */
    public void setActual_name(String actual_name)
    {
        this.actual_name = actual_name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @param id_country the id_country to set
     */
    public void setId_country(int id_country)
    {
        this.id_country = id_country;
    }    
    
    public String[] toStrings()
    {
        String[] result = new String[5];
        result[0] = "Undefined";
        result[1] = name;
        result[2] = ((Integer)(won_games_count-lost_games_count)).toString();
        result[3] = ((Integer)won_games_count).toString();
        result[4] = ((Integer)lost_games_count).toString();
        return result;        
    }
    
}
