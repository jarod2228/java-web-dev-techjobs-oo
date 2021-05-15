package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

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
        int substringEndingIndexPlusOne = filledOutJob.toString().indexOf('\\');
        String substring = filledOutJob.toString().substring(substringEndingIndexPlusOne -5, - 1);
        assertTrue(filledOutJob.toString().substring(0, 8).equals("ID: _____"));
        assertTrue(substring.equals("_____"));


        /*str.substring for the first 5 characters which should return _____ and the last
        5 characters should also be _____ but how to make that work? It won't just return
        one line for the Id field, it will return the entire object in string form.

        This toString should return the object in its entirety in string form separating
        each field's data with a newline command at the end of the string. Since I know this,
        maybe I should find the indexOf the first occurrence of a newline command, then use
        that to know the index of the second substring which would be the last _____

        NOW you need to make the toString method that passes this test...

        WAIT! THEY PROBABLY MEAN THE _____ JUST AS AN EMPTY SPACE....*/

    }

}
