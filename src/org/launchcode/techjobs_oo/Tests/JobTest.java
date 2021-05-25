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
        unfilledJob1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        unfilledJob2 = new Job("Some Kinda Name", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        filledOutJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        cloneFilledOutJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(unfilledJob1.getId(), unfilledJob1.getId());
        assertEquals(unfilledJob1.getId()+1, unfilledJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {;
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
        assertTrue(filledOutJob.toString().contains("\nID: "+filledOutJob.getId()));
        assertTrue(filledOutJob.toString().contains("\nName: Product tester"));
        assertTrue(filledOutJob.toString().contains("\nEmployer: ACME"));
        assertTrue(filledOutJob.toString().contains("\nLocation: Desert"));
        assertTrue(filledOutJob.toString().contains("\nPosition Type: Quality control"));
        assertTrue(filledOutJob.toString().contains("\nCore Competency: Persistence"));

    }

    @Test
    public void testEmptyFieldsShowUpAsDataNotAvailable() {
        //The id will never be empty, so no need to put that?
        assertTrue(unfilledJob2.toString().contains("Name: Some Kinda Name"));
        assertTrue(unfilledJob2.toString().contains("Employer: Data not available"));
        assertTrue(unfilledJob2.toString().contains("Location: Data not available"));
        assertTrue(unfilledJob2.toString().contains("Position Type: Data not available"));
        assertTrue(unfilledJob2.toString().contains("Core Competency: Data not available"));

    }
    @Test
    public void testingTheOops() {
        assertEquals("OOPS! This job does not seem to exist.", unfilledJob1.toString());
    }

}
