package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static java.lang.Character.isWhitespace;
import static org.junit.Assert.*;

public class JobTest {
    Job unfilledJob1;
    Job unfilledJob2;
    Job filledOutJob;
    Job cloneFilledOutJob;
    @Before
    public void createTwoJobs() {
        unfilledJob1 = new Job();
        unfilledJob2 = new Job();
        filledOutJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        cloneFilledOutJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(unfilledJob1.getId(), unfilledJob1.getId());
        assertEquals(unfilledJob1.getId()+1, unfilledJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(filledOutJob.getName().equals("Product tester"));
        assertTrue(filledOutJob.getName() instanceof String);
        assertTrue(filledOutJob.getEmployer().getValue().equals("ACME"));
        assertTrue(filledOutJob.getEmployer() instanceof Employer);
        assertTrue(filledOutJob.getLocation().getValue().equals("Desert"));
        assertTrue(filledOutJob.getLocation() instanceof Location);
        assertTrue(filledOutJob.getPositionType().getValue().equals("Quality control"));
        assertTrue(filledOutJob.getPositionType() instanceof  PositionType);
        assertTrue(filledOutJob.getCoreCompetency().getValue().equals("Persistence"));
        assertTrue(filledOutJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(filledOutJob.equals(cloneFilledOutJob));
    }

    @Test
    public void testToStringIdField() {
        assertTrue(Character.isWhitespace(filledOutJob.toString().charAt(0)));
        assertTrue(Character.isWhitespace(filledOutJob.toString().charAt(filledOutJob.toString().length()-1)));
    }
    @Test
    public void testStringHasLabelsBeforeDataAndNewlines() {
        assertTrue(filledOutJob.toString().contains("\nID: "));
        assertTrue(filledOutJob.toString().contains("\nName: Product tester"));
        assertTrue(filledOutJob.toString().contains("\nEmployer: ACME"));
        assertTrue(filledOutJob.toString().contains("\nLocation: Desert"));
        assertTrue(filledOutJob.toString().contains("\nPosition Type: Quality control"));
        assertTrue(filledOutJob.toString().contains("\nCore Competency: Persistence"));

    }

    @Test
    public void testEmptyFieldsShowUpAsDataNotAvailable() {
        assertTrue(unfilledJob1.toString().contains("Name: Data not available"));
    }

}
