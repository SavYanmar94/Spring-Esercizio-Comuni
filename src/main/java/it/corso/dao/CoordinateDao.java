package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Coordinate;

public interface CoordinateDao extends CrudRepository<Coordinate, Integer>{

}
