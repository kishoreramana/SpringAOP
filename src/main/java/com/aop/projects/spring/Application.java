package com.aop.projects.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.projects.spring.intf.CustomerBo;

public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring-Customer.xml");
		CustomerBo customerBO = (CustomerBo) context.getBean("customerBo");

		customerBO.addCustomer();
		System.out.println("---------------");

		try {
			customerBO.addCustomerThrowException();
		} catch (Exception e) {
			System.out.println("customerBo checkName() : Exception thrown..");
		}
		System.out.println("---------------");

		customerBO.addCustomerAround("Javacodegeeks");
		System.out.println("---------------");

		context.close();
	}

}
