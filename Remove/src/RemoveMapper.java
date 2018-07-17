package org;



import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class RemoveMapper extends Mapper<LongWritable,Text,NullWritable,Text> {
	private Text outkey = new Text();   //key generated to create the obj one time
	private NullWritable outvalue=NullWritable.get();
	
	
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		
		
		String line=value.toString();
		String mline=line.replaceAll("\\s+", ",");
		outkey.set(mline);
		  context.write(outvalue,outkey);
		}
		
		
	}
	


