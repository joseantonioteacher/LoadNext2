package com.sara.happypets.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class DBNullUtils {

	public static final void setNull(PreparedStatement ps, int pos, String value) 
			throws SQLException {
		if (value==null) {
			ps.setNull(pos, Types.VARCHAR);
		} else { 
			ps.setString(pos, value);
		}
	}

	
	public static final void setNull(PreparedStatement ps, int pos, Long value) 
			throws SQLException {
		if (value==null) {
			ps.setNull(pos, Types.BIGINT);
		} else { 
			ps.setLong(pos, value);
		}
	}
}
