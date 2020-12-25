/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAO;

import com.example.Model.tbFotos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ListFotosDAO {

    public  List<tbFotos> List() {
        
        //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
        List<tbFotos> usuarios;

        try {
            

            Transaction tx = session.beginTransaction();

            String hql = "from tbFotos";

            usuarios = session.createQuery(hql).list();

            //comita as informacoes
            tx.commit();
            
        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }

        }
        

        return usuarios;
    }

}
