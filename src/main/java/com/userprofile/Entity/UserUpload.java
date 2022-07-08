package com.userprofile.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="UserUpload")
public class UserUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String image_url;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="date")
    Date date;
    
    public UserUpload(int id, String image_url, Date date, String description, NewUser newUser,
			String image_name) {
		super();
		this.id = id;
		this.image_url = image_url;
		this.date = date;
		this.description = description;
		this.newUser = newUser;
		this.image_name = image_name;
	}

	
	String description;
    @ManyToOne
	NewUser newUser;

    public UserUpload() {
        super();
    }
        String image_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   



    @Override
	public String toString() {
		return "UserUpload [id=" + id + ", image_url=" + image_url + ", date=" + date + ", description=" + description + ", newUser=" + newUser + ", image_name=" + image_name + "]";
	}

    

	public NewUser getNewUser() {
		return newUser;
	}

	public void setNewUser(NewUser newUser) {
		this.newUser = newUser;
	}

	
}
