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
import static prueba.data.corto2.controllers.PrestamohistoricodomainJpaControllerTest.mockEmf;
import prueba.data.corto2.entitys.Prestamohistoricodomain;
import prueba.data.corto2.entitys.Profesordomain;

/**
 *
 * @author elmer_interiano
 */
@ExtendWith(MockitoExtension.class)
public class ProfesordomainJpaControllerTest {
    EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);

    ProfesordomainJpaController cut = new ProfesordomainJpaController(mockEmf);

    /**
     * Test of getEntityManager method, of class ProfesordomainJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        cut.getEntityManager();

        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ProfesordomainJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Profesordomain mockR = Mockito.mock(Profesordomain.class);
        cut.create(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ProfesordomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Profesordomain mockR = Mockito.mock(Profesordomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ProfesordomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Profesordomain mockR = Mockito.mock(Profesordomain.class);
        Mockito.when(mockEm.getReference(Profesordomain.class, 1)).thenReturn(mockR);
        Mockito.when(mockR.getIdProfesor()).thenReturn(1);
        cut.destroy(1);
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());

        //fail("The test case is a prototype.");
    }

    /**
     * Test of findProfesordomainEntities method, of class ProfesordomainJpaController.
     */
    @Test
    public void testFindProfesordomainEntities_0args() {
        System.out.println("findProfesordomainEntities");
        List<Profesordomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Profesordomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findProfesordomainEntities();
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findProfesordomainEntities method, of class ProfesordomainJpaController.
     */
    @Test
    public void testFindProfesordomainEntities_int_int() {
        System.out.println("findProfesordomainEntities");
        List<Profesordomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Profesordomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findProfesordomainEntities(100, 1);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findProfesordomain method, of class ProfesordomainJpaController.
     */
    @Test
    public void testFindProfesordomain() {
        System.out.println("findProfesordomain");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Profesordomain mockR = Mockito.mock(Profesordomain.class);
        Mockito.when(mockEm.find(Profesordomain.class, 2)).thenReturn(mockR);
        cut.findProfesordomain(2);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProfesordomainCount method, of class ProfesordomainJpaController.
     */

    
}
