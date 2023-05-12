package com.vlad.study.task1.ex_004_relations;


import com.vlad.study.task1.ex_004_relations.entity.Author ;
import com.vlad.study.task1.ex_004_relations.entity.Book ;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {


    public static void main(String[] args) {
        BookHelper bh = new BookHelper();
        AuthorHelper ah = new AuthorHelper();
        // Add authors and their books
//        Author author1 = new Author("George", "Orwell");
//        Author author2 = new Author("Richard", "Morgan");
//        Author author3 = new Author("Christopher", "Nolan");
//        ah.addAuthor(author1);
//        ah.addAuthor(author2);
//        ah.addAuthor(author3);
//
//        Book book1 = new Book("1984", author1);
//        Book book2 = new Book("Animal Farm: A Fairy Story", author1);
//        Book book3 = new Book("Altered Carbon", author2);
//        Book book4 = new Book("Interstellar", author3);
//        bh.addBook(book1);
//        bh.addBook(book2);
//        bh.addBook(book3);
//        bh.addBook(book4);
//        System.out.println("Book list \n" +
//                "----------------------------------------------------");
//        System.out.println(bh.getBookList());

        bh.removeBookByAuthor("George", "Orwell");
        System.out.println("Book list after removing by Author \n" +
                "----------------------------------------------------");
        System.out.println(bh.getBookList());

//        bh.removeBookById(2);
//        System.out.println("Book list after removing by book id \n" +
//                "----------------------------------------------------");
    }
}
