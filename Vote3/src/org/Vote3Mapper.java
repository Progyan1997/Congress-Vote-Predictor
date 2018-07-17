package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

public class Vote3Mapper extends Mapper<LongWritable,Text,NullWritable,Text>{


	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		Path[] uris =DistributedCache.getLocalCacheFiles(context.getConfiguration());
		
        HashMap<String,Double> map =new HashMap<String,Double>();
		
		BufferedReader breader = new BufferedReader(new FileReader(uris[0].toString()));
		
		
		while(true){
			String line = breader.readLine();
			
			if(line==null || line.trim().length() == 0)
				break;
			String fields[]=line.split(",");
			map.put(fields[0].trim(), Double.parseDouble(fields[1].trim()));
			
		}
		
	
		String vote1= "",vote1d="",vote1r = "",vote2= "",vote2d = "",vote2r = "",vote3= "",vote3d = "",vote3r = "",vote4= "",vote4d = "",vote4r = "";
		
		String line=value.toString();
		String fields[]=line.split(",");
		  if (!(line.length() == 0)) {
			   vote1 = fields[0].trim();
			   vote1d= fields[1].trim();
			   vote1r = fields[2].trim();
			  
			   vote2 = fields[3].trim();
			   vote2d= fields[4].trim();
			  vote2r = fields[5].trim();
			  
			   vote3 = fields[6].trim();
			   vote3d= fields[7].trim();
			   vote3r = fields[8].trim();
			  
			   vote4 = fields[9].trim();
			   vote4d= fields[10].trim();
			   vote4r = fields[11].trim();
		  }	  
double vote_1d = Double.parseDouble(vote1d);
double vote_1r =Double.parseDouble(vote1r);


double vote_2d = Double.parseDouble(vote2d);
double vote_2r =Double.parseDouble(vote2r);


double vote_3d = Double.parseDouble(vote3d);
double vote_3r =Double.parseDouble(vote3r);


double vote_4d = Double.parseDouble(vote4d);
double vote_4r =Double.parseDouble(vote4r);

Text outkey = new Text();
NullWritable outval = NullWritable.get();
	double D=map.get("P_d");
	double R= map.get("P_r");
	double p,q;
	
	 p = (D)*(vote_1d)*(vote_2d)*(vote_3d)*(vote_4d)*1.0;
	 q = (R)*(vote_1r)*(vote_2r)*(vote_3r)*(vote_4r)*1.0;
	 
	if(p>q){
		outkey.set("D");
		context.write(outval, outkey);
	}
	if(p<q){
		outkey.set("R");
		context.write(outval,outkey);
	}
	}
	
	}	
  
