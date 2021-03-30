/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prueba.data.corto2.controller.exceptions.NonexistentEntityException;
import prueba.data.corto2.controller.exceptions.PreexistingEntityException;
import prueba.data.corto2.entitys.Bibliotecariodomain;

/**
 *
 * @author edwin
 */
public class BibliotecariodomainJpaController implements Serializable {

    public BibliotecariodomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bibliotecariodomain bibliotecariodomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bibliotecariodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBibliotecariodomain(bibliotecariodomain.getBibliotecario()) != null) {
                throw new PreexistingEntityException("Bibliotecariodomain " + bibliotecariodomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bibliotecariodomain bibliotecariodomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bibliotecariodomain = em.merge(bibliotecariodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bibliotecariodomain.getBibliotecario();
                if (findBibliotecariodomain(id) == null) {
                    throw new NonexistentEntityException("The bibliotecariodomain with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bibliotecariodomain bibliotecariodomain;
            try {
                bibliotecariodomain = em.getReference(Bibliotecariodomain.class, id);
                bibliotecariodomain.getBibliotecario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bibliotecariodomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(bibliotecariodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bibliotecariodomain> findBibliotecariodomainEntities() {
        return findBibliotecariodomainEntities(true, -1, -1);
    }

    public List<Bibliotecariodomain> findBibliotecariodomainEntities(int maxResults, int firstResult) {
        return findBibliotecariodomainEntities(false, maxResults, firstResult);
    }

    private List<Bibliotecariodomain> findBibliotecariodomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bibliotecariodomain.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Bibliotecariodomain findBibliotecariodomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bibliotecariodomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getBibliotecariodomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bibliotecariodomain> rt = cq.from(Bibliotecariodomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
