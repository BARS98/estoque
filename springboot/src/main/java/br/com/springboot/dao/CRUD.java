package br.com.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface CRUD<T, ID> {
    T pesquisaPeloId(ID id);
    List<T> listaTodos();   
    void insere(T t);
    void atualiza(T t);
    void remove(T t);
}