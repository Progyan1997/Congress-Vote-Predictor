package org;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;
 
public class Print
{
	public class Map extends Mapper<LongWritable,Text,NullWritable,Text> {
		private Text outkey = new Text();   //key generated to create the obj one time
		private NullWritable outvalue=NullWritable.get();
		
		
		
		@Override
		protected void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {
			
			
			
			String line=value.toString();
			String fields[]=line.split(",");
              String vote1 = fields[4].toUpperCase().trim();
			if(vote1=="Y"){
			outkey.set(vote1);
			}
			  context.write(outvalue,outkey);
			}
			
			
		}
 

 
public static void main(String[] args) throws Exception {
 
Configuration conf= new Configuration();
Job job = new Job(conf);
job.setJarByClass(Print.class);
job.setMapperClass(Map.class);
//job.setReducerClass(Reduce.class);
job.setOutputValueClass(Text.class);
job.setOutputKeyClass(NullWritable.class);
job.setInputFormatClass(TextInputFormat.class);
job.setOutputFormatClass(TextOutputFormat.class);
//Path outputPath = new Path(args[1]);
FileInputFormat.addInputPath(job, new Path("input")); 
FileOutputFormat.setOutputPath(job,new Path("output1"));
//deleting the output path automatically from hdfs so that we don't have to delete it explicitly
//outputPath.getFileSystem(conf).delete(outputPath);
//exiting the job only if the flag value becomes false
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}