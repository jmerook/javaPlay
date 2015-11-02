package models;

import play.db.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//do this since User is a postgres restricted table
@Table(name="user_table")
public class User
{ /*Java is utilizing the JPA persistence Entity Manager */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    public int id;

    public String username;
    public String password;
}
