package org;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SportsMapper1 extends Mapper<LongWritable,Text,Text,Text>{
	private Text outkey = new Text();   //key generated to create the obj one time
	private Text outvalue=new Text();

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
		String country = fields[1].toLowerCase(); //=> india
		outkey.set(sports);
		outvalue.set(country);
		context.write(outkey, outvalue);
		}

}
