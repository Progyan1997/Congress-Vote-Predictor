package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

public class VoteModifyMapper extends Mapper<LongWritable,Text,NullWritable,Text>{
	private double vote1_d=1.0,vote1_r=1.0,vote2_d=1.0,vote2_r=1.0,vote3_d=1.0,vote3_r=1.0,vote4_d=1.0,vote4_r=1.0,D=1.0,R=1.0,P_r=1.0,P_d=1.0;
	String state = "",fname = "",lname = "",party = "",vote1 = "",vote2 = "",vote3 = "",vote4 = "";
	 HashMap<String,Double> map =new HashMap<String,Double>();

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
			NullWritable outkey = NullWritable.get(); 
			Text outval = new Text();
				StringTokenizer itr=new StringTokenizer(value.toString(),",");
				int k=0;
				while(itr.hasMoreElements()){
					if(k == 0)
						state = itr.nextToken();
					else if (k==1)
						fname = itr.nextToken();
					else if (k==2)
						lname = itr.nextToken();
					else if (k==3)
						party = itr.nextToken();
					else if (k==4)
						vote1 = itr.nextToken().trim().toUpperCase();
					else if (k==5)
						vote2 = itr.nextToken().trim().toUpperCase();
					else if (k==6)
						vote3 = itr.nextToken().trim().toUpperCase();
					else if (k==7){
						vote4 = itr.nextToken().trim().toUpperCase();
						break;
					}
					k=k+1;
				}
			
				
				if((vote1.equals("Y"))){
					
					 vote1_d = map.get("P_vote1YD");
					 vote1_r = map.get("P_vote1YR");
				}
				if((vote1.equals("N"))){
					 vote1_d = map.get("P_vote1ND");
				     vote1_r = map.get("P_vote1NR");
				  
				}
				if((vote1.equals("-"))){
					
					 vote1_d = 1.0;
					 vote1_r = 1.0;
					
				}
				if((vote2.equals("Y"))){
					
					vote2_d = map.get("P_vote2YD");
					vote2_r = map.get("P_vote2YR");
				
				}
				if((vote2.equals("N"))){
					
					 vote2_d = map.get("P_vote2ND");
					 vote2_r = map.get("P_vote2NR");
					
				}
				if((vote2.equals("-"))){
					
					  vote2_d = 1.0;
					  vote2_r = 1.0;
					
				}
				if((vote3.equals("Y"))){
					
					 vote3_d = map.get("P_vote3YD");
					 vote3_r = map.get("P_vote3YR");
					
				}
				if((vote3.equals("N"))){
					
					 vote3_d = map.get("P_vote3ND");
					 vote3_r = map.get("P_vote3NR");
				
				}
				if((vote3.equals("-"))){
					
					 vote3_d = 1.000000000000000000;
					 vote3_r = 1.00000000000000000;
					
				}
				if((vote4.equals("Y"))){
					
					 vote4_d = map.get("P_vote4YD");
					 vote4_r = map.get("P_vote4YR");
					
				}
				if((vote4.equals("N"))){
					
					 vote4_d = map.get("P_vote4ND");
					 vote4_r = map.get("P_vote4NR");
				
				}
				if((vote4.equals("-"))){
					
					 vote4_d = 1.0;
					 vote4_r = 1.0;
					
				}
				D =map.get("P_d");
				R =map.get("P_r");
				
				    P_d= ((D)*(vote1_d)*(vote2_d)*(vote3_d)*(vote4_d));
					P_r= (R*(vote1_r)*(vote2_r)*(vote3_r)*(vote4_r));
				
				if(P_d>P_r){
						// outkey.set(party);
						outval.set(party + ",D");
						context.write(outkey, outval);
					}
					if(P_d<P_r){
						// outkey.set(party);
						outval.set(party + ",R");
						context.write(outkey, outval);
					}
				
				
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