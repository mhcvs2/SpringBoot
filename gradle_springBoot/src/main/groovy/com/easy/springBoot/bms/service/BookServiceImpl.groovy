package com.easy.springBoot.bms.service

import com.easy.springBoot.bms.domain.Book
import com.easy.springBoot.bms.mapper.BookMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper

    @Override
    List<Book> findByState(String state) {
        bookMapper.findByState(state)
    }

    @Override
    List<Book> findAll() {
        bookMapper.findAll()
    }

    @Override
    Book insert(Book book) {
        bookMapper.insert(book)
        book
    }

    @Override
    void delete(String name) {
        bookMapper.delete(name)
    }
}
