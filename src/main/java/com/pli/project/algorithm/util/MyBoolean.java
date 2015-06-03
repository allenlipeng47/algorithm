package com.pli.project.algorithm.util;

public class MyBoolean {
	public boolean bool;
	public MyBoolean(boolean bool){
		this.bool = bool;
	}
	public MyBoolean(){
		this.bool = false;
	}
	public String toString(){
		return String.valueOf(bool);
	}
}
