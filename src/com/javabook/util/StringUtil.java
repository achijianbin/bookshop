package com.javabook.util;

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
}
