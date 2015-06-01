/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.univasf.hu.planejamento.crud;

import com.br.univasf.hu.planejamento.Indicador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Danillo
 */
@Local
public interface ControleIndicadorInterface{
    boolean adicionar(Indicador indicador);//tem q retornar boolean
    boolean editar(Indicador indicador);
    List<Indicador> findAll();//todas os registros
    List<Indicador> findSimilar(String value);//todas os registros
    List<Indicador> findByName(String value);//todas os registros
    Indicador findSpecific(Indicador indicador);//retorna um setor específico
    Indicador findWithId(Long id);//retorna um setor específico

    boolean excluir(Indicador indicador);
    
}
