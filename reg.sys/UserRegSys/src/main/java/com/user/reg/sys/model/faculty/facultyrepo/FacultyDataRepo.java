//package com.user.reg.sys.model.faculty.facultyrepo;
//
//import com.user.reg.sys.ConstantsConfig.Constants;
//import com.user.reg.sys.model.faculty.entities.FacultyData;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public class FacultyDataRepo {
//
//    private RedisTemplate template;
//
//    public FacultyData save(FacultyData facultyData) {
//        template.opsForHash().put(Constants.HASH_KEY, facultyData.getId(), facultyData);
//        return facultyData;
//    }
//
//    public List<FacultyData> findAll(FacultyData facultyData) {
//        List values = template.opsForHash().values(Constants.HASH_KEY);
//        return values;
//    }
//
//    public FacultyData findById(int id) {
//        return (FacultyData) template.opsForHash().get(Constants.HASH_KEY,id);
//    }
//
//    public String deleteByid(int id) {
//        template.opsForHash().delete(Constants.HASH_KEY,id);
//        return "Deleted !!";
//    }
//}
