package com.easy.springBoot.bms.controller.api

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import com.easy.springBoot.bms.domain.Book
import com.easy.springBoot.bms.service.BookService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = "/book")
class BookApiController {

    @Autowired
    BookService bookService

    @ApiOperation(value="获取书籍列表", notes="")
//    @ApiImplicitParam(name = "state", value = "书籍状态", required = false, dataType = "String", paramType = "query")
    @GetMapping("/list")
    @ResponseBody
    List<Book> findByState(@RequestParam(value = "state", required = false) String state) {
        if (StringUtils.isEmpty(state)) {
            List<Book> all = bookService.findAll()
            println(JSON.toJSONString(all, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue))
//            println(new JsonOutput().toJson(all))
            bookService.findAll()
        } else {
            bookService.findByState(state)
        }
    }

    @ApiOperation(value="添加书籍", notes="")
//    @ApiImplicitParam(name = "book", value = "书籍实体book", required = true, dataType = "Book")
    @PostMapping("/insert")
    @ResponseBody
    String insert(@RequestBody Book b) {
        Calendar lastDate = Calendar.getInstance()
        Date now = lastDate.getTime()
        b.setInDate(now)
        b.setOutDate(now)
        b.setIsbn("222")
        try {
            bookService.insert(b)
            return "success"
        } catch (RuntimeException e) {
            if(e.message == ""){
                return "fail"
            }
            return e.message
        }
    }

    @ApiOperation(value="删除书籍", notes="根据书籍名称删除书籍")
//    @ApiImplicitParam(name = "book", value = "书籍实体book", required = true, dataType = "Book")
    @PostMapping("/delete")
    @ResponseBody
    String delete(@RequestBody Book book) {
        bookService.delete(book.name)
        "success"
    }
}
