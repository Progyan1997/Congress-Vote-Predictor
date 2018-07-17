package org;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class AgeReducer extends Reducer<Text,SumAgeCountType,Text,DoubleWritable> 
{
	private DoubleWritable outval = new DoubleWritable();

	@Override
	protected void reduce(Text key, Iterable<SumAgeCountType> values,Context context)
			throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
		double total=0;
		int count = 0;
		for(SumAgeCountType val : values)
		{
			total=total+val.getAge();
			count=count+val.getCount();
		}
			double avage=total/count;
			outval.set(avage);
			context.write(key, outval);
			
	}
	
}
