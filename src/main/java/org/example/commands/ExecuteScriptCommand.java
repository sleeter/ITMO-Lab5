package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.Console;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand() {
        super("execute_script file_name", "read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode.");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            Console.printLn("Execute script '" + argument + "'...");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.printLn("Usage of: '" + getName() + "'");
        }
        return false;
    }
}
