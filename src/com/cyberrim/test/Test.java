package com.cyberrim.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	

	public static void main(String[] args) throws IOException {
//		int time = Integer.parseInt(args[0]);
//		int length = Integer.parseInt(args[1]);
//		int max = Integer.parseInt(args[2]);
		System.out.print(">>测试次数:");
		InputStreamReader is_reader = new InputStreamReader(System.in);
        String str = new BufferedReader(is_reader).readLine();
        int time = Integer.parseInt(str);
        
        System.out.print(">>排序数组长度：");
		is_reader = new InputStreamReader(System.in);
        str = new BufferedReader(is_reader).readLine();
        int length = Integer.parseInt(str);
        
        System.out.print(">>数最大值:");
		is_reader = new InputStreamReader(System.in);
        str = new BufferedReader(is_reader).readLine();
        int max = Integer.parseInt(str);
        
        System.out.println();
        
		VarifyManager manager = new VarifyManager(time,length,max);
		manager.start();
	}
	
	
	
	
}






