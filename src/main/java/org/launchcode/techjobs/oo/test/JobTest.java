package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.junit.Assert;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    public Job testJob;
    public Job testJobA;
    public Job testJobB;
    public String testJobExpectedString;
    public String testJobAExpectedString;
    public String testJobBExpectedString;
    @Before
    public void setUpTestJobs() {
        this.testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        this.testJobA = new Job("Totally Real Job", new Employer("Business"), new Location(""), new PositionType(""), new CoreCompetency(""));
        this.testJobB = new Job();

        this.testJobExpectedString = "\n"+
                "ID: "+testJob.getId()+"\n"+
                "Name: Product tester"+"\n"+
                "Employer: ACME"+"\n"+
                "Location: Desert"+"\n"+
                "Position Type: Quality control"+"\n"+
                "Core Competency: Persistence"+"\n";
        this.testJobAExpectedString = "\n"+
                "ID: "+testJobA.getId()+"\n"+
                "Name: Totally Real Job"+"\n"+
                "Employer: Business"+"\n"+
                "Location: Data not available"+"\n"+
                "Position Type: Data not available"+"\n"+
                "Core Competency: Data not available"+"\n";
    }
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        Assert.assertNotEquals(testJob1,testJob2);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(testJob3 instanceof Job);
        Assert.assertTrue(testJob3.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob3.getLocation() instanceof Location);
        Assert.assertTrue(testJob3.getPositionType() instanceof PositionType);
        Assert.assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals("Product tester", testJob3.getName());
        Assert.assertEquals("ACME", testJob3.getEmployer().getValue());
        Assert.assertEquals("Desert", testJob3.getLocation().getValue());
        Assert.assertEquals("Quality control", testJob3.getPositionType().getValue());
        Assert.assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job testJob4 = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Testing"));
        Job testJob5 = new Job("Test Job", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Position"), new CoreCompetency("Testing"));
        Assert.assertFalse(testJob4.equals(testJob5));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = testJob6.toString();
        char firstChar = testString.charAt(0);
        char lastChar = testString.charAt(testString.length()-1);
        Assert.assertEquals('\n', firstChar);
        Assert.assertEquals('\n', lastChar);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testJobCExpectedString = "\n"+
                "ID: "+testJobC.getId()+"\n"+
                "Name: Product tester"+"\n"+
                "Employer: ACME"+"\n"+
                "Location: Desert"+"\n"+
                "Position Type: Quality control"+"\n"+
                "Core Competency: Persistence"+"\n";
        Assert.assertEquals(testJobCExpectedString, testJobC.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job testJobD = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobF = new Job();
        String testJobDExpectedString = "\n"+
                "ID: "+testJobD.getId()+"\n"+
                "Name: Product tester"+"\n"+
                "Employer: ACME"+"\n"+
                "Location: Desert"+"\n"+
                "Position Type: Quality control"+"\n"+
                "Core Competency: Persistence"+"\n";
        Assert.assertEquals(testJobDExpectedString, testJobD.toString());
        Assert.assertEquals("OOPS! This job does not seem to exist.", testJobF.toString());
    }

}
