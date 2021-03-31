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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
    
}
