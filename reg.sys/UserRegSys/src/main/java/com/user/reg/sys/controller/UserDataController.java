package com.user.reg.sys.controller;

import com.user.reg.sys.model.user.entities.UserData;
import com.user.reg.sys.service.UserDataService;
import com.user.reg.sys.utility.ExceptionHandling.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserDataController {
    @Autowired
    UserDataService userDataService;

    @GetMapping("/user")
    public ResponseEntity<List<UserData>> getAllUser() {
        List<UserData> userData = userDataService.getUserData();
        if (userData.isEmpty()) {
            return new ResponseEntity<>(userData, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(userData));
        //new ResponseEntity<>(userData, HttpStatus.OK);
    }

    //    fetching record By Cid
    @GetMapping("/users/{cid}")
    public ResponseEntity<UserData> getAllUserByid(@PathVariable("cid") String cid) {
        UserData userData = userDataService.getAllUserBycid(cid);
        if (userData != null)
            return new ResponseEntity<>(userData, HttpStatus.OK);
        return new ResponseEntity<>(userData, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<List<UserData>> createAllUser(@RequestBody List<UserData> userData) {
        List<UserData> userDatalist = userDataService.createUserData(userData);
        if (userDatalist.isEmpty())
            return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(userDatalist, HttpStatus.CREATED);
    }


    @PutMapping("/update/{cid}")
    public ResponseEntity<String> updateUserData(@RequestBody UserData userData,@PathVariable("cid") String cid) throws MyCustomException {
        String status = userDataService.updateUserData(userData,cid);
        if (status.equalsIgnoreCase("update")) {
            return new ResponseEntity<>(userData.getCid() + " record updated ", HttpStatus.OK);
        } else if (status.equalsIgnoreCase("not present")) {
            return new ResponseEntity<>(userData.getCid() + " user cid is not present in record ", HttpStatus.NO_CONTENT);
        } else if (status.equalsIgnoreCase("invalid"))  {
            return new ResponseEntity<>(userData.getCid() + " please provide valid Cid in input ", HttpStatus.BAD_REQUEST);
        }
       return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{cid}")
    public ResponseEntity<String> deleteUserData(@PathVariable("cid") String cid) {
        try {
            boolean status = userDataService.deleteBycid(cid);
            if (status == true) {
                return new ResponseEntity<>(cid + " got deleted ", HttpStatus.OK);
            }
            return new ResponseEntity<>(cid + " Not Found ", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

