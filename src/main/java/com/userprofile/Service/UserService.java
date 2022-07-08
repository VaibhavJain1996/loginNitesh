package com.userprofile.Service;

import com.userprofile.Entity.Admin;
import com.userprofile.Entity.NewUser;
import com.userprofile.Entity.UserUpload;
import com.userprofile.Repository.AdminRepo;
import com.userprofile.Repository.Uploading_photos;
import com.userprofile.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    Uploading_photos uploads;
    
//================For Users====================
    
    public void saveUser(NewUser user){
        userRepo.save(user);
    }
    public List<NewUser> findall(){
        return userRepo.findAll();

    }
    public List<NewUser> findByEmail(String email){
        return userRepo.findByEmail(email);
    }
    
    public void remove(int id) {
    	userRepo.deleteById(id);
    }
    
//===============For Admins=================
    
    public void saveAdmin(Admin admin){
        adminRepo.save(admin);
    }

    public List<Admin> findAllAdmin() {
      return adminRepo.findAll();
    }
    
//    ==================For Uploading====================

public void savePhotos(UserUpload photos) {
	uploads.save(photos);
	
	}
}
