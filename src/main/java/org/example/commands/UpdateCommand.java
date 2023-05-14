package org.example.commands;

import org.example.collections.Organization;
import org.example.exceptions.IncorrectInputInScriptException;
import org.example.exceptions.MustBeNotEmptyException;
import org.example.exceptions.WrongAmountOfElementsException;
import org.example.managers.CollectionManager;
import org.example.managers.Console;
import org.example.managers.OrganizationAsker;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class UpdateCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final OrganizationAsker organizationAsker;

    public UpdateCommand(CollectionManager collectionManager, OrganizationAsker organizationAsker) {
        super("update id {element}", "update the value of the collection element whose id is equal to the given one");
        this.collectionManager = collectionManager;
        this.organizationAsker = organizationAsker;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()) throw new WrongAmountOfElementsException();
            int id = Integer.parseInt(argument);
            if(collectionManager.getById(id) == null) throw new MustBeNotEmptyException();
            Organization askerOrganization = new Organization(
                    id,
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
            LinkedHashSet<Organization> organizations = collectionManager.getCollection();
            Iterator<Organization> iterator = organizations.iterator();
            while (iterator.hasNext()){
                if(iterator.next().getId() == askerOrganization.getId()){
                    iterator.remove();
                    break;
                }
            }
            collectionManager.addToCollection(askerOrganization);
            Console.printLn("Organization was updated successfully");
            return true;
        } catch (WrongAmountOfElementsException e){
            Console.printError("No arguments in " + getName());
        } catch (NumberFormatException e) {
            Console.printError("The id have to be an Integer value");
        } catch (MustBeNotEmptyException e) {
            Console.printError("There is no organization with this id");
        } catch (IncorrectInputInScriptException ignored) {
        }
        return false;
    }
}
