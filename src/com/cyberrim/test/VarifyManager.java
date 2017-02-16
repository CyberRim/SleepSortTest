package com.cyberrim.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class VarifyManager {
	
	private List<Integer> unorderedNumbers = new ArrayList<>();
	public static HashMap<Integer,List<Integer>> orderedNumbers = new HashMap<>();
	
	private int times;
	public  static int length = 10000;
	public  static int max = 10000;
	
	public VarifyManager(int times, int length, int max){
		this.times = times;
		this.length = length;
		this.max = max;
		for(int i = 0; i < times; i++ ){
			orderedNumbers.put(i, new ArrayList<Integer>());
		}
	}
	
	public void start(){
		System.out.println("��ʼ����");
		for(int i=0; i < times; i++){
			
			createUnorderedNumber(length, max);
			sort(i);
			lean();
			
		}
	}
	
	public void createUnorderedNumber(int range, int max){
		Random random = new Random();
		for(int i = 0; i <range; i++ ){
			int number = random.nextInt(max)+1;
			if(number<0){
				System.out.println("Here!"+number);
			}
			unorderedNumbers.add(number);
//			System.out.println(number);
		}
		
		unorderedNumbers.set(0, 2);
		unorderedNumbers.set(unorderedNumbers.size()-1, 1);
	}
	
	public void sort(int index){
		
		SortThread[] sortThreads = new SortThread[unorderedNumbers.size()];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(unorderedNumbers.get(i),i,index,new CallbackImp());
        }
        for (int i = 0; i < sortThreads.length; i++) {
//        	System.out.println("��"+(i+1)+"���߳̿�ʼ");
            sortThreads[i].start();
        }
	}
	
	public static boolean verify(int index){
		for(int i = 0; i < orderedNumbers.size()-1; i++){
			try {
				if (orderedNumbers.get(index).get(i) > orderedNumbers.get(index).get(i + 1)) {
					System.out.println(
							"��" + (index + 1) + "������:�������," + "��" + (i + 1) + "λ�� " + orderedNumbers.get(index).get(i)
									+ " ���� " + "��" + (i + 2) + "λ�� " + orderedNumbers.get(index).get(i + 1));
					return false;
				} 
			} catch (NullPointerException e) {
				e.printStackTrace();
				if(orderedNumbers.get(index) == null) {
					System.out.println("List��ָ��");
					return false;
				}
				if(orderedNumbers.get(index).get(i) == null) {
					System.out.println("Integer��ָ��");
					return false;
				}
			}
		}
		return true;
	}
	
	public void lean(){
		unorderedNumbers.clear();
//		orderedNumbers.clear();
	}
}
class CallbackImp implements Callback{
	public void callback(int index){
		boolean flag = VarifyManager.verify(index);
		if(flag){
			System.out.println("��"+(index+1)+"������:������ȷ");
		}
	}
}
