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
        job2 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
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
        boolean check_Employer = test_Job.getEmployer().toString().contentEquals("ACME");
        boolean check_Location = test_Job.getLocation().toString().contentEquals("Desert");
        boolean check_PositionType = test_Job.getPositionType().toString().contentEquals("Quality control");
        boolean check_CoreCompetency = test_Job.getCoreCompetency().toString().contentEquals("Persistence");

        assertTrue(check_Name);
        assertTrue(check_Employer);
        assertTrue(check_Location);
        assertTrue(check_PositionType);
        assertTrue(check_CoreCompetency);
    }

    @Test
    public void testJobConstructorMatchesClasses() {
        Job test_Job = job1;

        boolean check_Employer_Class = test_Job.getEmployer() instanceof Employer;
        boolean check_Location_Class = test_Job.getLocation() instanceof Location;
        boolean check_PositionType_Class = test_Job.getPositionType() instanceof PositionType;
        boolean check_CoreCompetency_Class = test_Job.getCoreCompetency() instanceof CoreCompetency;

        assertTrue(check_Employer_Class);
        assertTrue(check_Location_Class);
        assertTrue(check_PositionType_Class);
        assertTrue(check_CoreCompetency_Class);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringForOpeningBlankLine() {
        String testJob = job1.toString();

        assertEquals("\n", testJob.substring(0,1));
    }

    @Test
    public void testToStringForClosingBlankLine() {
        String testJob = job1.toString();

        assertEquals("\n", testJob.substring(testJob.length() - 1));
    }

    @Test
    public void testForIdLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("ID: 1"));
    }

    @Test
    public void testForNameLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("Name: Product tester"));
    }

    @Test
    public void testForEmployerLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("Employer: ACME"));
    }

    @Test
    public void testForLocationLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("Location: Desert"));
    }

    @Test
    public void testForPositionTypeLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("Position Type: Quality control"));
    }

    @Test
    public void testForCoreCompetencyLabelAndData() {
        String testJob = job1.toString();

        assertTrue(testJob.contains("Core Competency: Persistence"));
    }

    @Test
    public void testForEmptyNameField() {
        Job testJob = new Job("", new Employer("LaunchCode"), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        String testString = testJob.toString();

        assertTrue(testString.contains("Name: Data not available"));
    }

    @Test
    public void testForEmptyEmployerField() {
        Job testJob = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));

        String testString = testJob.toString();

        assertTrue(testString.contains("Employer: Data not available"));
    }

    @Test
    public void testForEmptyLocationField() {
        Job testJob = new Job("Ice cream taster", new Employer("LaunchCode"), new Location(""), new PositionType("UX"), new CoreCompetency("Taste"));

        String testString = testJob.toString();

        assertTrue(testString.contains("Location: Data not available"));
    }

    @Test
    public void testForEmptyPositionTypeField() {
        Job testJob = new Job("Ice cream taster", new Employer("LaunchCode"), new Location("Home"), new PositionType(""), new CoreCompetency("Taste"));
        String testString = testJob.toString();

        assertTrue(testString.contains("Position Type: Data not available"));
    }

    @Test
    public void testForEmptyCoreCompetencyField() {
        Job testJob = new Job("Ice cream taster", new Employer("LaunchCode"), new Location("Home"), new PositionType("UX"), new CoreCompetency(""));
        String testString = testJob.toString();

        assertTrue(testString.contains("Core Competency: Data not available"));
    }
}
