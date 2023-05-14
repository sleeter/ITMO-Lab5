package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.Console;

public class ExitCommand extends AbstractCommand{
    public ExitCommand() {
        super("exit", "terminate program (without saving to file)");
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Console.printLn("Exit");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}
