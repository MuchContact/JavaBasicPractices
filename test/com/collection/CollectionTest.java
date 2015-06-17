package com.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by dan on 15-6-13.
 */
public class CollectionTest {

    private final OnlyOverrideEquals equalsOne;
    private final OnlyOverrideEquals equalsTwo;
    private final OverrideEqualsAndHashcode equalsAndHashcodeOne;
    private final OverrideEqualsAndHashcode equalsAndHashcodeTwo;

    public CollectionTest() throws CloneNotSupportedException {
        String name = "Li Lei";
        int age = 20;
        equalsOne = new OnlyOverrideEquals(name, age);
        equalsTwo = equalsOne.clone();
        equalsAndHashcodeOne = new OverrideEqualsAndHashcode(name, age);
        equalsAndHashcodeTwo = equalsAndHashcodeOne.clone();
    }

    @Test
    public void shouldTwoEqualObjectsHaveDifferentHashCode() throws Exception {
        Assert.assertEquals(equalsOne, equalsTwo);
        Assert.assertNotEquals(equalsOne.hashCode(), equalsTwo.hashCode());
    }

    @Test
    public void shouldTwoEqualObjectsWithDifferentHashcodeCoexitInSet() throws Exception {
        HashSet<OnlyOverrideEquals> set = new HashSet<>();
        set.add(equalsOne);
        set.add(equalsTwo);
        Assert.assertEquals(2, set.size());
    }

    @Test
    public void shouldTwoEqualObjectsWithSameHashcodeNotCoexitInSet() throws Exception {
        HashSet<OverrideEqualsAndHashcode> set = new HashSet<>();
        set.add(equalsAndHashcodeOne);
        set.add(equalsAndHashcodeTwo);
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void shouldTwoEqualObjectsHaveSameHashCode() throws Exception {
        Assert.assertEquals(equalsAndHashcodeOne, equalsAndHashcodeTwo);
        Assert.assertEquals(equalsAndHashcodeOne.hashCode(), equalsAndHashcodeTwo.hashCode());
    }
}
