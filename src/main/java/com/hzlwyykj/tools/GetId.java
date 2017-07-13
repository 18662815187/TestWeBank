package com.hzlwyykj.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetId {
	private static long workid = 0;
	private static long fileNewName = 0;

	public synchronized static String getWorkid() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		String now = sdf.format(new Date());
		workid++;
		return now + workid;
	}

	public synchronized static String getNewFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		String now = sdf.format(new Date());
		fileNewName++;
		return now + fileNewName;
	}

}
