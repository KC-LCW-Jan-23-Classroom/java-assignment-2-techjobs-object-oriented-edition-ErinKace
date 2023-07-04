package org.launchcode.techjobs.oo.test;

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


}
