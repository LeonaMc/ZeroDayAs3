package com.zeroday.auth.service;

import com.zeroday.auth.model.Module;
import com.zeroday.auth.model.User;
import com.zeroday.auth.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private UserService userService;
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> findAllByCurrentUser() {
        User coordinator = userService.getCurrentUser();
        return findByCoordinator(coordinator);
    }

    public List<Module> findByCoordinator(User coordinator) {
        return moduleRepository.findAllByCoordinator(coordinator);
    }

    public Module save(Module module) {
        module.setCoordinator(userService.getCurrentUser());
        return moduleRepository.save(module);
    }

    public Module findOne(Long id) {
        Module module = moduleRepository.getOne(id);
        return module;
    }

    public Module findOneByCurrentUser(Long id) {
        User currentUser = userService.getCurrentUser();
        Module module = moduleRepository.findOneByIdAndCoordinator(id, currentUser);
        return module;
    }
}
