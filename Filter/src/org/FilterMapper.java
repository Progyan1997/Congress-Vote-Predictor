package org;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class FilterMapper extends Mapper<LongWritable,Text,NullWritable,Text>{
	private NullWritable outkey = NullWritable.get();   //key generated to create the obj one time
	private Text outvalue=new Text();

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		String line=value.toString();  
		String fields[]=line.split(",");
		 if(fields != null && fields.length==5){
			 if (fields[4].equalsIgnoreCase("pilot")){
				 context.write(outkey, value);
			 }
		 }
		
	}

}
