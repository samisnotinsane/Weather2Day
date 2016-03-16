/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author sameenislam
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({app.MainMenuControllerTest.class, app.DaylightControllerTest.class, app.RiskControllerTest.class, app.VisibilityControllerTest.class, app.TemperatureControllerTest.class, app.res.ResSuite.class, app.MainTest.class, app.PrecipitationControllerTest.class, app.CrosswindsControllerTest.class})
public class AppSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
