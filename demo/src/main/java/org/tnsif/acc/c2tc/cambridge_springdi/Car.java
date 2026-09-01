package org.tnsif.acc.c2tc.cambridge_springdi;

/*
// Previous version - setter-based dependency injection
public class Car {

	private Engine engine;

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void drive()
	{
		engine.start();
		System.out.println("Car is Running");
	}
}
*/

// Current version - constructor-based dependency injection
public class Car {

	private Engine engine;

	public Car(Engine engine)
	{
		this.engine=engine;
		System.out.println("Car object created");
	}
	public void drive()
	{
		engine.start();
		System.out.println("Car is Running");
	}
}
