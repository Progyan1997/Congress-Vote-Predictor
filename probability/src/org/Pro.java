package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pro {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		HashMap<String,Integer> map =new HashMap<String,Integer>();
		
		BufferedReader breader = new BufferedReader(new FileReader("countfinal"));
		PrintWriter pwriter = new PrintWriter(new FileWriter("probabilityfinal.txt"));
		
		while(true){
			String line = breader.readLine();
			
			if(line==null || line.trim().length() == 0)
				break;
			String fields[]=line.split(",");
			map.put(fields[0].trim(), Integer.parseInt(fields[1].trim()));
			
		}
		
		int total = map.get("total");  //total==>total no of records
		int D = map.get("d");    //no-d==>total no of D
		int R = map.get("r");    //no-r==>total no of R
		
		 
		for(Entry<String,Integer> entry : map.entrySet()){
			String key = entry.getKey();
			double val = entry.getValue()*1.0;
			double pval = 1.0;
			
			if(key.equals("total")){
				
				continue;
			}
			if(key.equals("d")){
				pval = (val*1.0)/total;
			}
			if(key.equals("r")){
				pval = (val*1.0)/total;
			}
			if (key.endsWith("D")){
				pval = (val*1.0)/D;
				
			}
			if (key.endsWith("R")){
				pval = (val*1.0)/R;
				
			}

			pwriter.println("P_"+key+","+pval);
	}
		
		pwriter.close();
		breader.close();
		
	}
}

