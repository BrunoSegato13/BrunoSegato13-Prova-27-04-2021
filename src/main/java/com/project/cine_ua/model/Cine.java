package com.project.cine_ua.model;

import java.sql.Time;
import java.time.LocalTime;

import jakarta.json.bind.annotation.JsonbDateFormat;

public class Cine {

	 	private Long cineId;
	    private String cineName;
	    
	    private String openingHour;

	    private String closeHour;
		
	    
	    public Cine(Long cineId, String cineName, String openingHour, String closeHour) {
			super();
			this.cineId = cineId;
			this.cineName = cineName;
			this.openingHour = openingHour;
			this.closeHour = closeHour;
		}

	    

		public Cine() {
			
		}



		public Long getCineId() {
			return cineId;
		}


		public void setCineId(Long cineId) {
			this.cineId = cineId;
		}


		public String getCineName() {
			return cineName;
		}


		public void setCineName(String cineName) {
			this.cineName = cineName;
		}


		public String getOpeningHour() {
			return openingHour;
		}


		public void setOpeningHour(String openingHour) {
			this.openingHour = openingHour;
		}


		public String getCloseHour() {
			return closeHour;
		}


		public void setCloseHour(String closeHour) {
			this.closeHour = closeHour;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cineId == null) ? 0 : cineId.hashCode());
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
			Cine other = (Cine) obj;
			if (cineId == null) {
				if (other.cineId != null)
					return false;
			} else if (!cineId.equals(other.cineId))
				return false;
			return true;
		}
	   
	    
	    
	    
	    
	    
	    
}
