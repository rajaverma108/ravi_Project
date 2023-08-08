package com.user.reg.sys.controller;

import com.user.reg.sys.model.faculty.entities.FacultyData;
import com.user.reg.sys.service.FacultyDataService;
import com.user.reg.sys.utility.ExceptionHandling.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FacultyDataController {
    @Autowired
    FacultyDataService facultyDataService;

    @GetMapping("/faculty")
    public ResponseEntity<List<FacultyData>> getAllUser() {
        List<FacultyData> facultyData = facultyDataService.getFacultyData();
        if (facultyData.isEmpty()) {
            return new ResponseEntity<>(facultyData, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(facultyData));
        //new ResponseEntity<>(FacultyData, HttpStatus.OK);
    }

    //    fetching record By id
    @GetMapping("/faculty/{id}")
    public ResponseEntity<FacultyData> getAllUserByid(@PathVariable("id") String id) {
        FacultyData FacultyData = facultyDataService.getAllUserByid(id);
        if (FacultyData != null)
            return new ResponseEntity<>(FacultyData, HttpStatus.OK);
        return new ResponseEntity<>(FacultyData, HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/users")
//    public ResponseEntity<List<FacultyData>> createAllUser(@RequestBody List<FacultyData> FacultyData) {
//        List<FacultyData> FacultyDatalist = facultyDataService.createFacultyData(FacultyData);
//        if (FacultyDatalist.isEmpty()) return ResponseEntity.badRequest().build();
//        return new ResponseEntity<>(FacultyDatalist, HttpStatus.CREATED);
//    }

    @PostMapping("/faculty")
    public ResponseEntity<FacultyData> createAllUser(@RequestBody FacultyData FacultyData) {
        FacultyData facultyData = facultyDataService.createFacultyData(FacultyData);
        if (facultyData == null) return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(facultyData, HttpStatus.CREATED);
    }


    @PutMapping("/faculty/{id}")
    public ResponseEntity<String> updateFacultyData(@RequestBody FacultyData FacultyData, @PathVariable("id") String id) throws MyCustomException {
        String status = facultyDataService.updateFacultyData(FacultyData, id);
        if (status.equalsIgnoreCase("updated")) {
            return new ResponseEntity<>(FacultyData.getId() + " record updated ", HttpStatus.OK);
        } else if (status.equalsIgnoreCase("not present")) {
            return new ResponseEntity<>(FacultyData.getId() + " user id is not present in record ", HttpStatus.NO_CONTENT);
        } else if (status.equalsIgnoreCase("invalid")) {
            return new ResponseEntity<>(FacultyData.getId() + " please provide valid id in input ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFacultyData(@PathVariable("id") String id) {
        try {
            boolean status = facultyDataService.deleteByid(id);
            if (status == true) {
                return new ResponseEntity<>(id + " got deleted ", HttpStatus.OK);
            }
            return new ResponseEntity<>(id + " Not Found ", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

