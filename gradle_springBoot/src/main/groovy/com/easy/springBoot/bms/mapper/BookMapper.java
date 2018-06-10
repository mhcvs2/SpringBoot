package com.easy.springBoot.bms.mapper;


import com.easy.springBoot.bms.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BookMapper{
    @Select("select * from book where state = #{state}")
    List<Book> findByState(@Param("state") String state);

    @Select("select * from book")
    List<Book> findAll();

    @Insert({
            "insert into book",
            "set name = #{b.name},",
            "author = #{b.author},",
            "isbn = #{b.isbn},",
            "in_date = #{b.inDate},",
            "out_date = #{b.outDate},",
            "press = #{b.press},",
            "state = #{b.state}"
    })
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(@Param("b") Book book) throws RuntimeException;

    @Delete("delete from book where name = #{name}")
    void delete(@Param("name") String name);
}
