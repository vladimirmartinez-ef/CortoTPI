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
import prueba.data.corto2.entitys.Prestamohistoricodomain;

/**
 *
 * @author edwin
 */
public class PrestamohistoricodomainJpaController implements Serializable {

    public PrestamohistoricodomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prestamohistoricodomain prestamohistoricodomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(prestamohistoricodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPrestamohistoricodomain(prestamohistoricodomain.getIdEjemplar()) != null) {
                throw new PreexistingEntityException("Prestamohistoricodomain " + prestamohistoricodomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prestamohistoricodomain prestamohistoricodomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            prestamohistoricodomain = em.merge(prestamohistoricodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = prestamohistoricodomain.getIdEjemplar();
                if (findPrestamohistoricodomain(id) == null) {
                    throw new NonexistentEntityException("The prestamohistoricodomain with id " + id + " no longer exists.");
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
            Prestamohistoricodomain prestamohistoricodomain;
            try {
                prestamohistoricodomain = em.getReference(Prestamohistoricodomain.class, id);
                prestamohistoricodomain.getIdEjemplar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestamohistoricodomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(prestamohistoricodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prestamohistoricodomain> findPrestamohistoricodomainEntities() {
        return findPrestamohistoricodomainEntities(true, -1, -1);
    }

    public List<Prestamohistoricodomain> findPrestamohistoricodomainEntities(int maxResults, int firstResult) {
        return findPrestamohistoricodomainEntities(false, maxResults, firstResult);
    }

    private List<Prestamohistoricodomain> findPrestamohistoricodomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prestamohistoricodomain.class));
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

    public Prestamohistoricodomain findPrestamohistoricodomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prestamohistoricodomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestamohistoricodomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestamohistoricodomain> rt = cq.from(Prestamohistoricodomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
