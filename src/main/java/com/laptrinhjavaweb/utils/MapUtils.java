package com.laptrinhjavaweb.utils;

import java.util.Map;

public class MapUtils {

	public static <T> T getObject (Map<String, Object> params, String key, Class<T> tClass){
		Object obj = params.getOrDefault(key, null);
		if(obj != null) {
			if(tClass == String.class) {
				obj = obj.toString();
			} else if (tClass == Integer.class) {
				obj = obj.toString() != "" ? Integer.parseInt(obj.toString()) : null;
			} else if (tClass == Long.class) {
				obj = obj.toString() != "" ? Long.parseLong(obj.toString()) : null;
			}
			return tClass.cast(obj);
		}
		return null;
	}
}
