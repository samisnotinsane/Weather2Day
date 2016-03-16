/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sameenislam
 */
public class MainMenuControllerTest {
    
    public MainMenuControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of btnQuitHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnQuitHandler() {
        System.out.println("btnQuitHandler");
        MainMenuController instance = new MainMenuController();
        instance.btnQuitHandler();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnTempHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnTempHandler() throws Exception {
        System.out.println("btnTempHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnTempHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnCrwHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnCrwHandler() throws Exception {
        System.out.println("btnCrwHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnCrwHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnRiskHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnRiskHandler() throws Exception {
        System.out.println("btnRiskHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnRiskHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnDaylHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnDaylHandler() throws Exception {
        System.out.println("btnDaylHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnDaylHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnVisHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnVisHandler() throws Exception {
        System.out.println("btnVisHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnVisHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of btnPrecHandler method, of class MainMenuController.
     */
    @Test
    public void testBtnPrecHandler() throws Exception {
        System.out.println("btnPrecHandler");
        ActionEvent event = null;
        MainMenuController instance = new MainMenuController();
        instance.btnPrecHandler(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class MainMenuController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL location = null;
        ResourceBundle resources = null;
        MainMenuController instance = new MainMenuController();
        instance.initialize(location, resources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
