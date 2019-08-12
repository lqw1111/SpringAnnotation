package com.spring.service;

import com.spring.dao.BookRepository;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookSerive {

//    @Autowired(required = false)
//    @Resource(name = "bookDao2")
    @Inject
    private BookRepository bookRepository;

    public void print(){
        System.out.println(bookRepository);
    }

    @Override
    public String toString() {
        return "BookSerive{" +
                "bookRepository=" + bookRepository +
                '}';
    }
}
