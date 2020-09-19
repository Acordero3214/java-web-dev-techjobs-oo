package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    private Job job1;
    private Job job2;

    @Before
    public void initJobs() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        int retVal = job2.getId() - job1.getId();
        assertEquals(1, retVal, 0.0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_Job = job1;

        boolean check_Name = test_Job.getName().contentEquals("Product tester");

        boolean check_Employer_Class = test_Job.getEmployer() instanceof Employer;
        boolean check_Employer = test_Job.getEmployer().toString().contentEquals("ACME");

        boolean check_Location_Class = test_Job.getLocation() instanceof Location;
        boolean check_Location = test_Job.getLocation().toString().contentEquals("Desert");

        boolean check_PositionType_Class = test_Job.getPositionType() instanceof PositionType;
        boolean check_PositionType = test_Job.getPositionType().toString().contentEquals("Quality control");

        boolean check_CoreCompetency_Class = test_Job.getCoreCompetency() instanceof CoreCompetency;
        boolean check_CoreCompetency = test_Job.getCoreCompetency().toString().contentEquals("Persistence");

        assertTrue(check_Name);

        assertTrue(check_Employer_Class);
        assertTrue(check_Employer);

        assertTrue(check_Location_Class);
        assertTrue(check_Location);

        assertTrue(check_PositionType_Class);
        assertTrue(check_PositionType);

        assertTrue(check_CoreCompetency_Class);
        assertTrue(check_CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }
}
