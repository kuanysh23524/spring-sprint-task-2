package com.example.springsprinttask2.repositories;

import com.example.springsprinttask2.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationReqRep extends JpaRepository<ApplicationRequest, Long> {
    //    @Query("select  i from ApplicationRequest i "
//            + "where i.userName ilike concat('%', :search, '%') "
//            + "or i.courseName ilike concat('%', :search, '%')"
//    )
//
//    List<ApplicationRequest> search(String search);
//    List<ApplicationRequest> findAllByUserName(String userName);
}
