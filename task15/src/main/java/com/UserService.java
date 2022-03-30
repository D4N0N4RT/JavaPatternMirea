package com;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("userService")
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   /* @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }*/
    public User read(long id){
        session = sessionFactory.openSession();
        User usr = session.createQuery("select User where id = :id from users ", User.class).
                setParameter("id", id).getSingleResult();
        Hibernate.initialize(usr.getDogs());
        session.close();
        return usr;
    }
    public List<User> getUsers() {
        session = sessionFactory.openSession();
        List<User> usrs = session.createQuery("select u from User u", User.class).getResultList();
        for(User usr : usrs){
            Hibernate.initialize(usr.getDogs());
        }
        session.close();
        return usrs;
    }

    public void saveUser(User user){
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(User user){
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Удаляем пользователя
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<User> userFilter(String field){
        session = sessionFactory.openSession();
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteria.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot).orderBy(criteria.asc(userRoot.get(field)));
        Query query = session.createQuery(userCriteriaQuery);
        session.close();
        return query.getResultList();
    }
}
