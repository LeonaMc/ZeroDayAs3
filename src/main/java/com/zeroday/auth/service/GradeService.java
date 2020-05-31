package com.zeroday.auth.service;

import com.zeroday.auth.model.Grade;
import com.zeroday.auth.model.User;
import com.zeroday.auth.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private WrongAttemptService wrongAttemptService;

    public List<Grade> findAllByCurrentUser() {
        User currentUser = wrongAttemptService.getCurrentUser();
        return gradeRepository.findAllByModuleCoordinator(currentUser);
    }
}
