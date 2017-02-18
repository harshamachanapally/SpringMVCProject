package org.springmvc.circulardependency;

public class ClassB {

	ClassA classA;
	
	
	
	public ClassB(ClassA classA) {
		this.classA = classA;
	}

	public ClassA getClassA() {
		return classA;
	}

	public void setClassA(ClassA classA) {
		this.classA = classA;
	}
	
	
}
