package org;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class SumAgeCountType implements Writable {
	private DoubleWritable age=new DoubleWritable();
	private IntWritable count=new IntWritable(1);
	
	public void set(double a,int c){
		age.set(a);
		count.set(c);
	}
	
	public double getAge(){
		return age.get();
	}
	
	public int getCount(){
		return count.get();
	}
	
	
	@Override
	public void readFields(DataInput inputstream) throws IOException {
		// TODO Auto-generated method stub
		age.readFields(inputstream);
		count.readFields(inputstream);
		
		
	}

	@Override
	public void write(DataOutput outputstream) throws IOException {
		// TODO Auto-generated method stub
		age.write(outputstream);
		count.write(outputstream);
	
	}

}
