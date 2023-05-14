package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;

import java.util.LinkedHashSet;

public class SumOfEmployeesCountCommand extends AbstractCommand{
    private final CollectionManager collectionManager;

    public SumOfEmployeesCountCommand(CollectionManager collectionManager){
        super("sum_of_employees_count", "display the count of employees for all elements of the collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            Integer sumOfEmployeesCount = 0;
            for(Organization organization : organizations){
                sumOfEmployeesCount += organization.getEmployeesCount();
            }
            Console.printLn(sumOfEmployeesCount);
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printError("No arguments in " + getName());
        }
        return false;
    }
}
