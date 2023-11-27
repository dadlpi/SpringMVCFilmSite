package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String descriptionOffilm;
	private short releaseYear;
	private String language;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> cast;
	private String category;

	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Film() {
		
	}
	
	

	public Film(int filmId, String title, String descriptionOffilm, short releaseYear2, String language,
			int rentDur, double rate, int length2, double repCost, String rating,
			String specialFeatures) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.descriptionOffilm = descriptionOffilm;
		this.releaseYear = releaseYear2;
		this.language = language;
		this.rental_duration = rentDur;
		this.rental_rate = rate;
		this.length = length2;
		this.replacementCost = repCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}



	public List<Actor> getCast() {
		List<Actor> copyOfCast = new ArrayList<>(cast);
		return copyOfCast;
	}



	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}



	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptionOffilm() {
		return descriptionOffilm;
	}

	public void setDescriptionOffilm(String descriptionOffilm) {
		this.descriptionOffilm = descriptionOffilm;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguage_id() {
		return language;
	}

	public void setLanguage_id(String language) {
		this.language = language;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cast, category, descriptionOffilm, filmId, language, length, rating, releaseYear,
				rental_duration, rental_rate, replacementCost, specialFeatures, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(category, other.category)
				&& Objects.equals(descriptionOffilm, other.descriptionOffilm) && filmId == other.filmId
				&& Objects.equals(language, other.language) && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rental_duration == other.rental_duration
				&& Double.doubleToLongBits(rental_rate) == Double.doubleToLongBits(other.rental_rate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}




	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", descriptionOffilm=" + descriptionOffilm
				+ ", releaseYear=" + releaseYear + ", language=" + language + ", rental_duration=" + rental_duration
				+ ", rental_rate=" + rental_rate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", cast=" + cast + ", category="
				+ category + "]";
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	
	
}
