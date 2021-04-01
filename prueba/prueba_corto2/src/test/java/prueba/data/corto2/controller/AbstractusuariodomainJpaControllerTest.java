/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
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
import prueba.data.corto2.controller.exceptions.PreexistingEntityException;
import prueba.data.corto2.entitys.Abstractusuariodomain;

/**
 *
 * @author vladimir
 */
@ExtendWith(MockitoExtension.class)
public class AbstractusuariodomainJpaControllerTest {
    
     EntityManager mockEm = Mockito.mock(EntityManager.class);
    EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
    final static EntityManagerFactory mockEmf = Mockito.mock(EntityManagerFactory.class);
    
    AbstractusuariodomainJpaController cut = new AbstractusuariodomainJpaController(mockEmf);
    
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
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        cut.getEntityManager();
        // TODO review the generated test code and remove the default call to fail.
       // fail("Dara error por que asi dice aqui");
    }
    
     @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Abstractusuariodomain r = new Abstractusuariodomain();
        r.setLogin("1");
        r.setNombre("nombre");
        r.setApellido1("apellido1");
        r.setApellido2("apellido2");
        r.setEmail("email@hello.com");
        r.setPassword("hhs3dvdf3");
        r.setEstadoUsuario(Short.parseShort("1"));
        r.setCiudad("ciudad");
        r.setDireccion("direccon");
        r.setCodigoPostal(3);
        //Abstractusuariodomain mockR = Mockito.mock(Abstractusuariodomain.class);
        cut.create(r);
        Mockito.verify(mockEm, Mockito.times(1)).persist(Mockito.any());
        //error exception
        try{
            Mockito.doThrow(PreexistingEntityException.class).when(mockEm).persist(Mockito.any());
            Mockito.when(cut.findAbstractusuariodomain(Mockito.any())).thenReturn(r);
            cut.create(r);
        }catch(Exception e){
            
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("Dara error por que asi dice aqui");
    }
    
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Abstractusuariodomain mockR = Mockito.mock(Abstractusuariodomain.class);
        cut.edit(mockR);
        Mockito.verify(mockEm, Mockito.times(1)).merge(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("Dara error por que asi dice aqui");
    }
    
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTX);
        Abstractusuariodomain mockR = Mockito.mock(Abstractusuariodomain.class);
        Mockito.when(mockEm.getReference(Abstractusuariodomain.class, "user")).thenReturn(mockR);
        Mockito.when(mockR.getLogin()).thenReturn("user");
        cut.destroy("user");
        Mockito.verify(mockEm, Mockito.times(1)).remove(Mockito.any());
        // TODO review the generated test code and remove the default call to fail.
        //fail("Dara error por que asi dice aqui");
    }
    
    @Test
    public void testFindAbstractusuariodomainEntities() throws Exception{
        System.out.println("findAbstractusuariodomainEntities");
        List<Abstractusuariodomain> l= Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ= Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR= Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Abstractusuariodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        Query mockQRY= Mockito.mock(Query.class);
        cut.findAbstractusuariodomainEntities();
    }
    
   
   @Test
    public void testFindAbstractusuariodomainEntities_int_int() throws Exception{
        System.out.println("findAbstractusuariodomainEntities_int_int");
        List<Abstractusuariodomain> l= Mockito.mock(List.class);
        Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
        CriteriaQuery mockCRQ= Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCRBDR= Mockito.mock(CriteriaBuilder.class);
        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
        Root mockROOT = Mockito.mock(Root.class);
        Mockito.when(mockCRQ.from(Abstractusuariodomain.class)).thenReturn(mockROOT);
        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
        cut.findAbstractusuariodomainEntities(100, 1);
    }  
    
   @Test
   public void testFindAbstractusuariodomain(){
       System.out.println("findAbstractusuariodomain");
       Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
       Abstractusuariodomain mockR= Mockito.mock(Abstractusuariodomain.class);
       Mockito.when(mockEm.find(Abstractusuariodomain.class, "hola")).thenReturn(mockR);
       cut.findAbstractusuariodomain("hola");
   }
   
   @Test
   public void testGetAbstractusuariodomainCount(){
//       System.out.println("getAbstractusuariodomainCount");
//       Mockito.when(cut.getEntityManager()).thenReturn(mockEm);
//       CriteriaQuery mockCRQ= Mockito.mock(CriteriaQuery.class);
//        CriteriaBuilder mockCRBDR= Mockito.mock(CriteriaBuilder.class);
//        Mockito.when(mockEm.getCriteriaBuilder()).thenReturn(mockCRBDR);
//        Mockito.when(mockCRBDR.createQuery()).thenReturn(mockCRQ);
//        Root<Abstractusuariodomain> mockROOT = Mockito.mock(Root.class);
//        Mockito.when(mockCRQ.from(Abstractusuariodomain.class)).thenReturn(mockROOT);
//        Expression mockEXP= Mockito.mock(Expression.class);
//        Mockito.when(mockCRBDR.count(mockROOT)).thenReturn(mockEXP);
//        
//        Mockito.when(mockCRQ.select(mockEXP)).thenReturn(mockCRQ);
//        TypedQuery mockQR = Mockito.mock(TypedQuery.class);
//        Mockito.when(mockEm.createQuery(mockCRQ)).thenReturn(mockQR);
//        Query mockQRY= Mockito.mock(Query.class);
//        Object mockOBJ= Mockito.mock(Object.class);
//        Mockito.when(((Long) mockQR.getSingleResult()).intValue()).thenReturn(25);
//        cut.getAbstractusuariodomainCount();
   }
    
}
