package com.roncoo.eshop.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.eshop.inventory.mapper.UserMapper;
import com.roncoo.eshop.inventory.model.User;
import com.roncoo.eshop.inventory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper UserMapper;
	@Autowired
	private StringRedisTemplate redis;

	@Override
	public User findUserInfo() {
		return UserMapper.findUserInfo();
	}

	@Override
	public User getCacheUser() {
		redis.opsForValue().set("cached_user", "{\"name\": \"zhangsan\", \"age\": 25}");
		String json = redis.opsForValue().get("cached_user");
		JSONObject jsonObject = JSONObject.parseObject(json);
		User user = new User();
		user.setName(jsonObject.getString("name"));
		user.setAge(jsonObject.getInteger("age"));
		return user;
	}

}
