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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.data.corto2.entitys.Multadomain;

/**
 *
 * @author kenia
 */
@ExtendWith(MockitoExtension.class)
public class MultadomainJpaControllerTest {

    EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);

    MultadomainJpaController cut = new MultadomainJpaController(mockEmf);

    public MultadomainJpaControllerTest() {
    }

    /**
     * Test of getEntityManager method, of class MultadomainJpaController.
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
     * Test of create method, of class MultadomainJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Multadomain mockR = Mockito.mock(Multadomain.class);
        cut.create(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MultadomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Multadomain mockR = Mockito.mock(Multadomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class MultadomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Multadomain mockR = Mockito.mock(Multadomain.class);
        Mockito.when(mockEm.getReference(Multadomain.class, 3)).thenReturn(mockR);
        Mockito.when(mockR.getIdMulta()).thenReturn(3);
        cut.destroy(3);
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findMultadomainEntities method, of class
     * MultadomainJpaController.
     */
    @Test
    public void testFindMultadomainEntities_0args() {
        System.out.println("findMultadomainEntities");
        List<Multadomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Multadomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        Query mockQRY = Mockito.mock(Query.class);
        cut.findMultadomainEntities();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findMultadomainEntities method, of class
     * MultadomainJpaController.
     */
    @Test
    public void testFindMultadomainEntities_int_int() {
        System.out.println("findMultadomainEntities");
        List<Multadomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Multadomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findMultadomainEntities(100, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findMultadomain method, of class MultadomainJpaController.
     */
    @Test
    public void testFindMultadomain() {
        System.out.println("findMultadomain");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Multadomain mockR = Mockito.mock(Multadomain.class);
        Mockito.when(mockEm.find(Multadomain.class, 2)).thenReturn(mockR);
        cut.findMultadomain(2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
