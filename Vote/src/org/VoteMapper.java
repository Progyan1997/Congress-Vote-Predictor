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

public class VoteMapper extends Mapper<LongWritable,Text,NullWritable,Text>{
	private double a=1.0,b=1.0,c=1.0,d=1.0,e=1.0,f=1.0,g=1.0,h=1.0,D=1.0,R=1.0,P_r=1.0,P_d=1.0;
	String state = "",fname = "",lname = "",party = "",vote1 = "",vote2 = "",vote3 = "",vote4 = "";

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
NullWritable outkey = NullWritable.get(); 
Text outval = new Text();

if((vote1.equals("Y"))){
	
	 a = map.get("P_vote1YD");
	 b = map.get("P_vote1YR");
}
if((vote1.equals("N"))){
	 a = map.get("P_vote1ND");
     b = map.get("P_vote1NR");
  
}
if((vote1.equals("-"))){
	
	 a = 1.00000000000000000000;
	 b = 1.000000000000000000000;
	
}
if((vote2.equals("Y"))){
	
	c = map.get("P_vote2YD");
	 d = map.get("P_vote2YR");

}
if((vote2.equals("N"))){
	
	 c = map.get("P_vote2ND");
	 d = map.get("P_vote2NR");
	
}
if((vote2.equals("-"))){
	
	 c = 1.000000000000000000000000000000000000000;
	  d = 1.000000000000000000000000000000000000000;
	
}
if((vote3.equals("Y"))){
	
	 e = map.get("P_vote3YD");
	 f = map.get("P_vote3YR");
	
}
if((vote3.equals("N"))){
	
	 e = map.get("P_vote3ND");
	 f = map.get("P_vote3NR");

}
if((vote3.equals("-"))){
	
	e = 1.000000000000000000;
	 f = 1.00000000000000000;
	
}
if((vote4.equals("Y"))){
	
	 g = map.get("P_vote4YD");
	 h = map.get("P_vote4YR");
	
}
if((vote4.equals("N"))){
	
	 g = map.get("P_vote4ND");
	 h = map.get("P_vote4NR");

}
if((vote4.equals("-"))){
	
	 g = 1.00000000000000000000;
	 h = 1.0000000000000000000;
	
}
D =map.get("P_d");
R =map.get("P_r");

    P_d= ((D)*(a)*(c)*(e)*(g));
	P_r= (R*(b)*(d)*(f)*(h));

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
}