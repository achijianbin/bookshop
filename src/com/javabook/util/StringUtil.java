package com.javabook.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * 判断是否是空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否不是空
	 * 
	 * @param str
	 * @return
	 */
	
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断两次密码是否一致
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isSame(String str1, String str2) {
		if (str1.equals(str2)) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 判断用户名是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){

		  for (int i = str.length();--i>=0;){   

		   if (!Character.isDigit(str.charAt(i))){

		    return true;

		   }

		  }

		  return false;

		 }
	/**
	 * 用户名长度判断
	 * @param str
	 * @return
	 */
	public static boolean isLength(String str) {
		if(str.length()>=8) {
			return true;
	} else {
		return false;
	}
	}
		/**
		 * 密码长度判断
		 * @param str
		 * @return
		 */
		public static boolean isPasLength(String str) {
			if(str.length()<8) {
				return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断手机号
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 判断邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		if (str == null)
			return false;
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx1);
		m = p.matcher(str);
		if (m.matches())
			return true;
		else
			return false;
	}

}
