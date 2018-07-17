package org;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rec="22.7,45.8,34.9,56.7,";
		String what="^(\\d+\\.?\\d*),.*,(\\d+\\.?\\d*),$";
		Pattern pattern=Pattern.compile(what);
		Matcher m=pattern.matcher(rec);
		if(m.matches()){
			System.out.println("found"+m.group(1)+","+m.group(2));
		}
		else{
			System.out.println("notfound");
		}
		

	}

}
