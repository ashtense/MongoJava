package com.ashwani.poc.command.pattern.commandobjects;

import com.ashwani.poc.command.pattern.receiver.Car;

public class CarStopCommand implements CommandBase {

	private final Car car;

	public CarStopCommand(final Car car) {
		this.car = car;
	}

	public void execute() {
		System.out.println("CarStopCommand.execute() - Stopping the car");
		car.stop();
	}

	public void undo() {
		System.out.println("CarStopCommand.undo() - Undoing previous action i.e. starting the car");
		car.stop();
	}

}
