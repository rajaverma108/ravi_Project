package com.user.reg.sys.model.user.userrepo;

import com.user.reg.sys.model.user.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataRepo extends JpaRepository<UserData, String> {

    UserData findByCid(String cid);

}
