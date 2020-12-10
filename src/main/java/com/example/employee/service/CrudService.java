package com.example.employee.service;

public interface CrudService<T, ID> {
	
	Iterable<T> findAll();
	
	T findById(ID id);
	
	void delete(ID id);
	
	T save(T entity);
	
	void update(ID id, T entity);

}
