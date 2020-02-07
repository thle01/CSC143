package empirical;

import java.util.Random;

public class RunTimeClient {

	public static int[] dataSet(int n) {
		long startTime = System.currentTimeMillis();
		
		//just some tom foolery 
		Random random = new Random();	//generates a pseudo random number
		int[] data = new int[n];
		
		int qtr1 = data.length / 4;
		int qtr2 = qtr1 + data.length / 4;
		int qtr3 = qtr2 + data.length / 4;
		int qtr4 = qtr3 + data.length / 4;
		
		//begin: tom foolery 
		for (int i = 0; i < qtr1; i++) {
			data[i] =  random.nextInt() + 1;
		}
		
		for (int i = qtr1; i < qtr2; i++) {
			data[i] = random.nextInt() + 2;
		}
		
		for (int i = qtr2; i < qtr3; i++) {
			data[i] =  random.nextInt() - 1;
		}
		
		for (int i = qtr3; i < qtr4; i++) {
			data[i] =  random.nextInt() - 2;
		}
		
		long endTime   = System.currentTimeMillis();
		
		System.out.print("DataSet:  n = " + n + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
		return data;
	}
	

	public static int range$1(int[] data) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				diff = Math.abs(data[j] - data[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	

	public static int range$2(int[] data) {
		int diff    = 0;
		int maxDiff = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j =  i + 1; j < data.length; j++) {
				diff = Math.abs(data[j] - data[i]);
				
				if(maxDiff < diff) {
					maxDiff = diff;
				}
			}
		}
		return maxDiff;
	}
	

	public static int range$3(int[] data) {
		int max = data[0];
		int min = max;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
				
			} else if(data[i]< min){
				min = data[i];
			}
		}
		return max - min;
	}
	

	public static void timeRange$1(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = range$1(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	

	public static void timeRange$2(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = range$2(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	
	

	public static void timeRange$3(int[] data) {
		long startTime = System.currentTimeMillis();
		int range      = range$3(data);
		long endTime   = System.currentTimeMillis();
		System.out.print("Range " + range + "\t");
		System.out.print("DataSet:  n = " + data.length + "\t");
		System.out.println("RunTime: " + (endTime - startTime) + " ms");
	}
	

	public static void main(String[] args) {
		
		System.out.println("Data Set - 1 to 8");
		int[] data1  = dataSet(2000);
		int[] data2  = dataSet(4000);
		int[] data3  = dataSet(8000);
		int[] data4  = dataSet(16000);
		int[] data5  = dataSet(32000);
		int[] data6  = dataSet(64000);
		int[] data7  = dataSet(128000);
		int[] data8  = dataSet(256000);
		
		System.out.println();
		System.out.println("Range 1 - Run Time Analysis");
		timeRange$1(data1);
		timeRange$1(data2);
		timeRange$1(data3);
		timeRange$1(data4);
		timeRange$1(data5);
		timeRange$1(data6);
		timeRange$1(data7);
		timeRange$1(data8);
		
		System.out.println();
		System.out.println("Range 2 - Run Time Analysis");
		timeRange$2(data1);
		timeRange$2(data2);
		timeRange$2(data3);
		timeRange$2(data4);
		timeRange$2(data5);
		timeRange$2(data6);
		timeRange$2(data7);
		timeRange$2(data8);
		
		System.out.println();
		System.out.println("Data Set - 9 to 18 for Range 3");
		
		int[] data9  = dataSet(512000);
		int[] data10 = dataSet(1024000);
		int[] data11 = dataSet(2048000);
		int[] data12 = dataSet(4096000);
		int[] data13 = dataSet(8192000);
		int[] data14 = dataSet(16384000);
		int[] data15 = dataSet(32768000);
		int[] data16 = dataSet(65536000);
		int[] data17 = dataSet(131072000);
		int[] data18 = dataSet(262144000);
		
		System.out.println();
		System.out.println("Range 3 - Run Time Analysis");
		timeRange$3(data1);
		timeRange$3(data2);
		timeRange$3(data3);
		timeRange$3(data4);
		timeRange$3(data5);
		timeRange$3(data6);
		timeRange$3(data7);
		timeRange$3(data8);
		timeRange$3(data9);
		timeRange$3(data10);
		timeRange$3(data11);
		timeRange$3(data12);
		timeRange$3(data13);
		timeRange$3(data14);
		timeRange$3(data15);
		timeRange$3(data16);
		timeRange$3(data17);
		timeRange$3(data18);
	}

}
