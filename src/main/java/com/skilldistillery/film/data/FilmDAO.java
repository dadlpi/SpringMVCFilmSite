package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);
	
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;
	
	public String findFilmCategory(int filmId) throws SQLException;
	
	public List<Film> findFilmByString(String searchString);
	
	
	
//	Film findById(int filmId);
}
