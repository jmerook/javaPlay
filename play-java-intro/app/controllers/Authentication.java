package controllers;


import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import models.User;
import play.data.Form;
import java.util.List;

import static play.libs.Json.*;

public class Authentication extends Controller
{
    /* @Transactional implies the use of the JPA and DB access */
    @Transactional
    public Result createUser()
    {
        /*get form info*/
        User user = Form.form(User.class).bindFromRequest().get();
        JPA.em().persist(user);

        List<User> userList = JPA.em().createQuery("select u from User u").getResultList();
        /*put the name of the Scala template that you want to use*/
        /* render will hand off the personList to the template since it was designated as a parameter in test.scala.html*/
        return ok(userIndex.render(userList));
    }
    public Result deleteUser()
    {
        return ok(index.render());
    }
    public Result getUser(String id)
    {
        /*using JPA get the person instance that you want to see */
        //User singleUser = JPA.em().getReference(User.class, id);

        //return ok(display.render(singleUser));
        return ok(index.render());
    }





}
