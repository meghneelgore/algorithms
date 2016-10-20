package com.example.merge.mergetuples;

public class Tuple implements Comparable<Tuple>{
	int x;
	int y;
	
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}


	@Override
	public int compareTo(Tuple o) {
		if(this == o) return 0;
		
		if(this.x < o.x) return -1;
		
		if(this.x > o.x) return 1;
		
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Tuple)) return false;
		
		if(this == obj) return true;
		
		if(((Tuple)obj).x == x) return true;
		
		return false;
	}
}
