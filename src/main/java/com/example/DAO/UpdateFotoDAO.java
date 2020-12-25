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

public class UpdateFotoDAO {

    public boolean updateUsuario(tbFotos usuario) {

        //GRAVAR NO BANCO
        //indica as configuracoes do banco
        //PODE SER USAR MAIS DE UMA CLASSE SEPARANDO POR VIRGULAS NO tbPauta.class,tb...
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();

        try {

            //inicia a transacao com o banco
            Transaction tx = session.beginTransaction();
            session.update(usuario);

            //comita as informacoes
            tx.commit();

        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }
        }
        
        return  true;

    }

}
