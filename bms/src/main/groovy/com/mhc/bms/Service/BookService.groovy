package com.mhc.bms.Service

import com.mhc.bms.domain.Book

interface BookService {
    List<Book> findByState(String state)

    List<Book> findAll()

    Book insert(Book book)
}
