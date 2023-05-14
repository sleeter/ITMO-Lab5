package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

public class InfoCommand extends AbstractCommand{
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info", "print information about the collection to the standard output stream (type, initialization date, number of elements, etc.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Console.printLn(collectionManager.infoAboutCollection());
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}
