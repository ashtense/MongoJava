package com.ashwani.poc.command.pattern.invoker;

import com.ashwani.poc.command.pattern.commandobjects.CommandBase;

public class RemoteControl {

	CommandBase onCommand, releaseCommand, undoCommand;

	public void onButtonPressed(final CommandBase onCommand) {
		this.onCommand = onCommand;
		onCommand.execute();
		undoCommand = onCommand;
	}

	public void onButtonRelease(final CommandBase releaseCommand) {
		this.releaseCommand = releaseCommand;
		releaseCommand.execute();
		undoCommand = releaseCommand;
	}

	public void undoAction() {
		undoCommand.undo();
	}
}
