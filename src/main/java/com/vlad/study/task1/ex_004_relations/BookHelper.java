package com.vlad.study.task1.ex_004_relations;


import com.vlad.study.task1.ex_004_relations.entity.Author ;
import com.vlad.study.task1.ex_004_relations.entity.Book ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Author> root = cq.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)

        cq.select(root);

        //этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();

        session.close();

        return bookList;
    }
    public void removeBookById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, id);
        session.remove(book);
        session.getTransaction().commit();
        session.close();
    }
    public void removeBookByAuthor(String authorFirstName, String authorLastName){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

         session.createQuery("delete Book where author_id =" +
                         " (SELECT id from Author where name =:authorFirstName and lastName =:authorLastName)")
                 .setParameter("authorFirstName", authorFirstName)
                 .setParameter("authorLastName", authorLastName)
                 .executeUpdate();

//        List<Long> listId = query.getResultList();
//        long id = listId.get(0);
//
//        Book book = session.get(Book.class, id);
//        session.remove(book);

        session.getTransaction().commit();
        session.close();
    }
    public void addBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }

}
