package com.springtut.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationConetxt;
public class Exam
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationConetxt("beans.xml");
		Student manas=context.getBean("student",Student.class);
		manas.displayStudentInfo();
	 
		Student student2=context.getBean("student2",Student.class);
		student2.displayStudentInfo();	
	}

}