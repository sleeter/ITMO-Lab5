package org.example.managers;

import org.example.collections.Organization;
import org.example.collections.OrganizationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

public class CollectionManager {
    private LinkedHashSet<Organization> organizationCollection;
    private final LocalDate creationDate;
    public CollectionManager(){
        organizationCollection = new LinkedHashSet<>();
        creationDate = LocalDate.now();
    }
    /**
     * Get the creation date of the object.
     *
     * @return The creation date of the collection.
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }
    /**
     * This function returns the collection of organizations.
     *
     * @return The LinkedHashSet of Organization objects.
     */
    public LinkedHashSet<Organization> getCollection() {
        return organizationCollection;
    }
    /**
     * The setCollection function sets the organizationCollection field to the value of the
     * organizationCollection parameter.
     *
     * @param organizationCollection The collection of organizations that the user is a member of.
     */
    public void setCollection(LinkedHashSet<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }
    /**
     * Given an id, return the organization with that id
     *
     * @param id The id of the organization to be retrieved.
     * @return the response of right execution.
     */
    public Organization getById(int id){
        for(Organization organization : organizationCollection){
            if(organization.getId() == id)
                return organization;
        }
        return null;
    }
    /**
     * Add an organization to the collection of organizations
     *
     * @param organization The organization to add to the collection.
     */
    public void addToCollection(Organization organization){
        organizationCollection.add(organization);
    }
    /**
     * Remove an organization from the collection
     *
     * @param organization The organization to be removed from the collection.
     */
    public void removeFromCollection(Organization organization){
        organizationCollection.remove(organization);
    }
    /**
     * Remove an organization from the collection if it exists
     *
     * @param id The id of the organization to remove.
     */
    public void removeFromCollectionById(Integer id){
        organizationCollection.removeIf(organization -> Objects.equals(organization.getId(), id));
    }
    /**
     * Clear the collection of all the organizations
     */
    public void clearCollection(){
        organizationCollection.clear();
    }
    /**
     * Given a collection of Organization objects, return the maximum id value of the collection.
     * If the collection is empty, return 0
     *
     * @return The id of the organization that was just added.
     */
    public int generateNewIdForOrganization(){
        Iterator<Organization> iterator = organizationCollection.iterator();
        int id = 0;
        while(iterator.hasNext()){
            Organization organization = iterator.next();
            if(organization.getId()>id)
                id = organization.getId();
        }
        return  id+1;
    }
    /**
     * This function returns a string that contains information about the collection
     *
     * @return The string "Type - " + organizationCollection.getClass() + "\n" +
     *                 "Creation date - " + getCreationDate() + "\n" +
     *                 "Amount of elements - " + organizationCollection.size();
     */
    public String infoAboutCollection(){
        return "Type - " + organizationCollection.getClass() + "\n" +
                "Creation date - " + getCreationDate() + "\n" +
                "Amount of elements - " + organizationCollection.size();
    }
    /**
     * Get all the organization types in the system
     *
     * @return A ArrayList of all the types of organizations in the system.
     */
    public ArrayList<OrganizationType> getAllOrganizationTypes(){
        Iterator<Organization> iterator = organizationCollection.iterator();
        ArrayList<OrganizationType> organizationTypes = new ArrayList<>();
        while (iterator.hasNext()){
            Organization organization = iterator.next();
            if(!organizationTypes.contains(organization.getType()))
                organizationTypes.add(organization.getType());
        }
        return organizationTypes;
    }
}