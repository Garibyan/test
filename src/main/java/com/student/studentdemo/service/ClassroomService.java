package com.student.studentdemo.service;

import com.student.studentdemo.model.Classroom;
import com.student.studentdemo.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {


    private ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAllUsers() {
        List<Classroom> result = (List<Classroom>) classroomRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Classroom>();
        }
    }


}



