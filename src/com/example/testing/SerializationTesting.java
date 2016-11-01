package com.example.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.imageio.stream.FileImageInputStream;

public class SerializationTesting {
	
	public static void main(String[] args) {
		Person p = new Person("Meghneel");
		Person r = new Person("Anjali");
		
		writeToFile(p);
		writeToFile(r);
		Person q = readFromFile();
		System.out.println(q);
		
	}
	public static void writeToFile(Person p) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.bin"));
			oos.writeObject(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Person readFromFile() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.bin"));
			Person p = (Person) ois.readObject();
			return p;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

class Person  implements Serializable, Comparable {
	
	static int count = 0;

	@Override
	public String toString() {
		return "Person [name=" + name + ", map=" + map + "]";
	}
	public Person(String name) {
		super();
		this.name = name;
		this.map = new HashMap<String, Integer>();
		map.put(name, count++);
	}

	String name;
	HashMap<String, Integer> map;

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}