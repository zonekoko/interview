package com.zyp.interview.config.util;


import org.springframework.util.ObjectUtils;

public class ObjUtil extends ObjectUtils {
	public static <T> T isEmptySetDefaultValue(Object obj, T value) {
		return isEmpty(obj) ? value : (T) obj;
	}

	public static Boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}