package com.example.lld;


import java.sql.Timestamp;
import java.util.*;

enum Type
{
	DOCX("docx"),
	PPT("ppt");

	private String value;

	Type(String value) {this.value = value;}

	public String getValue() {return value;}

}

class File {
	String name; 
	Integer size;
	Type type;
	boolean isDir;
	File[] subDir;
	String filePath;
	Timestamp deleted;
	Timestamp created;
	Timestamp modified;
}

class Filter {
	String name;
	Type type;
	Integer size;

	public Filter(Type type) {
		this.type = type;
	}

	public Filter(String name) {
		this.name = name;
	}

	public Filter(Integer size) {
		this.size = size;
	}

	public Filter(Type type, Integer size) {
		this.type = type;
		this.size = size;
	}

	public Filter(String name, Type type, Integer size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public boolean apply(File file) {
		if(this.size == null) checkIfTypeMatches(file);
		if(this.type == null) checkIfSizeMatches(file);
		if(this.name == null) checkIfNameMatches(file);
		return checkIfTypeMatches(file) && checkIfSizeMatches(file) && checkIfNameMatches(file);
	}

	//if type matches
	public boolean checkIfTypeMatches(File file) {
		return file.type == this.type;
	}

	//if name matches
	public boolean checkIfNameMatches(File file) {
		return file.name == this.name;
	}

	//if size matches
	public boolean checkIfSizeMatches(File file) {
		return file.size == this.size;
	}

}

class FileFinder {
	File root;
	public FileFinder(File curr) {
		this.root = curr;
	}

	public List<String> find(String name, Integer size, Type type) throws Exception {
		Filter filter = new Filter(name, type, size);
		if(!root.isDir) throw new Error("No Directory");

		List<String> outputList = new ArrayList<>();
		Queue<File> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			File head = queue.poll();
			if(head.isDir) {
				for(File sub: head.subDir) {
					queue.add(sub);
				}
			} else {
				if(filter.apply(head)) {
					outputList.add(head.filePath);
				}
			}
		}

		return outputList;
	}   
}



