package com.niit.ocs.util;

import java.sql.Connection;

public interface DBUtil {
	public static Connection getDBConnection(String driverType) {
		Connection cnn=null;
		return (cnn);
	}
}