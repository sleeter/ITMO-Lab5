package org.example.commands;

import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;
import org.example.managers.FileManager;

public class SaveCommand extends AbstractCommand{
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        super("save", "save collection to file");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            fileManager.writeCollectionsOPENCSV(collectionManager.getCollection());
            Console.printLn("Collection was saved successfully");
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printLn("Usage: '" + getName() + "'");
        }
        return false;
    }
}