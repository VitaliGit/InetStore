package com.vironit.store.entity.person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="authorities")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Authority {
				
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="username")
		@JsonBackReference
		private User userName;
		
		@Column(name="authority")
		private String authority;
						
		public Authority() {}//no-args		

		public Authority(User userName, String authority, int id) {
			this.id=id;
			this.userName = userName;
			this.authority = authority;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		

		public User getUserName() {
			return userName;
		}

		public void setUserName(User userName) {
			this.userName = userName;
		}

		public String getAuthority() {
			return authority;
		}
		
		public void setAuthority(String authority) {
			this.authority = authority;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((authority == null) ? 0 : authority.hashCode());
			result = prime * result + id;
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
			Authority other = (Authority) obj;
			if (authority == null) {
				if (other.authority != null)
					return false;
			} else if (!authority.equals(other.authority))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Authority [id=" + id + ", userName=" + userName + "]";
		}

	
}