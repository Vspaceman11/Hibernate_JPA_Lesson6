package com.vlad.study.task2.ex_002_select_where;


import com.vlad.study.task2.ex_002_select_where.entity.Author;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {



    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        List<Author> authorList = ah.getAuthorList();

        for (Author author : authorList) {
            System.out.println(author.getId() + " " + author.getName() + " " + author.getLastName());
        }


    }

}
