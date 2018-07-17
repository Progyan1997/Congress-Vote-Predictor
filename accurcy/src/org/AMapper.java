package org;

import java.io.IOException;
import java.util.StringTokenizer;


import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class AMapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{


	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {

		StringTokenizer itr = new StringTokenizer(value.toString(),",");
		String party_defined = itr.nextToken();
		String party_predicted = itr.nextToken();
		
		
		Text outputkey=new Text();
		DoubleWritable outputvalue=new DoubleWritable(1);
		if((party_defined.equals(party_predicted))){
			outputkey.set("Accuracy");
			context.write(outputkey,outputvalue);
		}
		
	}
}