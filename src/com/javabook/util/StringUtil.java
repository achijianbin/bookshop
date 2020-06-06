package com.javabook.util;

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
}
