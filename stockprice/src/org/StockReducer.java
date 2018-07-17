package org;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class StockReducer extends Reducer<Text ,DoubleWritable,Text,Text> {
	private Text outvalue=new Text();

	@Override
	protected void reduce(Text key, Iterable<DoubleWritable> values,Context context)
			throws IOException, InterruptedException {
				StringBuilder sb = new StringBuilder();
				for(DoubleWritable val : values){
					sb.append(val);
					sb.append(",");
					
				}
			outvalue.set(sb.toString());
			context.write(key, outvalue);
				
	
		
		
	}

}
