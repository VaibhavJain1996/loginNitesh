package com.userprofile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userprofile.Entity.Admin;
import com.userprofile.Entity.NewUser;
import com.userprofile.Entity.UserUpload;
import com.userprofile.Repository.AdminRepo;
import com.userprofile.Repository.Uploading_photos;
import com.userprofile.Repository.UserRepo;
import com.userprofile.Service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    Uploading_photos uploading_photos;
//===================For Users===========================
    @PostMapping("/adduser")
    public void adduser(@RequestBody NewUser user){
        userService.saveUser(user);

    }
    
    @GetMapping("/getUser")
    public List<NewUser> findUsers(){
      return userService.findall();  
    }
    
    
    @GetMapping("/getUser/{email}")
    public List<NewUser> findUsersByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
    
    @PostMapping("/login")
    public NewUser findUser(@RequestParam String email, String password) {
    	 NewUser u = userRepo.getByEmail(email);
         if (u != null && u.getPassword().equals(password)) {
            return u;
        }
         else {
         return null;
        }
    }
       
    	
    @DeleteMapping("/adduser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
	userService.remove(id);
		return "User Deleted";
    }
//================For Admin=====================

    @PostMapping("/addadmin")
    public void addAdmin(@RequestBody Admin admin){
        userService.saveAdmin(admin);
    }
    @GetMapping("/getadmin")
    public List<Admin> findAdmin(){
        return userService.findAllAdmin();
    }
    @PostMapping("/adminlogin")
    public Admin findAdmin(@RequestParam String email, String password) {
    	 Admin a = adminRepo.getByEmail(email);
         if (a != null && a.getPassword().equals(password)) {
            return a;
        }
         else {
         return null;
        }
    }
//    ====================For Upload photos=====================
    
@PostMapping("/uploadphoto/{email}")
public void addpost(@RequestBody UserUpload photos, @PathVariable("email") String email){
    NewUser newUser = userRepo.getByEmail(email);
    if (newUser.getEmail().equals(email))  	
    photos.setNewUser(newUser);
    System.out.println(photos);
    userService.savePhotos(photos);
}

@GetMapping("/getupload")
public List<UserUpload> getAllDetals() {
	return uploading_photos.findAll();}
}
