package org;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Vote2Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Configuration c=new Configuration();
		Job job=Job.getInstance(c);
		job.setJarByClass(Vote2Driver.class);
		job.setMapperClass(Vote2Mapper.class);
		job.setNumReduceTasks(0);
		//job.setReducerClass(VoteReducer.class);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		
		
		FileInputFormat.addInputPath(job,new Path("oneout1"));
		FileOutputFormat.setOutputPath(job,new Path("oneout2"));
		job.waitForCompletion(true);
		
	

	}

}
