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
import prueba.data.corto2.entitys.Ejemplardomain;

/**
 *
 * @author edwin
 */
public class EjemplardomainJpaController implements Serializable {

    public EjemplardomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ejemplardomain ejemplardomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ejemplardomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEjemplardomain(ejemplardomain.getIdEjemplar()) != null) {
                throw new PreexistingEntityException("Ejemplardomain " + ejemplardomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ejemplardomain ejemplardomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ejemplardomain = em.merge(ejemplardomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ejemplardomain.getIdEjemplar();
                if (findEjemplardomain(id) == null) {
                    throw new NonexistentEntityException("The ejemplardomain with id " + id + " no longer exists.");
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
            Ejemplardomain ejemplardomain;
            try {
                ejemplardomain = em.getReference(Ejemplardomain.class, id);
                ejemplardomain.getIdEjemplar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ejemplardomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(ejemplardomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ejemplardomain> findEjemplardomainEntities() {
        return findEjemplardomainEntities(true, -1, -1);
    }

    public List<Ejemplardomain> findEjemplardomainEntities(int maxResults, int firstResult) {
        return findEjemplardomainEntities(false, maxResults, firstResult);
    }

    private List<Ejemplardomain> findEjemplardomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ejemplardomain.class));
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

    public Ejemplardomain findEjemplardomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ejemplardomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getEjemplardomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ejemplardomain> rt = cq.from(Ejemplardomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
