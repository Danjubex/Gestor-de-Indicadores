/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.univasf.hu.planejamento.crud;

import com.br.univasf.hu.planejamento.Avaliacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Danillo
 */
@Stateless
public class ControleAvaliacaoBean implements ControleAvaliacaoInterface{

    @PersistenceContext
    private EntityManager gerenciador;//nao é nul
    
    @Override
    public boolean adicionar(Avaliacao avaliacao) {
     boolean sucesso;
        try
        {
            gerenciador.persist(avaliacao);
            sucesso=true;
        }
        catch(Exception e)
        {
            sucesso=false;
            e.printStackTrace();
        }
       return sucesso;
    }
    
}
