package com.user.reg.sys.service;

import com.sun.security.auth.UserPrincipal;
import com.user.reg.sys.model.user.entities.UserData;
import com.user.reg.sys.model.user.userrepo.UserDataRepo;
import com.user.reg.sys.utility.ExceptionHandling.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    UserDataRepo userDataRepo;


    public List<UserData> getUserData() {
        return userDataRepo.findAll();
    }

    public UserData getAllUserBycid(String cid) {
        return userDataRepo.findByCid(cid);
    }

    public List<UserData> createUserData(List<UserData> userData) {
        try {
            return userDataRepo.saveAllAndFlush(userData);
        }
       catch (Exception e){
            e.printStackTrace();
       }
        return null;
    }

    public String updateUserData(UserData userData,String cid) throws MyCustomException {
        UserData data =null;
        try {
            if (cid != null) {
                UserData byCid = userDataRepo.findByCid(cid);
                if (byCid!=null) {
                    userDataRepo.save(userData);
                    return "updated";
                            //userData.getCid() + " has been updated ";
                } else {
                    return "not present";
                            //userData.getCid() + " user cid is not present in record ";
                }
            } else {
                return "invalid";
                        //"please provide valid Cid in input ";
            }
        } catch (Exception e) {
            throw new MyCustomException("Not able to save..!!");
        }

    }
    public boolean deleteBycid(String cid) {
        if (userDataRepo.findByCid(cid)!=null){
            userDataRepo.deleteById(cid);
            return true;
        }
        return false;

    }


}


