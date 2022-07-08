package com.userprofile.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="UserUpload")
public class UserUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

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

    String image_url;
    
    @Temporal(TemporalType.DATE)
    @CreatedDate
    Date date;
    String description;



    @Override
	public String toString() {
		return "UserUpload [id=" + id + ", image_name=" + image_name + ", image_url=" + image_url + ", date=" + date
				+ ", description=" + description + ", newUser=" + newUser + "]";
	}

    
	
	@ManyToOne
	NewUser newUser;

	public UserUpload(int id, String image_name, String image_url, Date date, String description, NewUser newUser) {
		super();
		this.id = id;
		this.image_name = image_name;
		this.image_url = image_url;
		this.date = date;
		this.description = description;
		this.newUser = newUser;
	}

	public NewUser getNewUser() {
		return newUser;
	}

	public void setNewUser(NewUser newUser) {
		this.newUser = newUser;
	}

	
}
