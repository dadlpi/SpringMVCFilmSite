package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;

  public List<Film> findFilmByString(String searchString) throws SQLException;
  
  public Actor findActorById(int actorId) throws SQLException;
  
  public List<Actor> findActorsByFilmId(int filmId) throws SQLException;
  
  public String findFilmCategory(int filmId) throws SQLException;
}
