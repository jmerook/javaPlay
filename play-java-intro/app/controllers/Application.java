package controllers;

import play.*;
import play.data.DynamicForm;
import play.mvc.*;
import play.db.jpa.*;
import scala.Int;
import views.html.*;
import views.*;
import models.Person;
import play.data.Form;

import javax.persistence.EntityManager;
import java.util.List;

import static play.libs.Json.*;

public class Application extends Controller
{
/* @Transactional implies the use of the JPA and DB access */
    @Transactional
    public Result index()
    {
        return ok(index.render());
    }

    @Transactional
    public Result test()
    {
        List<Person> personList = JPA.em().createQuery("select p from Person p").getResultList();
        /*put the name of the Scala template that you want to use*/
        /* render will hand off the personList to the template since it was designated as a parameter in test.scala.html*/
        return ok(test.render(personList));
    }
    @Transactional
    public Result addPerson()
    {
        /*define a form by wrapping it with the existing Person class*/
        /*bind request = this form handles form submission and its data*/
        /*get = get the concrete value if the submission of the form was a success*/
        //Person person = Form.form(Person.class).bindFromRequest().get();


        DynamicForm df = play.data.Form.form().bindFromRequest();

        Person person = new Person();

        person.setName(df.get("name"));
        person.setNewfield(df.get("newfield"));

        JPA.em().persist(person);
        return redirect(routes.Application.index());
    }
    @Transactional
    public Result getSinglePerson(int id)
    {
        /* notice this methods input is a JAVA int, and NOT a Scala Int. This is intentional*/
        /*using JPA get the person instance that you want to see */
        Person singlePerson = JPA.em().getReference(Person.class, id);


        return ok(display.render(singlePerson));
    }
    @Transactional
    public Result deletePerson(int id)
    {
        /*using JPA get the person instance that you want to delete */
        Person singlePerson = JPA.em().getReference(Person.class, id);

        /*using JPA remove the instance from DB */
        JPA.em().remove(singlePerson);

        List<Person> personList = JPA.em().createQuery("select p from Person p").getResultList();
        /* render will hand off the personList to the template since it was designated as a parameter in test.scala.html*/
        return ok(test.render(personList));
    }
    @Transactional
    public Result editPerson(int id)
    {
        /*using JPA get the person instance that you want to edit */
        Person singlePerson = JPA.em().getReference(Person.class, id);

        /*send person to the edit view so it can prepopulate form*/
        return ok(edit.render(singlePerson));
    }
    @Transactional
    public Result submitEdit()
    {
        /*get edits from the form */
        Person singlePerson = Form.form(Person.class).bindFromRequest().get();

        /*get the value form the form*/
        String name = singlePerson.getName();

        return ok(display.render(singlePerson));
        //JPA.em().persist(person);

        //List<Person> personList = JPA.em().createQuery("select p from Person p").getResultList();
        /* render will hand off the personList to the template since it was designated as a parameter in test.scala.html*/
        //return ok(test.render(personList));
    }

    @Transactional(readOnly = true)
    public Result getPersons()
    {
        List<Person> persons = (List<Person>) JPA.em().createQuery("select p from Person p").getResultList();
        return ok(toJson(persons));
    }

}
