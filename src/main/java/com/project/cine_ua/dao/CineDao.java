package com.project.cine_ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.cine_ua.connection.ConnectionFactory;
import com.project.cine_ua.model.Cine;

public class CineDao {
	
	 public CineDao() {
	 }
	 
	 public Cine save(Cine cine) {
		 
		 String sql = "INSERT INTO cine (cine_name, openin_hour, close_hour) VALUES (?,?,?)";
	     Connection connection = ConnectionFactory.getConnection();
	     
	     try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, cine.getCineName());
	            pst.setString(2, cine.getOpeningHour());
	            pst.setString(3, cine.getCloseHour());
	        	            
	            pst.executeUpdate();
	            
	            ConnectionFactory.close(connection, pst);
	            
	            return cine;
	            
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
		
	     
	 }
	 
	 public Cine update(Long id, Cine cine) {
		  if (cine != null && id != null) {
	            String sql = "UPDATE cine SET cine_name=?, openin_hour=?, close_hour=? WHERE (cine_id=?)";
	            Connection connection = ConnectionFactory.getConnection();

	            try {
	                PreparedStatement pst = connection.prepareStatement(sql);
	                pst.setString(1, cine.getCineName());
	                pst.setString(2, cine.getOpeningHour().toString());
	                pst.setString(3, cine.getCloseHour().toString());
	                pst.setString(4, String.valueOf(id));
	               
	                pst.executeUpdate();
	              
	               
	               ConnectionFactory.close(connection, pst);
	               
	               
	               
	               return cine;
	            } catch (SQLException var5) {
	                var5.printStackTrace();
	            }
		  }
	       
		  return null;
	 }
	 
	 public void delete(Long id) {
		 if (id != null) {
	            String sql = "DELETE FROM cine WHERE (cine_id = ?)";
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
	 
	   public static List<Cine> findAll() {
	        String sql = "SELECT cine_id, cine_name, openin_hour, close_hour FROM cine";
	        Connection connection = ConnectionFactory.getConnection();
	        ArrayList cineList = new ArrayList<Cine>();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	            	      
	                cineList.add(new Cine(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	            }

	            ConnectionFactory.close(connection, pst, rs);
	            return cineList;
	            
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }
	 
	   public  Cine findById(Long id) {
	        String sql = "SELECT cine_id, cine_name, openin_hour, close_hour FROM cine WHERE (cine_id=?)";
	        Connection connection = ConnectionFactory.getConnection();
	        Cine cine = new Cine();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1,String.valueOf(id));
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	               cine =new Cine(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
	            }
	            ConnectionFactory.close(connection, pst, rs);

	            return cine;
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }
	

}
