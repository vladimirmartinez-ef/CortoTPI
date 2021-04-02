/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.data.corto2.controllers.exceptions.NonexistentEntityException;
import prueba.data.corto2.controllers.exceptions.PreexistingEntityException;
import prueba.data.corto2.entitys.Prestamohistoricodomain;

/**
 *
 * @author kenia
 */
@ExtendWith(MockitoExtension.class)
public class PrestamohistoricodomainJpaControllerTest {

    EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);

    PrestamohistoricodomainJpaController cut = new PrestamohistoricodomainJpaController(mockEmf);

    public PrestamohistoricodomainJpaControllerTest() {
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
     * Test of getEntityManager method, of class
     * PrestamohistoricodomainJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        cut.getEntityManager();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PrestamohistoricodomainJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Prestamohistoricodomain mockR = Mockito.mock(Prestamohistoricodomain.class);
        cut.create(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
        //error
        try {
            Mockito.doThrow(PreexistingEntityException.class).when(mockEm).persist(Mockito.any());
            //Mockito.when(cut.findPrestamohistoricodomain(Mockito.any())).thenReturn(mockR);
            cut.create(mockR);
        } catch (Exception e) {

        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PrestamohistoricodomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Prestamohistoricodomain mockR = Mockito.mock(Prestamohistoricodomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        //error
        try {
            Mockito.doThrow(NonexistentEntityException.class).when(mockEm).merge(Mockito.any());
            //Mockito.when(cut.findPrestamohistoricodomain(null)).thenReturn(null);
            cut.edit(mockR);

        } catch (Exception e) {

        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PrestamohistoricodomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Prestamohistoricodomain mockR = Mockito.mock(Prestamohistoricodomain.class);
        Mockito.when(mockEm.getReference(Prestamohistoricodomain.class, 1)).thenReturn(mockR);
        Mockito.when(mockR.getIdEjemplar()).thenReturn(1);
        cut.destroy(1);
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());

        try {
            Mockito.doThrow(NonexistentEntityException.class).when(mockEm).remove(Mockito.any());
            cut.destroy(2);
        } catch (Exception e) {

        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findPrestamohistoricodomainEntities method, of class
     * PrestamohistoricodomainJpaController.
     */
    @Test
    public void testFindPrestamohistoricodomainEntities_0args() {
        System.out.println("findPrestamohistoricodomainEntities");
        List<Prestamohistoricodomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Prestamohistoricodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findPrestamohistoricodomainEntities();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findPrestamohistoricodomainEntities method, of class
     * PrestamohistoricodomainJpaController.
     */
    @Test
    public void testFindPrestamohistoricodomainEntities_int_int() {
        System.out.println("findPrestamohistoricodomainEntities");
        List<Prestamohistoricodomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Prestamohistoricodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findPrestamohistoricodomainEntities(100, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findPrestamohistoricodomain method, of class
     * PrestamohistoricodomainJpaController.
     */
    @Test
    public void testFindPrestamohistoricodomain() {
        System.out.println("findPrestamohistoricodomain");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Prestamohistoricodomain mockR = Mockito.mock(Prestamohistoricodomain.class);
        Mockito.when(mockEm.find(Prestamohistoricodomain.class, 2)).thenReturn(mockR);
        cut.findPrestamohistoricodomain(2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
