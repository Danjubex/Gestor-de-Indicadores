/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.univasf.hu.planejamento.crud;

import com.br.univasf.hu.planejamento.Avaliacao;
import com.br.univasf.hu.planejamento.Indicador;
import javax.ejb.Local;

/**
 *
 * @author Danillo
 */
@Local
public interface ControleAvaliacaoInterface {
    boolean adicionar(Avaliacao avaliacao);//tem q retornar boolean
    
}
