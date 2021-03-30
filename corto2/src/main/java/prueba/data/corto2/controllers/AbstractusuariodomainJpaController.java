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
import prueba.data.corto2.entitys.Abstractusuariodomain;

/**
 *
 * @author edwin
 */
public class AbstractusuariodomainJpaController implements Serializable {

    public AbstractusuariodomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Abstractusuariodomain abstractusuariodomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(abstractusuariodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAbstractusuariodomain(abstractusuariodomain.getLogin()) != null) {
                throw new PreexistingEntityException("Abstractusuariodomain " + abstractusuariodomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Abstractusuariodomain abstractusuariodomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            abstractusuariodomain = em.merge(abstractusuariodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = abstractusuariodomain.getLogin();
                if (findAbstractusuariodomain(id) == null) {
                    throw new NonexistentEntityException("The abstractusuariodomain with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Abstractusuariodomain abstractusuariodomain;
            try {
                abstractusuariodomain = em.getReference(Abstractusuariodomain.class, id);
                abstractusuariodomain.getLogin();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The abstractusuariodomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(abstractusuariodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Abstractusuariodomain> findAbstractusuariodomainEntities() {
        return findAbstractusuariodomainEntities(true, -1, -1);
    }

    public List<Abstractusuariodomain> findAbstractusuariodomainEntities(int maxResults, int firstResult) {
        return findAbstractusuariodomainEntities(false, maxResults, firstResult);
    }

    private List<Abstractusuariodomain> findAbstractusuariodomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Abstractusuariodomain.class));
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

    public Abstractusuariodomain findAbstractusuariodomain(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Abstractusuariodomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getAbstractusuariodomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Abstractusuariodomain> rt = cq.from(Abstractusuariodomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
