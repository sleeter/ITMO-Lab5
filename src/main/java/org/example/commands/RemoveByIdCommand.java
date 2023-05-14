package org.example.commands;

import org.example.exceptions.MustBeNotEmptyException;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

public class RemoveByIdCommand extends AbstractCommand{
    private final CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id id", "remove element from collection by its id");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()) throw new WrongAmountOfElementsException();
            int id = Integer.parseInt(argument);
            if(collectionManager.getById(id) == null) throw new MustBeNotEmptyException();
            collectionManager.removeFromCollectionById(id);
            Console.printLn("Organization was removed successfully");
            return true;

        } catch (WrongAmountOfElementsException e){
            Console.printError("No arguments in " + getName());
        } catch (NumberFormatException e) {
            Console.printError("The id have to be an Integer value");
        } catch (MustBeNotEmptyException e) {
            Console.printError("There is no organization with this id");
        }
        return false;
    }
}
