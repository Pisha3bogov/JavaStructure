package ru.sapteh;

import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.UsersDaoImpl;
import ru.sapteh.model.Users;
import ru.sapteh.util.Connector;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = Connector.getInstance();

        Dao<Users,Long> usersLongDao = new UsersDaoImpl(connection);

        System.out.println(usersLongDao.findById(1L));

        usersLongDao.findAll().forEach(System.out::println);

        Users users = new Users("Vlad","Andrianov");
        usersLongDao.save(users);

        Users users1 = usersLongDao.findById(2L);
        users1.setFirstName("Aleksandr");
        users1.setLastName("Smolik");
        usersLongDao.update(users1);

        usersLongDao.deleteById(4L);
    }
}
