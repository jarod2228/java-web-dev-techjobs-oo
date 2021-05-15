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
        assertTrue(filledOutJob.getName() == "Product tester");
        assertTrue(filledOutJob.getName() instanceof String);
        assertTrue(filledOutJob.getEmployer().getValue() == "ACME");
        assertTrue(filledOutJob.getEmployer() instanceof Employer);
        assertTrue(filledOutJob.getLocation().getValue() == "Desert");
        assertTrue(filledOutJob.getLocation() instanceof Location);
        assertTrue(filledOutJob.getPositionType().getValue() == "Quality control");
        assertTrue(filledOutJob.getPositionType() instanceof  PositionType);
        assertTrue(filledOutJob.getCoreCompetency().getValue() == "Persistence");
        assertTrue(filledOutJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(filledOutJob.equals(cloneFilledOutJob));
    }

}
