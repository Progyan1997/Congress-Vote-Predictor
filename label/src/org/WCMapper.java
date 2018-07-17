package org;



import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
	private Text outkey = new Text();   //key generated to create the obj one time
	private IntWritable outvalue=new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		String line=value.toString();
		//String[] words=line.split(" ");
		StringTokenizer tokenizer=new StringTokenizer(line); //another way better datastructure
		while(tokenizer.hasMoreTokens()){
			String word = tokenizer.nextToken();
			
			outkey.set(word); //outkey value reset
			context.write(outkey,outvalue);
		
		}
		
		
		
	}
	

}
