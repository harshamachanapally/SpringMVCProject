package org.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@NamedQuery(name = "Student.bystudentName", query = "From Student where studentName = ? and date = ?")
public class Student{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int studentId;
@Pattern(regexp="[^0-9]*",message ="StudentName should contain only characters")
private String studentName;
@Size(min=2,max=30) @IsValidHobby()
private String Hobby;
@Past(message="Cannot have future date")
private Date date;
@ManyToMany
@JoinTable(name="StudentSkill",joinColumns = @JoinColumn(name="student_studentId"),
				inverseJoinColumns = @JoinColumn(name="studentSkill_skillId"),
				uniqueConstraints = @UniqueConstraint(columnNames = {"student_studentId", "studentSkill_skillId"}))
@NotNull
private Collection<Skill> studentSkill = new ArrayList<Skill>();
@ManyToOne 
@JoinColumn(name="addressid")
private Address studentAddress;

public Address getStudentAddress() {
	return  studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public Collection<Skill> getStudentSkill() {
	return studentSkill;
}
public void setStudentSkill(Collection<Skill> studentSkill) {
	this.studentSkill = studentSkill;
}

public Date getDate() {
	return date;
}
public void setDate(String date) throws ParseException {
	SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
	this.date = format.parse(date);
}
public String getstudentName() {
	return studentName;
}
public void setstudentName(String studentName) {
	this.studentName = studentName;
}
public String getHobby() {
	return Hobby;
}
public void setHobby(String hobby) {
	this.Hobby = hobby;
}

/*public int hashCode(){
	int prime = 31;
	int result = 1;
	result = prime*result + 
}*/
public int hashCode(){
	
	return (this.studentName.hashCode()+this.date.hashCode());
}

public boolean equals(Object obj){
	Student stu = (Student) obj;
	if(this.studentName.equalsIgnoreCase(stu.getstudentName()) && this.date.compareTo(stu.getDate()) == 0)
	return true;
	return false;
}
}
