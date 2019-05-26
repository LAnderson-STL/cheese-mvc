package org.launchcode.cheesemvc.models;

public class Cheese {

    //fields
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId = 1;


    public Cheese(String name, String description) {
        //call the default constructor for the given class. must be first. initialize ID field
        this();
        this.name = name;
        this.description = description;

    }

    //default or no-arg contructor.  will initialize cheeseId field. equal to val of nextId field
    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    //getters and setters for cheeseId
    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    //getters and setters for name
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //getters and setters for descriptions
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


}
