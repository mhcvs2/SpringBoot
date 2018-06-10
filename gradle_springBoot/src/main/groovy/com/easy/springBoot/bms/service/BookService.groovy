package com.easy.springBoot.bms.service

import com.easy.springBoot.bms.domain.Book

interface BookService {
    List<Book> findByState(String state)

    List<Book> findAll()

    Book insert(Book book)

    void delete(String name)
}
