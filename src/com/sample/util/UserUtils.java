package com.sample.util;

import java.util.List;

public class UserUtils {
	public static String convertListToJSON(List<String> list){
		StringBuilder output = new StringBuilder();

		output.append("{");

		if(list!= null){
			for(String username:list){
				output.append("{ username: \"" + username + "\"},");
			}
			if(output.length()>2){
				output.deleteCharAt(output.length()-1);
			}
		}

		output.append("}");

		return output.toString();
	}

	public static String convertStatusToJSON(boolean status){
		StringBuilder output = new StringBuilder();

		output.append("{ status: \"" + ((status)?"Added successfully":"Error occurred") + "\" }");

		return output.toString();
	}
}
