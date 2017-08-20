package com.ashwani.poc.command.pattern.commandobjects;

public interface CommandBase<T> {

	T execute();

	void undo();
}
