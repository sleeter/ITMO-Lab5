package org.example.managers;


import org.example.commands.ICommand;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager {
    private final ArrayList<ICommand> commands;
    private final ICommand addCommand;
    private final ICommand addIfMaxCommand;
    private final ICommand clearCommand;
    private final ICommand executeScriptCommand;
    private final ICommand exitCommand;
    private final ICommand filterStartsWithNameCommand;
    private final ICommand helpCommand;
    private final ICommand infoCommand;
    private final ICommand printFieldAscendingPostalAddressCommand;
    private final ICommand removeByIdCommand;
    private final ICommand removeGreaterCommand;
    private final ICommand removeLowerCommand;
    private final ICommand saveCommand;
    private final ICommand showCommand;
    private final ICommand sumOfEmployeesCountCommand;
    private final ICommand updateCommand;
    public CommandManager(ICommand addCommand, ICommand addIfMaxCommand, ICommand clearCommand, ICommand executeScriptCommand, ICommand exitCommand, ICommand filterStartsWithNameCommand, ICommand helpCommand, ICommand infoCommand, ICommand printFieldAscendingPostalAddressCommand, ICommand removeByIdCommand, ICommand removeGreaterCommand, ICommand removeLowerCommand, ICommand saveCommand, ICommand showCommand, ICommand sumOfEmployeesCountCommand, ICommand updateCommand){
        this.addCommand = addCommand;
        this.addIfMaxCommand = addIfMaxCommand;
        this.clearCommand = clearCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.exitCommand = exitCommand;
        this.filterStartsWithNameCommand = filterStartsWithNameCommand;
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.printFieldAscendingPostalAddressCommand = printFieldAscendingPostalAddressCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.sumOfEmployeesCountCommand = sumOfEmployeesCountCommand;
        this.updateCommand = updateCommand;

        commands = new ArrayList<>(Arrays.asList(addCommand, addIfMaxCommand, clearCommand, executeScriptCommand, exitCommand,
                filterStartsWithNameCommand, helpCommand, infoCommand, printFieldAscendingPostalAddressCommand,
                removeByIdCommand, removeGreaterCommand, removeLowerCommand, saveCommand, showCommand,
                sumOfEmployeesCountCommand, updateCommand));
    }

    /**
     * If the command is not found, print a message to the user
     *
     * @param command The command that was not found.
     * @return Nothing.
     */
    public boolean noSuchCommand(String command) {
        Console.printLn("Command '" + command + "' was not found. Try to write 'help' for more info.");
        return false;
    }
    /**
     * Prints a list of all commands and their descriptions
     *
     * @param argument The argument passed to the help command.
     * @return The boolean value of the help command.
     */
    public boolean help(String argument) {
        if (!helpCommand.execute(argument)) {
            for (ICommand command : this.commands) {
                Console.printLn(command.getName() + " - " + command.getDescription());
            }
            return true;
        } else return false;
    }
    /**
     * This function is called when the user types "info" in the command line
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }
    /**
     * This function is called when the user types "show" in the command line
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }
    /**
     * This function is called when the user types "add" in the command line
     *
     * @param argument The argument to be added to the list.
     * @return the response of right execution.
     */
    public boolean add(String argument) {
        return addCommand.execute(argument);
    }
    /**
     * The update method takes a String argument and returns a boolean value
     *
     * @param argument The argument to the command.
     * @return the response of right execution
     */
    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }
    /**
     * Remove an organization from the collection by its id
     *
     * @param argument The argument to pass to the command.
     * @return the response of right execution.
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }
    /**
     * Clear the current collection
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }
    /**
     * The save function takes a string argument and returns a boolean value
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }
    /**
     * Execute a script
     *
     * @param argument The argument to pass to the script.
     * @return the response of right execution.
     */
    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }
    /**
     * The exit function is a method that takes a String argument.
     *
     * @param argument The argument passed to the command.
     * @return the response of right execution.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }
    /**
     * If the element is greater than the current maximum, then add it to the list
     *
     * @param argument The argument to be added to the list.
     * @return the response of right execution.
     */
    public boolean addIfMax(String argument) {
        return addIfMaxCommand.execute(argument);
    }
    /**
     * Remove elements which greater than given
     *
     * @param argument The argument to compare against.
     * @return the response of right execution.
     */
    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }
    /**
     * Remove elements which lower than given
     *
     * @param argument The argument to compare against.
     * @return the response of right execution.
     */
    public boolean removeLower(String argument) {
        return removeLowerCommand.execute(argument);
    }
    /**
     * Prints the sum of field employeeCount for all organizations
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean sumOfEmployeesCount(String argument) {
        return sumOfEmployeesCountCommand.execute(argument);
    }
    /**
     * Prints elements which argument are substring of their name
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean filterStartsWithName(String argument) {
        return filterStartsWithNameCommand.execute(argument);
    }
    /**
     * Prints the postal address in ascending order
     *
     * @param argument The argument to the command.
     * @return the response of right execution.
     */
    public boolean printFieldAscendingPostalAddress(String argument) {
        return printFieldAscendingPostalAddressCommand.execute(argument);
    }
    /**
     * This function is used to print out the string representation of the command manager
     *
     * @return The string "CommandManager (helper class for working with commands)"
     */
    @Override
    public String toString() {
        return "CommandManager (helper class for working with commands)";
    }
}
