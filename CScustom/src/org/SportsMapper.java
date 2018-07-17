package org;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SportsMapper extends Mapper<LongWritable,Text,Pair,IntWritable>{
	private Pair outkey = new Pair();   //key generated to create the obj one time
	private IntWritable outvalue=new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		String line=value.toString();  //p1,India,Criket
		String fields[]=line.split(",");
		//StringTokenizer tokenizer=new StringTokenizer(line); //another way better datastructure
		
		String sports= fields[2].toLowerCase(); //=> criket
		//(criket,1)
		String country=fields[1].toLowerCase();
		outkey.set(sports,country);
		context.write(outkey, outvalue);
		
		}

}
