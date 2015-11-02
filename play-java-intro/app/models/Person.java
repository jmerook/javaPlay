package models;
import javax.persistence.*;

@Entity
public class Person
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int id;


    public String name;
    public String newfield;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getNewField() { return newfield; }

    public void setName(String newName)
    {
        this.name = newName;
    }
    public void setNewfield(String newNewfield)
    {
        this.newfield = newNewfield;
    }

}
