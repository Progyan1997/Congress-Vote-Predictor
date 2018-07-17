package org;



import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WhetherMapper extends Mapper<LongWritable,Text,Text,Text> {
	
	
	public static final int Missing = 9999;
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		String fields[]=line.split(",");
		  if (!(line.length() == 0)) {
			  String vote1 = fields[0].trim().toUpperCase();
			 // String date = line.substring(6,14);
			 // float temp_max = Float.parseFloat(line.substring(39, 45).trim());
			  //float temp_min = Float.parseFloat(line.substring(47, 53).trim());
			  
			 if(vote1=="Y"){
				 context.write(new Text("countv1"), new Text(String.valueOf(vote1)));
			 }
			  
			// if(temp_min < 10 && temp_min != Missing){
				// context.write(new Text("coldday" + date), new Text(String.valueOf(temp_min)));
			 //}
			 
		  }
		
		
	}
	

}
