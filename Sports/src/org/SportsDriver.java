package org;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SportsDriver {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(SportsDriver.class);
		job.setMapperClass(SportsMapper.class); //refers to a public static field of the class
		job.setReducerClass(SportsReducer.class); //classobject
		job.setCombinerClass(SportsReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(3);
		
		FileInputFormat.addInputPath(job, new Path("sportsdir")); 
		FileOutputFormat.setOutputPath(job,new Path("sportsout"));
		
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
