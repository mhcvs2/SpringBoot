package com.mhc.bms.controller

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import com.mhc.bms.Service.BookService
import com.mhc.bms.domain.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    @ResponseBody
    List<Book> findByState(@RequestParam(value = "state", required = false) String state) {
        if (StringUtils.isEmpty(state)) {
            List<Book> all = bookService.findAll()
            println(JSON.toJSONString(all,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue))
//            println(new JsonOutput().toJson(all))
            bookService.findAll()
        } else {
            bookService.findByState(state)
        }
    }

    @GetMapping("/bookPage")
    String findAll(Model model) {
        List<Book> books = bookService.findAll()
        model.addAttribute("books", books)
        "book/list"
    }

}
