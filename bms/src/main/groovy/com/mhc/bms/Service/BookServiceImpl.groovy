package com.mhc.bms.Service

import com.mhc.bms.domain.Book
import com.mhc.bms.mapper.BookMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper

    List<Book> findByState(String state) {
        bookMapper.findByState(state)
    }


    List<Book> findAll() {
        bookMapper.findAll()
    }

    Book insert(Book book) {
        bookMapper.insert(book)
    }
}
