package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class CWMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	private ArrayList<String> cwlist = new ArrayList<String>();
	private Text outkey=new Text();
	private IntWritable outval = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		StringTokenizer tokenizer=new StringTokenizer(line); 
		while(tokenizer.hasMoreTokens()){
			String word = tokenizer.nextToken();
			word=word.replaceAll("\\W+",""); //W consists , . ! etc
			 if ( cwlist.contains(word.toLowerCase()))
				 continue;
			outkey.set(word); 
			context.write(outkey,outval);
		
		}
	}

	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		Path path[]=context.getLocalCacheFiles();
		if(path!=null && path.length>0){
			for(Path p : path){
				String strpath=p.toString();
				FileReader fr= new FileReader(strpath);
				BufferedReader breader=new BufferedReader(fr); //open the file
				 while(true){
					 String word = breader.readLine();
					 if(word==null)
						 break;
					 cwlist.add(word);
				 }
				 breader.close();
			} //for
		} //if
		
	} //setup

}
