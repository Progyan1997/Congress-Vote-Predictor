package org;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class SportsPartitioner extends Partitioner <Text,Text>{

	@Override
	public int getPartition(Text key, Text value, int no_of_partitioner) {
		// TODO Auto-generated method stub
		String sports=key.toString();
		String country=value.toString();
		if(sports.equals("criket") && country.equals("india"))
		      return 0;
		else
			if(sports.equals("criket") && !country.equals("india"))
				return 1;
			else
				return 2;
	}
	

}
