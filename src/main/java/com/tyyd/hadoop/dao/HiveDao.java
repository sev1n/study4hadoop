package com.tyyd.hadoop.dao;

public interface HiveDao {

	/**
	 * 通过本地文件加载数据
	 * @param filename
	 */
	void loadDataByLocalFile(String filename);
}
