package com.mhc.todo.api2.mapper

import com.mhc.todo.api2.domain.TodoItem
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface TodoItemMapper {

    @Select("select * from todo_item")
    List<TodoItem> findAll()

    @Select("select * from todo_item where id = #{id}")
    TodoItem findById(Long id)

    @Insert("insert into todo_item (description, completed) values (#{todo.description}, #{todo.completed})")
    void insert(@Param("todo") TodoItem todoItem) throws RuntimeException

    @Update("update todo_item set description=#{todo.description},completed=#{todo.completed} where id=#{todo.id}")
    void update(@Param("todo") TodoItem todoItem) throws RuntimeException

    @Delete("delete from todo_item where id = #{id}")
    void delete(@Param("id") Long id)

}
