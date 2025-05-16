package com.cdac.acts;

public class Grades{
	public void findGrade(int grade){
		if(grade>0 && grade<=50)
			System.out.println("Pass class.");
		else if(grade>50 && grade<=60)
			System.out.println("Second class");
		else if(grade>60 && grade<=75)
			System.out.println("First Class");
		else
			System.out.println("Distinction");
	}
	
	public static void main(String[] args){
		Grades g= new Grades();
		g.findGrade(45);
		g.findGrade(65);
		g.findGrade(77);
	}
}