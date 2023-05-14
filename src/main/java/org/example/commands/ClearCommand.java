package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

public class ClearCommand extends AbstractCommand {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "clear the collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.clearCollection();
            Console.printLn("Collection was cleared");
            return true;
        } catch (WrongAmountOfElementsException e) {
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}

