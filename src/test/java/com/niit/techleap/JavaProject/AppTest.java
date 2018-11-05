package com.niit.techleap.JavaProject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.niit.ocs.dao.AuthenticationDaoImplTest;
import com.niit.ocs.dao.CredentialsBeanDaoImplTest;
import com.niit.ocs.dao.DoctorDaoImplTest;
import com.niit.ocs.dao.impl.AuthenticationDaoImpl;
import com.niit.ocs.service.AdministratorImplTest;
import com.niit.ocs.service.DoctorBeanServiceImplTest;
import com.niit.ocs.service.PatientServiceImplTest;
import com.niit.ocs.util.AuthenticationImplTest;
import com.niit.ocs.util.UserImplTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AuthenticationDaoImplTest.class,
	CredentialsBeanDaoImplTest.class,
	DoctorDaoImplTest.class,
	AdministratorImplTest.class,
	DoctorBeanServiceImplTest.class,
	PatientServiceImplTest.class,
	AuthenticationImplTest.class,
	UserImplTest.class
})




public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
