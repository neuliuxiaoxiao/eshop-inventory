package com.roncoo.eshop.inventory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.roncoo.eshop.inventory.model.User;

@Mapper
public interface UserMapper {
	
	@Select("select name,age from user")
	 public User findUserInfo();

}
