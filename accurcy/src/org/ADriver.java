package org;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ADriver {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Configuration c=new Configuration();
		Job job=Job.getInstance(c);
		job.setJarByClass(ADriver.class);
		
		job.setMapperClass(AMapper.class);
		job.setReducerClass(AReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		Path cwpath=new Path("countfinal");
		URI uri=cwpath.toUri();
		job.addCacheFile(uri);
		
		FileInputFormat.addInputPath(job,new Path("oneout1"));
		FileOutputFormat.setOutputPath(job,new Path("acc"));
		
		job.waitForCompletion(true);
		
	

	}

}
