package org;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class SportsReducer extends Reducer<Text ,IntWritable,Text,IntWritable> {
	private IntWritable outvalue=new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
		Iterator<IntWritable> itr=values.iterator();
		while(itr.hasNext()){
			IntWritable val=itr.next();
			int x =val.get();
			sum = sum+x;
		}
		outvalue.set(sum);
		context.write(key, outvalue);
		
		
	}

}
