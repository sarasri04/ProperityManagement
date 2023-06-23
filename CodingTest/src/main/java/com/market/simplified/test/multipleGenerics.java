package com.market.simplified.test;

class genericTest<K,V> {
	private K key;
	private V value;
	
	public genericTest(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "genericTest [key=" + key + ", value=" + value + "]";
	}	
}
class check {
	public <T,V> Boolean setItem(T value1, V value2) {
		if(value1.equals(value2)) {
			return true;
		}
		return false;
		
	}
	
}
public class multipleGenerics {

	public static void main(String[] args) {
		System.out.println("my user:"+ setItem("Sara", "SaraSri"));
	}

	public static <T,V> Boolean setItem(T value1, V value2) {
		if(value1.equals(value2)) {
			return true;
		}
		return false;
		
	}
}
