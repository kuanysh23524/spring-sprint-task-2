package com.example.springsprinttask2.repositories;

import com.example.springsprinttask2.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationReqRep  extends JpaRepository<ApplicationRequest, Long> {
}
