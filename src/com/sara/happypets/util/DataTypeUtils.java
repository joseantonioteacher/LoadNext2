package com.sara.happypets.util;

public class DataTypeUtils {

	public static final Double from(String s) {
		Double d = null;
		try {
			d = Double.parseDouble(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
}
