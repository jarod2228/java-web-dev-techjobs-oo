package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {

    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return this.getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return value;
    }
}
/*
A)
Things the four support classes have in common:
private int id;
private static int nextId = 1;
private String value;
B)
Constructors that are the same:
the id assignment constructor is identical
the value assignment constructor is identical
C)
getters and setters that are the same:
getId()
getValue()
setValue()
D)
custom methods that are the same:
toString()
equals()
hashCode()
*/
