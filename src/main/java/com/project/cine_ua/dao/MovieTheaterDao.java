package com.project.cine_ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.cine_ua.connection.ConnectionFactory;
import com.project.cine_ua.model.MovieTheater;


public class MovieTheaterDao {
	
	public MovieTheaterDao() {
		
	}
	
 public MovieTheater save(MovieTheater movieTheater) {
		 
		 String sql = "INSERT INTO movie_theater (movie_theater_name, cine_id) VALUES (?,?)";
	     Connection connection = ConnectionFactory.getConnection();
	     
	     try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, movieTheater.getMovieTheaterName());
	            pst.setLong(2, movieTheater.getCineId());

	        	            
	            pst.executeUpdate();
	            
	            ConnectionFactory.close(connection, pst);
	            
	            return movieTheater;
	            
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
		
	     
	 }
	 
	 public MovieTheater update(Long id, MovieTheater movieTheater) {
		  if (movieTheater != null && id != null) {
	            String sql = "UPDATE movie_theater SET movie_theater_name=?,cine_id=? WHERE (movie_theater_id=?)";
	            Connection connection = ConnectionFactory.getConnection();

	            try {
	                PreparedStatement pst = connection.prepareStatement(sql);
	                pst.setString(1, movieTheater.getMovieTheaterName());
	                pst.setLong(2, movieTheater.getCineId());
	                pst.setString(3, String.valueOf(id));
	               
	                pst.executeUpdate();
	              
	               
	               ConnectionFactory.close(connection, pst);
	               
	               
	               
	               return movieTheater;
	            } catch (SQLException var5) {
	                var5.printStackTrace();
	            }
	            }

		  return null;
	 }
	 
	 public void delete(Long id) {
		 if (id != null) {
	            String sql = "DELETE FROM movie_theater WHERE (movie_theater_id = ?)";
	            Connection connection = ConnectionFactory.getConnection();

	            try {
	                PreparedStatement pst = connection.prepareStatement(sql);
	                pst.setString(1, String.valueOf(id));
	                
	                pst.executeUpdate();
	             
	              ConnectionFactory.close(connection, pst);
	            } catch (SQLException var5) {
	                var5.printStackTrace();
	            }

	        
	        }
	 }
	 
	   public static List<MovieTheater> findAll() {
	        String sql = "SELECT movie_theater_id, movie_theater_name, cine_id FROM movie_theater";
	        Connection connection = ConnectionFactory.getConnection();
	        ArrayList movieTheaterList = new ArrayList<MovieTheater>();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	            	      
	                movieTheaterList.add(new MovieTheater(rs.getLong(1), rs.getString(2), rs.getLong(3)));
	            }

	            ConnectionFactory.close(connection, pst, rs);
	            return movieTheaterList;
	            
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }
	 
	   public  MovieTheater findById(Long id) {
	        String sql = "SELECT movie_theater_id, movie_theater_name, cine_id FROM movie_theater WHERE (movie_theater_id=?)";
	        Connection connection = ConnectionFactory.getConnection();
	        MovieTheater movieTheater = new MovieTheater();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1,String.valueOf(id));
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	               movieTheater =new MovieTheater(rs.getLong(1), rs.getString(2), rs.getLong(3));
	            }
	            ConnectionFactory.close(connection, pst, rs);

	            return movieTheater;
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }

}
