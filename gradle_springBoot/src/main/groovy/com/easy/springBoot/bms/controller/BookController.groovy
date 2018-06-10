package com.easy.springBoot.bms.controller

import com.easy.springBoot.bms.domain.Book
import com.easy.springBoot.bms.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
//import groovy.json.JsonOutput

@Controller
class BookController {

    @Autowired
    BookService bookService

    @GetMapping("/bookPage")
    String findAll(Model model) {
        List<Book> books = bookService.findAll()
        model.addAttribute("books", books)
        "book/list"
    }
}
