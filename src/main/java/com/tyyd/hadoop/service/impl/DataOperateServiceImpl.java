package com.tyyd.hadoop.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyyd.hadoop.dao.HiveDao;
import com.tyyd.hadoop.dao.OracleDao;
import com.tyyd.hadoop.dto.User;
import com.tyyd.hadoop.service.DataOperateService;

@Service
public class DataOperateServiceImpl implements DataOperateService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String path = "/home/xieshiqi/user_data/";

	@Autowired
	private OracleDao oracleDao;
	
	@Autowired
	private HiveDao hiveDao;
	
	private final Integer pagesize = 1000000;

	@Override
	public void initUserData() {
		ExecutorService exe = Executors.newFixedThreadPool(20);
		exe.submit(() -> {
			// id在0 - 9999999999999的记录（有效区间1000002626595 -
			// 1000009999888），记录数：363060
			List<User> users = oracleDao.getUsers(1000002626594L, 1000009999888L);// 使用1000002626594非1000002626595，为了符合sql查询。下同
			String filename = path + "user1";
			generateLocalFile(users, filename);
			hiveDao.loadDataByLocalFile(filename);
			logger.info(String.format("当前导入数据：%d条", users.size()));
		});

		// id在10000000000000 - 19999999999999的记录（有效区间10000010000134 -
		// 10011021486129），记录数：44346817
		importData(10000010000134L, 10011021486129L, exe);
		// id在200000000000000 - ？（有效区间210000000000003 - 210000274979098），数据一直在增加，最大数一直在变，只能预估一个最大值
		importData(210000000000003L, 210000274979098L, exe);
	}
	
	private void importData(Long minUserId, Long maxUserId, ExecutorService exe){
		Long currentValue = minUserId -1;
		int i = 1;
		while (currentValue < maxUserId) {
			final Long startNum = currentValue;
			final Long endNum = (currentValue += pagesize);	
			final int seqNum = ++i;//生成文件序号
			exe.submit(() -> {
				List<User> users = oracleDao.getUsers(startNum, endNum);
				if (null != users && users.size() > 0) {
					String filename = path + "user" + seqNum;
					generateLocalFile(users, filename);
					hiveDao.loadDataByLocalFile(filename);
					logger.info(String.format("当前导入数据：%d条", users.size()));
				}
			});
		}
	}
	/**
	 * 生成数据文件
	 */
	private void generateLocalFile(List<User> users, String filename) {
		File file = new File(filename);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			StringBuffer content = new StringBuffer();
			for (User user : users) {
				content.append(user.getUserId()).append("\t").append(user.getUserPassword()).append("\t").append(user.getUserMobilephone()).append("\t")
					   .append(user.getUserName()).append("\t").append(user.getUserNickname()).append("\t").append(user.getUserEmail()).append("\t")
					   .append(user.getUserRegTime()).append("\t").append(user.getUserAreaCode()).append("\t").append(user.getUserUaInfo()).append("\t")
					   .append(user.getUserLastLoginway()).append("\t").append(user.getUserLastLogintime()).append("\n");
			}
			content.delete(content.lastIndexOf("\n"), content.length());
			bw.write(content.toString());
		} catch (Exception e) {
			logger.error("DataOperateServiceImpl.generateLocalFile | generate file is failed");
		}finally{
			if (null != bw) {			
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
