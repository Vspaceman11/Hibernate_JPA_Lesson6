package com.vlad.study.task2.ex_002_select_where;


import com.vlad.study.task2.ex_002_select_where.entity.Author;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();


        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery<Author> cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)


        cq.select(root).where(cb.like(root.get("lastName"), "%lk%"));


         //этап выполнения запроса
        Query query = session.createQuery(cq);


        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.persist(author); // сгенерит ID и вставит в объект

        session.getTransaction().commit();

        session.close();


        return author;

    }
}
