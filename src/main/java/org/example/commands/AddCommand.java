package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.IncorrectInputInScriptException;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;
import org.example.managers.OrganizationAsker;

public class AddCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final OrganizationAsker organizationAsker;

    public AddCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker) {
        super("add {element}", "add a new element to the collection");
        this.collectionManager = collectionManager;
        this.organizationAsker = organizationAsker;
    }

    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()) throw new WrongAmountOfElementsException();
            Organization askerOrganization = new Organization(
                    organizationAsker.setId(),
                    organizationAsker.askName(),
                    organizationAsker.askCoordinates(),
                    organizationAsker.askCreationDate(),
                    organizationAsker.askAnnualTurnover(),
                    organizationAsker.askFullName(),
                    organizationAsker.askEmployeesCount(),
                    organizationAsker.askOrganizationType(),
                    organizationAsker.askAddress()
            );
            askerOrganization.setFullName();
            collectionManager.addToCollection(askerOrganization);
            Console.printLn("Organization was created successfully");
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printError("Usage of (" + argument + ") in " + getName());
        } catch (IncorrectInputInScriptException ignored) {
        }
        return false;
    }
}
