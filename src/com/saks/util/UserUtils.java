package com.saks.util;

import java.util.List;

public class UserUtils {
	public static String convertListToJSON(List<String> list){
		StringBuilder output = new StringBuilder();

		output.append("{");

		for(String username:list){
			output.append("{ username: \"" + username + "\"},");
		}
		if(output.length()>2){
			output.deleteCharAt(output.length()-1);
		}
		output.append("}");

		return output.toString();
	}

	public static String convertStatusToJSON(boolean status){
		StringBuilder output = new StringBuilder();

		output.append("{");

		output.append("status: \"" + ((status)?"Added successfully":"Error occurred") + "\"");

		output.append("}");

		return output.toString();
	}
}
