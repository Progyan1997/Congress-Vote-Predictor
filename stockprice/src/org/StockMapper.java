package org;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class StockMapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{
	private Text outkey = new Text();   
	private DoubleWritable outvalue=new DoubleWritable(1);

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {

		String line=value.toString();  
		String fields[]=line.split(",");
		double price=Double.parseDouble( fields[2]); //=> stockprice
		String stock=fields[0].toLowerCase(); // stocksymbol
		outkey.set(stock);
		outvalue.set(price);
		context.write(outkey, outvalue);
		
		}

}
