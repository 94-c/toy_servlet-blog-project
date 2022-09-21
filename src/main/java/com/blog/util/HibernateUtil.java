package com.blog.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("blog");
        }catch (Exception e){
            System.out.println("Hibernate Util Error");
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory(){
        try {
            entityManagerFactory.close();
        }catch (Exception e) {
            System.out.println("Close EntityManagerFactory Error");
            e.printStackTrace();
        }
    }
}
