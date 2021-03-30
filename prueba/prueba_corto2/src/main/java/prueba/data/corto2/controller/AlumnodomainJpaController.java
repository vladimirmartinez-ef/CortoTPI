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
import prueba.data.corto2.entitys.Alumnodomain;

/**
 *
 * @author edwin
 */
public class AlumnodomainJpaController implements Serializable {

    public AlumnodomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumnodomain alumnodomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumnodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumnodomain(alumnodomain.getIdAlumno()) != null) {
                throw new PreexistingEntityException("Alumnodomain " + alumnodomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumnodomain alumnodomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alumnodomain = em.merge(alumnodomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alumnodomain.getIdAlumno();
                if (findAlumnodomain(id) == null) {
                    throw new NonexistentEntityException("The alumnodomain with id " + id + " no longer exists.");
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
            Alumnodomain alumnodomain;
            try {
                alumnodomain = em.getReference(Alumnodomain.class, id);
                alumnodomain.getIdAlumno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnodomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(alumnodomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumnodomain> findAlumnodomainEntities() {
        return findAlumnodomainEntities(true, -1, -1);
    }

    public List<Alumnodomain> findAlumnodomainEntities(int maxResults, int firstResult) {
        return findAlumnodomainEntities(false, maxResults, firstResult);
    }

    private List<Alumnodomain> findAlumnodomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumnodomain.class));
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

    public Alumnodomain findAlumnodomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumnodomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnodomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumnodomain> rt = cq.from(Alumnodomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
