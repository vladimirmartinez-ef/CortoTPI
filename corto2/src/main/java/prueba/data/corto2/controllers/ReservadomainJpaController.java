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
import prueba.data.corto2.entitys.Reservadomain;

/**
 *
 * @author edwin
 */
public class ReservadomainJpaController implements Serializable {

    public ReservadomainJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reservadomain reservadomain) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reservadomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReservadomain(reservadomain.getIdReserva()) != null) {
                throw new PreexistingEntityException("Reservadomain " + reservadomain + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reservadomain reservadomain) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reservadomain = em.merge(reservadomain);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reservadomain.getIdReserva();
                if (findReservadomain(id) == null) {
                    throw new NonexistentEntityException("The reservadomain with id " + id + " no longer exists.");
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
            Reservadomain reservadomain;
            try {
                reservadomain = em.getReference(Reservadomain.class, id);
                reservadomain.getIdReserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reservadomain with id " + id + " no longer exists.", enfe);
            }
            em.remove(reservadomain);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reservadomain> findReservadomainEntities() {
        return findReservadomainEntities(true, -1, -1);
    }

    public List<Reservadomain> findReservadomainEntities(int maxResults, int firstResult) {
        return findReservadomainEntities(false, maxResults, firstResult);
    }

    private List<Reservadomain> findReservadomainEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reservadomain.class));
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

    public Reservadomain findReservadomain(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reservadomain.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservadomainCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reservadomain> rt = cq.from(Reservadomain.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
