package com.tyyd.hadoop.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tyyd.hadoop.dao.HiveDao;

@Repository
public class HiveDaoImpl implements HiveDao {
	
	@Resource(name = "hiveJt")
	private JdbcTemplate hiveJt;

	@Override
	public void loadDataByLocalFile(String filename) {
		String sql = "load data local inpath '" + filename + "' into table t_user_info";
		hiveJt.execute(sql);
	}

}
