package org.joelson.mattias.factoryclicker.model;

public class ResourceCounter {
    
    private final String name;
    private int count;
    
    public ResourceCounter(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
}
