package com.tyyd.hadoop.dao;

import java.util.List;

import com.tyyd.hadoop.dto.User;

public interface OracleDao {

	List<User> getUsers(Long startNum, Long endNum);
}
