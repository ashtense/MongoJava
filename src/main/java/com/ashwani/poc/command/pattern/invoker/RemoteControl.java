package com.ashwani.poc.command.pattern.invoker;

import com.ashwani.poc.command.pattern.commandobjects.CommandBase;

public class RemoteControl {

	CommandBase<String> onCommand, releaseCommand, undoCommand;

	public void onButtonPressed(final CommandBase<String> onCommand) {
		this.onCommand = onCommand;
		final String execute = onCommand.execute();
		System.err.println(execute);
		undoCommand = onCommand;
	}

	public void onButtonRelease(final CommandBase<String> releaseCommand) {
		this.releaseCommand = releaseCommand;
		final String execute = releaseCommand.execute();
		System.err.println(execute);
		undoCommand = releaseCommand;
	}

	public void undoAction() {
		undoCommand.undo();
	}
}
