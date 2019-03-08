package com.tyyd.hadoop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tyyd.hadoop.dao.OracleDao;
import com.tyyd.hadoop.dto.User;

@Repository
public class OracleDaoImpl implements OracleDao {
	
	@Resource(name = "oracleJt")
	private JdbcTemplate oracleJt;

	@Override
	public List<User> getUsers(Long startNum, Long endNum) {
		String sql = "select user_id,user_password,user_mobilephone,user_name,user_nickname,user_email,user_reg_time,user_area_code,user_ua_info,user_last_loginway,user_last_logintime from ytxt.t_user_info where user_id > ? and user_id <=?";
		List<User> users = oracleJt.query(sql, new Long[]{startNum, endNum}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getLong("USER_ID"));
				user.setUserPassword(rs.getString("USER_PASSWORD"));
				user.setUserMobilephone(rs.getString("USER_MOBILEPHONE"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUserNickname(rs.getString("USER_NICKNAME"));
				user.setUserEmail(rs.getString("USER_EMAIL"));
				user.setUserRegTime(rs.getString("USER_REG_TIME"));
				user.setUserAreaCode(rs.getString("USER_AREA_CODE"));
				user.setUserUaInfo(rs.getString("USER_UA_INFO"));
				user.setUserLastLogintime(rs.getString("USER_LAST_LOGINTIME"));
				user.setUserLastLoginway(rs.getString("USER_LAST_LOGINWAY"));
				return user;
			}
		});
		return users;
	}

}
