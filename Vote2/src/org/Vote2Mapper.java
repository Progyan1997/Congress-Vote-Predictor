package org;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Vote2Mapper extends Mapper<LongWritable,Text,NullWritable,Text>{
	private Text outkey = new Text();
	private NullWritable outval = NullWritable.get();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
			String line=value.toString();
			String mline = line.replaceAll("\\s+", ",");
			outkey.set(mline);
			context.write(outval, outkey);
	}
	
	
	

}
