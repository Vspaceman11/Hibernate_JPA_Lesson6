package com.vlad.study.task3;


import com.vlad.study.task3.entity.Author;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class Main {



    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

        ah.updateCriteria();

        List<Author> authorList = ah.getAuthorList();
        for (Author author : authorList) {
            System.out.println(author.getId() + " " + author.getName() + " " + author.getLastName());
        }


    }

}
