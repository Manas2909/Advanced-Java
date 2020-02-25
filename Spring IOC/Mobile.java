package com.springtut.ioc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationConetxt;
public class Mobile
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationConetxt("beans.xml");
		System.out.println("config loaded ");
		Sim sim=context.getBean("sim",Sim.class);
		sim.calling();
		sim.data();
	}
}