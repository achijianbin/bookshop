package com.javabook.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class doOrderNum{
	public static String doOrderNum() {
	    Random random = new Random();
	    SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
	    String subjectno = allTime.format(new Date())+random.nextInt(10);       
	    return subjectno+random.nextInt(10);
	}
}