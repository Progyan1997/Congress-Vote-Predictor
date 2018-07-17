package org;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class StockPartitioner extends Partitioner <SPKey,DoubleWritable>{

	@Override
	public int getPartition(SPKey key, DoubleWritable value, int no_of_partitioner) {
		int rem = key.getSymbol().hashCode() % no_of_partitioner;
		return rem;
	
		
	}
	

}
