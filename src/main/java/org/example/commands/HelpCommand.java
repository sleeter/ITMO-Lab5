package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.Console;

public class HelpCommand extends AbstractCommand{
    public HelpCommand() {
        super("help", "display help on available commands");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
        } catch (WrongAmountOfElementsException exception) {
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}
