package com.example.demo.mapper;

import com.example.demo.entity.Name;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM names")
    List<Name> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(int id);

    @Insert("INSERT INTO names(name) VALUES(#{name})")
    void create(String name);

    @Update("UPDATE names SET name = #{name} WHERE id = #{id}")
    void update(int id, String name);

}
