package com.example.springsprinttask2.services;

import com.example.springsprinttask2.models.ApplicationRequest;
import com.example.springsprinttask2.repositories.ApplicationReqRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationReqService {

    @Autowired
    private ApplicationReqRep applicationReqRep;

    // отправляю всё во фронт
    public List<ApplicationRequest> getAppReq() {
        return applicationReqRep.findAll();
    }

    // операция добавления
    public void addApp(ApplicationRequest applicationRequest) {
        applicationReqRep.save(applicationRequest);
    }

    // Нахождение по id для вывода детальной информации
    public ApplicationRequest getById(Long id) {
        return applicationReqRep.findById(id).orElse(null);
    }

    // Удаление по id
    public void delete(Long id) {
        applicationReqRep.deleteById(id);
    }

    // Редактирование по id
    public void editAppReqById(ApplicationRequest applicationRequest){
        if (!applicationRequest.isHandled()){
            applicationRequest.setHandled(true);
        }
        applicationReqRep.save(applicationRequest);
    }

    // сортировка новых заявок

   public List<ApplicationRequest> sortNew(List<ApplicationRequest> applicationRequests1){
        List<ApplicationRequest> applicationRequests = new ArrayList<>();
       for (ApplicationRequest app: applicationRequests1) {
           if (!app.isHandled()){
               applicationRequests.add(app);
           }
       }
       return applicationRequests;
   }

   // сортировка обработанных заявок

    public List<ApplicationRequest> sortOld(List<ApplicationRequest> applicationRequestsDontSorted){
        List<ApplicationRequest> applicationRequestsSortedList = new ArrayList<>();
        for (ApplicationRequest app: applicationRequestsDontSorted) {
            if (app.isHandled()){
                applicationRequestsSortedList.add(app);
            }
        }
        return applicationRequestsSortedList;
    }

}
