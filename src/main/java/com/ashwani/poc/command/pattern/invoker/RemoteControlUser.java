package com.ashwani.poc.command.pattern.invoker;

import com.ashwani.poc.command.pattern.commandobjects.CarMoveCommand;
import com.ashwani.poc.command.pattern.commandobjects.CarStopCommand;
import com.ashwani.poc.command.pattern.commandobjects.CommandBase;
import com.ashwani.poc.command.pattern.receiver.Car;

public class RemoteControlUser {

	public static void main(final String[] args) throws InterruptedException {
		final RemoteControl remoteControl = new RemoteControl();
		final Car car = new Car();

		final CommandBase carMoveCommand = new CarMoveCommand(car);
		remoteControl.onButtonPressed(carMoveCommand);
		Thread.sleep(5000);
		remoteControl.undoAction();

		final CommandBase carStopCommand = new CarStopCommand(car);
		remoteControl.onButtonPressed(carStopCommand);
		Thread.sleep(3000);
		remoteControl.undoAction();
	}
}