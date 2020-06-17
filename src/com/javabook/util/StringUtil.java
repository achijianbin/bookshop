package com.javabook.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ���������
 * 
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * �ж��Ƿ��ǿ�
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
	 * �ж��Ƿ��ǿ�
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
	 * �ж����������Ƿ�һ��
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
	 * �ж��û����Ƿ�Ϊ����
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
	 * �û��������ж�
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
		 * ���볤���ж�
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
	 * �ж��ֻ���
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // ��֤�ֻ���
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * �ж�����
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
