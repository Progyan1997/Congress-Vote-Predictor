package org;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SportsDriver1 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job job= Job.getInstance(conf);
		
		job.setJarByClass(SportsDriver1.class);
		job.setMapperClass(SportsMapper1.class); //refers to a public static field of the class
		job.setReducerClass(SportsReducer1.class); //classobject
		//job.setCombinerClass(SportsReducer.class); mapper r reducer r output same na
		job.setPartitionerClass(SportsPartitioner.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(3);
		
		FileInputFormat.addInputPath(job, new Path("sportsdir")); 
		FileOutputFormat.setOutputPath(job,new Path("sportsout"));
		
		
			job.waitForCompletion(true); //start processing
	

		
	}

}
