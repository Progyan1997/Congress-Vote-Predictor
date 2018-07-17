package org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class WhetherReducer extends Reducer<Text ,Text,Text,Text>{
		ArrayList<Text> temperatureList = new ArrayList<Text>();

	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			throws IOException, InterruptedException {
		 
		for(Text value : values){
			temperatureList.add(value);
		}
		 Collections.sort(temperatureList);
		 int size = temperatureList.size();
		 Text maxvalue = temperatureList.get(size-1);
		 
		 context.write(key, new Text(maxvalue));
		
		  
		}

}
