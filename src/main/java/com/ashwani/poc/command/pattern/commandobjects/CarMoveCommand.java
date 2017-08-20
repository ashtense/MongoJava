package com.ashwani.poc.command.pattern.commandobjects;

import com.ashwani.poc.command.pattern.receiver.Car;

public class CarMoveCommand implements CommandBase<String> {

	private final Car car;

	public CarMoveCommand(final Car car) {
		this.car = car;
	}

	public String execute() {
		car.move();
		return "CarMoveCommand.execute(): Invoking move on Car";
	}

	public void undo() {
		System.out.println("CarMoveCommand.undo(): Undoing previous action Invoking stop() on Car");
		car.stop();
	}

}
