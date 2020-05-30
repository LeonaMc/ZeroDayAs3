package com.zeroday.auth.repository;

import java.util.List;

import com.zeroday.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zeroday.auth.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    //  List<Module> findByEnroll(Boolean enroll);

    // @Query("SELECT m FROM Module m where m.enroll  = TRUE")
    // List<Module> getListOfEnrolledModules();

    List<Module> findAllByCoordinator(User coordinator);

    Module findOneByIdAndCoordinator(Long id, User coordinator);
}
