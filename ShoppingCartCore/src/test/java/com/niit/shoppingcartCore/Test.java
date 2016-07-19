package com.niit.shoppingcartCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String [] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartCore");
		context.refresh();
		
		Category c = (Category) context.getBean("category");
		
		c.setId("500");
		c.setName("nokia");
		c.setDescription("mobile");
		
		System.out.println(    c.getId()  );
		System.out.println(    c.getName()  );
		System.out.println( c.getDescription());
		
		System.out.println("created successfully");

}
}
