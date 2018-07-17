package org;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;


public class SportsReducer extends Reducer<Pair ,IntWritable,Pair,IntWritable> {
	private IntWritable outvalue=new IntWritable();

	@Override
	protected void reduce(Pair key, Iterable<IntWritable> values,Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
		
		for(IntWritable val : values){
			int x =val.get();
			sum = sum+x;
		}
		outvalue.set(sum);
		context.write(key, outvalue);
		
		
	}

}
