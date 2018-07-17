package org;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class AgeCombiner extends Reducer<Text,DoubleWritable,Text,DoubleWritable> {
	private DoubleWritable outval = new DoubleWritable();

	@Override
	protected void reduce(Text key, Iterable<DoubleWritable> values,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
		double total=0;
		int count = 0;
		for(DoubleWritable age : values){
			total=total+age.get();
			count=count+1;
		}
		
			double avage=total/count;
			outval.set(avage);
			context.write(key, outval);
			
		
	}

}
