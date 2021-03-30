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
import prueba.data.corto2.entitys.Librodomain;

/**
 *
 * @author edwin
 */
public class LibrodomainJpaController implements Serializable {

    public LibrodomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Librodomain librodomain) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(librodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Librodomain librodomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            librodomain = em.merge(librodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = librodomain.getIsbn();
                if (findLibrodomain(id) == null) {
                    throw new NonexistentEntityException("The librodomain with id " + id + " no longer exists.");
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
            Librodomain librodomain;
            try {
                librodomain = em.getReference(Librodomain.class, id);
                librodomain.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The librodomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(librodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Librodomain> findLibrodomainEntities() {
        return findLibrodomainEntities(true, -1, -1);
    }

    public List<Librodomain> findLibrodomainEntities(int maxResults, int firstResult) {
        return findLibrodomainEntities(false, maxResults, firstResult);
    }

    private List<Librodomain> findLibrodomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Librodomain.class));
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

    public Librodomain findLibrodomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Librodomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibrodomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Librodomain> rt = cq.from(Librodomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
