package org;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class SportsReducer1 extends Reducer<Text ,Text,Text,IntWritable> {
	private IntWritable outvalue=new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		
		// TODO Auto-generated method stub
		//(criket,{india,india,...australia})
		//super.reduce(arg0, arg1, arg2);
	

		for(Text val :values)
		{
			sum = sum+1;
		}
		outvalue.set(sum);
		context.write(key, outvalue);
		
	}

}
