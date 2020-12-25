/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAO;

import com.example.Model.tbFotos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetFotoDAO {
    
    public tbFotos getUsuario(int id){
        
                //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
        tbFotos usuarios;
        try {

            Transaction tx = session.beginTransaction();

            usuarios = (tbFotos) session.get(tbFotos.class, id);

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
