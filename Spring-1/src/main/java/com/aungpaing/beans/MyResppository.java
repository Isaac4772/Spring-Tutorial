package com.aungpaing.beans;

import org.springframework.stereotype.Repository;

public interface MyResppository<T> {

	public void save(T t);

	public T findById(int id);
}
