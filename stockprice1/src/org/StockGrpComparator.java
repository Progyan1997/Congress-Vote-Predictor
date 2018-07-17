package org;

import org.apache.hadoop.io.*;

public class StockGrpComparator extends WritableComparator {
	
	
	public StockGrpComparator(){
		super(SPKey.class,true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		SPKey k1 = (SPKey)a;
		SPKey k2 = (SPKey)b;
		return k1.getSymbol().compareTo(k2.getSymbol());
		
	} 

}
