package com;

import lombok.var;
import org.jetbrains.annotations.Nullable;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<User> getUsers() {
        return session.createQuery("select u from User u", User.class).getResultList();
    }
    public void saveUser(User user){
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }
    public void deleteUser(User user){
        var transaction = session.beginTransaction();
        //Удаляем пользователя
        session.delete(user);
        transaction.commit();
    }
}
