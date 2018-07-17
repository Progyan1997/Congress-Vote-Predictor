package org;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class AgeMapper extends Mapper<LongWritable,Text,Text,SumAgeCountType>{
	private Text outkey = new Text();   //key generated to create the obj one time
	private SumAgeCountType outvalue=new SumAgeCountType();

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		String record = value.toString().trim();
		String fields[]=record.split(",");
		if(fields != null && fields.length==5){
			try{
			String prof = fields[4].toLowerCase();
			double age = Double.parseDouble(fields[3]);
			outkey.set(prof);
			outvalue.set(age,1);
			context.write(outkey, outvalue);
			}
			catch(Exception e){}
			
		}
		
	}
}
