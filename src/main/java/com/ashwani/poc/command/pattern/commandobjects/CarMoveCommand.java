package com.ashwani.poc.command.pattern.commandobjects;

import com.ashwani.poc.command.pattern.receiver.Car;

public class CarMoveCommand implements CommandBase {

	private final Car car;

	public CarMoveCommand(final Car car) {
		this.car = car;
	}

	public void execute() {
		System.out.println("CarMoveCommand.execute(): Invoking move on Car");
		car.move();
	}

	public void undo() {
		System.out.println("CarMoveCommand.undo(): Undoing previous action Invoking stop() on Car");
		car.stop();
	}

}
