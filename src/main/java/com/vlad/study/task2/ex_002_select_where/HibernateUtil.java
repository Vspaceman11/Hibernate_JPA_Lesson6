package com.vlad.study.task2.ex_002_select_where;

import com.vlad.study.task2.ex_002_select_where.entity.Author;
import com.vlad.study.task2.ex_002_select_where.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Asus on 01.11.2017.
 */
public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
             factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                     .addAnnotatedClass(Author.class)
                     .addAnnotatedClass(Book.class)
                    .buildSessionFactory();
        } catch (HibernateException e) {
              e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

}
