package org.example.commands;

/**
 * Intereface for all commands.
 */
public interface ICommand {
    String getDescription();
    String getName();
    boolean execute(String argument);
}
