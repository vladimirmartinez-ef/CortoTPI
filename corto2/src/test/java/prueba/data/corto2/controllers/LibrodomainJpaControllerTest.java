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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static prueba.data.corto2.controllers.AlumnodomainJpaControllerTest.mockEmf;
import prueba.data.corto2.entitys.Alumnodomain;
import prueba.data.corto2.entitys.Librodomain;

/**
 *
 * @author kenia
 */
@ExtendWith(MockitoExtension.class)
public class LibrodomainJpaControllerTest {
    EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);

    LibrodomainJpaController cut = new LibrodomainJpaController(mockEmf);

    public LibrodomainJpaControllerTest() {
    }
    

    /**
     * Test of getEntityManager method, of class LibrodomainJpaController.
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
     * Test of create method, of class LibrodomainJpaController.
     */
    @Test
    public void testCreate() throws Exception{
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Librodomain mockR = Mockito.mock(Librodomain.class);
        cut.create(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class LibrodomainJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Librodomain mockR = Mockito.mock(Librodomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class LibrodomainJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Librodomain mockR = Mockito.mock(Librodomain.class);
        Mockito.when(mockEm.getReference(Librodomain.class, 3)).thenReturn(mockR);
        Mockito.when(mockR.getIsbn()).thenReturn(3);
        cut.destroy(3);
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findLibrodomainEntities method, of class LibrodomainJpaController.
     */
    @Test
    public void testFindLibrodomainEntities_0args() {
        System.out.println("findLibrodomainEntities");
        List<Librodomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Alumnodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        Query mockQRY = Mockito.mock(Query.class);
        cut.findLibrodomainEntities();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findLibrodomainEntities method, of class LibrodomainJpaController.
     */
    @Test
    public void testFindLibrodomainEntities_int_int() {
        System.out.println("findLibrodomainEntities");
        List<Alumnodomain> l = Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Alumnodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findLibrodomainEntities(100, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findLibrodomain method, of class LibrodomainJpaController.
     */
    @Test
    public void testFindLibrodomain() {
        System.out.println("findLibrodomain");
       Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Alumnodomain mockR = Mockito.mock(Alumnodomain.class);
        Mockito.when(mockEm.find(Alumnodomain.class, 2)).thenReturn(mockR);
        cut.findLibrodomain(2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
