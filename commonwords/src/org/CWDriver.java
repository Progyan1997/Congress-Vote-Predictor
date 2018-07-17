package org;

import java.io.IOException;
import java.net.URI;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CWDriver {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job job= Job.getInstance(conf);
		
		Path cwpath=new Path("cw/commonwords.txt");
		URI uri=cwpath.toUri();
		
		job.addCacheFile(uri); //distribute cache is in action
		
		
		job.setJarByClass(CWDriver.class);
		job.setMapperClass(CWMapper.class); //refers to a public static field of the class
		job.setReducerClass(CWReducer.class); //classobject
		job.setCombinerClass(CWReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(1);
		
		FileInputFormat.addInputPath(job, new Path("wcfolder")); 
		FileOutputFormat.setOutputPath(job,new Path("commoncout"));
		
		try {
			job.waitForCompletion(true); //start processing
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
