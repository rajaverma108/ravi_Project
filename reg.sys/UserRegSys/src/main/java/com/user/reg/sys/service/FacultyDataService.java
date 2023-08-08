package com.user.reg.sys.service;

import com.user.reg.sys.ConstantsConfig.Constants;
import com.user.reg.sys.model.faculty.entities.FacultyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class FacultyDataService {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public List <FacultyData> getFacultyData() {
        List values = template.opsForHash().values(Constants.HASH_KEY);
        return values;
    }

    public FacultyData getAllUserByid(String id) {
        FacultyData facultyData = (FacultyData) template.opsForHash().get(Constants.HASH_KEY, id);
        return facultyData;
    }

    public FacultyData createFacultyData(FacultyData facultyData) {
        template.opsForHash().put(Constants.HASH_KEY, facultyData.getId(), facultyData);
        return facultyData;
    }

    public String updateFacultyData(FacultyData facultyData, String id) {
        return null;
    }

    public boolean deleteByid(String id) {
        template.opsForHash().delete(Constants.HASH_KEY,id);
        return true;
    }
}


