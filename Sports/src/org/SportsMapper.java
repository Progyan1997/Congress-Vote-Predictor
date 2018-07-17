package org;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SportsMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	private Text outkey = new Text();   //key generated to create the obj one time
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
		outkey.set(sports);
		context.write(outkey, outvalue);
		
		}

}
