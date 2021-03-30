/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.data.corto2.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prueba.data.corto2.controllers.exceptions.NonexistentEntityException;
import prueba.data.corto2.controllers.exceptions.PreexistingEntityException;
import prueba.data.corto2.entitys.Multadomain;

/**
 *
 * @author edwin
 */
public class MultadomainJpaController implements Serializable {

    public MultadomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Multadomain multadomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(multadomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMultadomain(multadomain.getIdMulta()) != null) {
                throw new PreexistingEntityException("Multadomain " + multadomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Multadomain multadomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            multadomain = em.merge(multadomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = multadomain.getIdMulta();
                if (findMultadomain(id) == null) {
                    throw new NonexistentEntityException("The multadomain with id " + id + " no longer exists.");
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
            Multadomain multadomain;
            try {
                multadomain = em.getReference(Multadomain.class, id);
                multadomain.getIdMulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The multadomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(multadomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Multadomain> findMultadomainEntities() {
        return findMultadomainEntities(true, -1, -1);
    }

    public List<Multadomain> findMultadomainEntities(int maxResults, int firstResult) {
        return findMultadomainEntities(false, maxResults, firstResult);
    }

    private List<Multadomain> findMultadomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Multadomain.class));
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

    public Multadomain findMultadomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Multadomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getMultadomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Multadomain> rt = cq.from(Multadomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
