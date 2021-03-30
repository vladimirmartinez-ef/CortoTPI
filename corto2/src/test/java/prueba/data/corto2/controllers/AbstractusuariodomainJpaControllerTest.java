/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.controllers;

import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.data.corto2.entitys.Abstractusuariodomain;


/**
 *
 * @author kenia
 */
@ExtendWith(MockitoExtension.class)
public class AbstractusuariodomainJpaControllerTest {
    
    public AbstractusuariodomainJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        AbstractusuariodomainJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Abstractusuariodomain abstractusuariodomain = null;
        AbstractusuariodomainJpaController instance = null;
        instance.create(abstractusuariodomain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Abstractusuariodomain abstractusuariodomain = null;
        AbstractusuariodomainJpaController instance = null;
        instance.edit(abstractusuariodomain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        String id = "";
        AbstractusuariodomainJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAbstractusuariodomainEntities method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testFindAbstractusuariodomainEntities_0args() {
        System.out.println("findAbstractusuariodomainEntities");
        AbstractusuariodomainJpaController instance = null;
        List<Abstractusuariodomain> expResult = null;
        List<Abstractusuariodomain> result = instance.findAbstractusuariodomainEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAbstractusuariodomainEntities method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testFindAbstractusuariodomainEntities_int_int() {
        System.out.println("findAbstractusuariodomainEntities");
        int maxResults = 0;
        int firstResult = 0;
        AbstractusuariodomainJpaController instance = null;
        List<Abstractusuariodomain> expResult = null;
        List<Abstractusuariodomain> result = instance.findAbstractusuariodomainEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAbstractusuariodomain method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testFindAbstractusuariodomain() {
        System.out.println("findAbstractusuariodomain");
        String id = "";
        AbstractusuariodomainJpaController instance = null;
        Abstractusuariodomain expResult = null;
        Abstractusuariodomain result = instance.findAbstractusuariodomain(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbstractusuariodomainCount method, of class AbstractusuariodomainJpaController.
     */
    @Test
    public void testGetAbstractusuariodomainCount() {
        System.out.println("getAbstractusuariodomainCount");
        AbstractusuariodomainJpaController instance = null;
        int expResult = 0;
        int result = instance.getAbstractusuariodomainCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
