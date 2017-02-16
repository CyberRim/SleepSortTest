package com.cyberrim.test;

class SortThread extends Thread{
    private int ms = 0;
    private int index;
    private int i;
    private Callback callback;
    public SortThread(int ms,int i,int index, Callback callback){
        this.ms = ms;
        this.index = index;
        this.i = i;
        this.callback = callback;
    }
    public void run(){
        try {
        	sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
        	Integer integer = new Integer(ms);
        	synchronized (VarifyManager.orderedNumbers.get(index)){
        		VarifyManager.orderedNumbers.get(index).add(integer);
        	}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("index:"+index);
			System.out.println("ms:"+ms);
			e.printStackTrace();
		}
		if(i == VarifyManager.length-1){
        	callback.callback(index);
        }
        
    }
}
