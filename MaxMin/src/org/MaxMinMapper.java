package org;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMinMapper extends Mapper<Text,Text,Text,Text> {
	private Text outval =new Text();
	private Pattern pattern;
	private String what="^(\\d+\\.?\\d*),.*,(\\d+\\.?\\d*),$";
	@Override
	protected void map(Text key, Text value,Context context)
			throws IOException, InterruptedException {
		String rec=value.toString();
		Matcher m = pattern.matcher(rec);
		if(m.matches()){
			outval.set(m.group(1)+","+m.group(2));
			context.write(key, outval);
		}
	
	}
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		pattern=Pattern.compile(what);
		
	}

}
