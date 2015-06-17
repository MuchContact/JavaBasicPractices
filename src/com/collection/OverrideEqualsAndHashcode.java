package com.collection;

/**
 * Created by dan on 15-6-13.
 */
public class OverrideEqualsAndHashcode implements Cloneable {
    private String name;
    private int age;

    public OverrideEqualsAndHashcode(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OverrideEqualsAndHashcode that = (OverrideEqualsAndHashcode) o;

        if (age != that.age) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public OverrideEqualsAndHashcode clone() throws CloneNotSupportedException {
        return (OverrideEqualsAndHashcode) super.clone();
    }
}
