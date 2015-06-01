/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.univasf.hu.planejamento.crud;

import com.br.univasf.hu.planejamento.Indicador;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Danillo
 */
@Stateless
public class ControleIndicadorBean implements ControleIndicadorInterface{

    @PersistenceContext
    private EntityManager gerenciador;//nao é nulo
    
    @Override
    public boolean adicionar(Indicador indicador) {
      
      boolean sucesso;
        try
        {
            gerenciador.persist(indicador);
            sucesso=true;
        }
        catch(Exception e)
        {
            sucesso=false;
            e.printStackTrace();
        }
       return sucesso;  }

    @Override
    public boolean editar(Indicador indicador) {
     boolean sucesso;
        try
        {
            gerenciador.merge(indicador);
            sucesso=true;
        }
        catch(Exception e)
        {
            sucesso=false;
            e.printStackTrace();
        }
       return sucesso;  }

    @Override
    public List<Indicador> findAll() {
      //Query pesquisa=gerenciador.createQuery("SELECT o FROM Obra o left join fetch o.autores");
       try
       {
           
           Query pesquisa=gerenciador.createNamedQuery("Indicador.findAll");
           return pesquisa.getResultList();
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return new ArrayList();//lista vazia se algum erro ocorrer
           
       }
    }

    @Override
    public List<Indicador> findSimilar(String value) {
     try
            {
                Query pesquisa=gerenciador.createNamedQuery("Indicador.findSimilar");
                pesquisa.setParameter("nome","%"+value+"%");
                return pesquisa.getResultList();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return new ArrayList<Indicador>();//generico vazio se algum erro ocorrer

            } 
    }

    @Override
    public List<Indicador> findByName(String value) {
     try
            {
                Query pesquisa=gerenciador.createNamedQuery("Indicador.findByName");
                pesquisa.setParameter("nome",value);
                return pesquisa.getResultList();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return new ArrayList<Indicador>();//generico vazio se algum erro ocorrer

            } 
    }

    @Override
    public Indicador findSpecific(Indicador indicador) {
        //Query pesquisa=gerenciador.createQuery("SELECT o FROM Obra o left join fetch o.autores");
       try
       {
           Query pesquisa=gerenciador.createNamedQuery("Indicador.findSpecific");
           pesquisa.setParameter("id",indicador.getId());
           return (Indicador) pesquisa.getSingleResult();
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return new Indicador();//generico vazio se algum erro ocorrer
           
       }
       
    }

    @Override
    public boolean excluir(Indicador indicador) {
      boolean sucesso;
        try
        {
            indicador =gerenciador.find(Indicador.class, indicador.getId());
            gerenciador.remove(indicador);
            sucesso=true;
        }
        catch(Exception e)
        {
            sucesso=false;
        }
       return sucesso;
    }

    @Override
    public Indicador findWithId(Long id) {
         //Query pesquisa=gerenciador.createQuery("SELECT o FROM Obra o left join fetch o.autores");
       try
       {
           Query pesquisa=gerenciador.createNamedQuery("Indicador.findSpecific");
           pesquisa.setParameter("id",id);
           return (Indicador) pesquisa.getSingleResult();
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return new Indicador();//generico vazio se algum erro ocorrer
           
       }
        
    }
    
}
