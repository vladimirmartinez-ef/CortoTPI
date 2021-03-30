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
import prueba.data.corto2.entitys.Profesordomain;

/**
 *
 * @author edwin
 */
public class ProfesordomainJpaController implements Serializable {

    public ProfesordomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesordomain profesordomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(profesordomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProfesordomain(profesordomain.getIdProfesor()) != null) {
                throw new PreexistingEntityException("Profesordomain " + profesordomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesordomain profesordomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            profesordomain = em.merge(profesordomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profesordomain.getIdProfesor();
                if (findProfesordomain(id) == null) {
                    throw new NonexistentEntityException("The profesordomain with id " + id + " no longer exists.");
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
            Profesordomain profesordomain;
            try {
                profesordomain = em.getReference(Profesordomain.class, id);
                profesordomain.getIdProfesor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesordomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(profesordomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profesordomain> findProfesordomainEntities() {
        return findProfesordomainEntities(true, -1, -1);
    }

    public List<Profesordomain> findProfesordomainEntities(int maxResults, int firstResult) {
        return findProfesordomainEntities(false, maxResults, firstResult);
    }

    private List<Profesordomain> findProfesordomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesordomain.class));
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

    public Profesordomain findProfesordomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesordomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesordomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesordomain> rt = cq.from(Profesordomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
