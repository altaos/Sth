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
@Entity(name = "COUNTRIES")
public class Country
{
    public Country() { }
    
    public static final String COUNTRY_NAME = "name";
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(nullable = false, columnDefinition=COUNTRY_NAME)
    private String name;

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
}
