package com.collection;

/**
 * Created by dan on 15-6-13.
 */
public class OnlyOverrideEquals implements Cloneable {
    private String name;
    private int age;

    public OnlyOverrideEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OnlyOverrideEquals that = (OnlyOverrideEquals) o;

        if (age != that.age) return false;
        return name.equals(that.name);

    }

    @Override
    public OnlyOverrideEquals clone() throws CloneNotSupportedException {
        return (OnlyOverrideEquals) super.clone();
    }
}
