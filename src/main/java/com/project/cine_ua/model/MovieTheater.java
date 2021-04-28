package com.project.cine_ua.model;

public class MovieTheater {
	
	 private Long movieTheaterid;
	 private String movieTheaterName;
	 private Long cineId;
	
	 public MovieTheater(Long movieTheaterid, String movieTheaterName, Long cineId) {
		super();
		this.movieTheaterid = movieTheaterid;
		this.movieTheaterName = movieTheaterName;
		this.cineId = cineId;
	}
	
	 
	
	public MovieTheater() {
		super();
	}



	public Long getMovieTheaterid() {
		return movieTheaterid;
	}
	public void setMovieTheaterid(Long movieTheaterid) {
		this.movieTheaterid = movieTheaterid;
	}
	public String getMovieTheaterName() {
		return movieTheaterName;
	}
	public void setMovieTheaterName(String movieTheaterName) {
		this.movieTheaterName = movieTheaterName;
	}
	public Long getCineId() {
		return cineId;
	}
	public void setCineId(Long cineId) {
		this.cineId = cineId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieTheaterid == null) ? 0 : movieTheaterid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieTheater other = (MovieTheater) obj;
		if (movieTheaterid == null) {
			if (other.movieTheaterid != null)
				return false;
		} else if (!movieTheaterid.equals(other.movieTheaterid))
			return false;
		return true;
	}
	
	

	 
}
