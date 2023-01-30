package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.abbonamento;
import entities.biglietto;
import enumm.emissione;

public class Main1 {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek");
    public static void main(String[] args) {
        insertAbbonamento(emissione.MENSILE);
        insertAbbonamento(emissione.SETTIMANALE);
    }

    public static void insertAbbonamento(emissione emiss){
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction t = em.getTransaction();
        try {

            abbonamento a= new abbonamento(emiss);

            if(a.getType()==emissione.MENSILE) {
                a.setDataScad(a.getDataEm().plusDays(30));
            }else {
                a.setDataScad(a.getDataEm().plusDays(7));
            }
            t.begin();
            em.persist(a);
            t.commit();
        }finally {
            em.close();
        }
    }
}

