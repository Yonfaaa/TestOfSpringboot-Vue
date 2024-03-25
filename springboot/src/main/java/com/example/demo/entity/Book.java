package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="book")
public class Book {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Integer price;
    private Integer userId;
}
