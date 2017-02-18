package org.springmvc.circulardependency;

public class ClassA {

	ClassB classB;
	
	
	
	public ClassA(ClassB classB) {
		this.classB = classB;
	}

	public ClassB getClassB() {
		return classB;
	}

	public void setClassB(ClassB classB) {
		this.classB = classB;
	}
	
	
}
