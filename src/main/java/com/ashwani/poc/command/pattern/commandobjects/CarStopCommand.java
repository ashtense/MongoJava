package com.ashwani.poc.command.pattern.commandobjects;

import com.ashwani.poc.command.pattern.receiver.Car;

public class CarStopCommand implements CommandBase<String> {

	private final Car car;

	public CarStopCommand(final Car car) {
		this.car = car;
	}

	public String execute() {
		car.stop();
		return "CarStopCommand.execute() - Stopping the car";
	}

	public void undo() {
		System.out.println("CarStopCommand.undo() - Undoing previous action i.e. starting the car");
		car.stop();
	}

}
