package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

public class AReducer extends Reducer<Text,DoubleWritable,Text,Text>{
	 HashMap<String,Double> map =new HashMap<String,Double>();

	@Override
	protected void reduce(Text outputkey, Iterable<DoubleWritable> values,Context context)
			throws IOException, InterruptedException {
		double count =map.get("total");
		double sum=0;
		for(DoubleWritable value:values)
		{
			sum += value.get();
		}
		 double confidence = ((sum / count)*100.0) ;
		 String con = Double.toString(confidence);
		 
		context.write(new Text(outputkey),new Text(con+" %"));

	}

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		Path[] uris =DistributedCache.getLocalCacheFiles(context.getConfiguration());
		BufferedReader breader = new BufferedReader(new FileReader(uris[0].toString()));
		
		
		while(true){
			String line = breader.readLine();
			
			if(line==null || line.trim().length() == 0)
				break;
			String fields[]=line.split(",");
			map.put(fields[0].trim(), Double.parseDouble(fields[1].trim()));
			
		}
	}
	

}
