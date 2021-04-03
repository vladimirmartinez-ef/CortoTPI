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
import org.mockito.Mockito;
import static prueba.data.corto2.controllers.PrestamohistoricodomainJpaControllerTest.mockEmf;
import prueba.data.corto2.entitys.Prestamohistoricodomain;
import prueba.data.corto2.entitys.Reservadomain;

/**
 *
 * @author elmer_interiano
 */
public class ReservadomainJpaControllerTest {
    EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);

    ReservadomainJpaController cut = new ReservadomainJpaController(mockEmf);

    /**
     * Test of getEntityManager method, of class ReservadomainJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        cut.getEntityManager();
       // fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ReservadomainJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Reservadomain mockR = Mockito.mock(Reservadomain.class);
        cut.create(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
       // fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ReservadomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Reservadomain mockR = Mockito.mock(Reservadomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ReservadomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Reservadomain mockR = Mockito.mock(Reservadomain.class);
        Mockito.when(mockEm.getReference(Reservadomain.class, 1)).thenReturn(mockR);
        Mockito.when(mockR.getIdReserva()).thenReturn(1);
        cut.destroy(1);
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());

       // fail("The test case is a prototype.");
    }

    /**
     * Test of findReservadomainEntities method, of class ReservadomainJpaController.
     */
    @Test
    public void testFindReservadomainEntities_0args() {
        System.out.println("findReservadomainEntities");
        List<Reservadomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Reservadomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findReservadomainEntities();
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findReservadomainEntities method, of class ReservadomainJpaController.
     */
    @Test
    public void testFindReservadomainEntities_int_int() {
        System.out.println("findReservadomainEntities");
        List<Reservadomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Reservadomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findReservadomainEntities(100,1);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findReservadomain method, of class ReservadomainJpaController.
     */
    @Test
    public void testFindReservadomain() {
        System.out.println("findReservadomain");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Reservadomain mockR = Mockito.mock(Reservadomain.class);
        Mockito.when(mockEm.find(Reservadomain.class, 2)).thenReturn(mockR);
        cut.findReservadomain(2);
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getReservadomainCount method, of class ReservadomainJpaController.
     */
    
}
