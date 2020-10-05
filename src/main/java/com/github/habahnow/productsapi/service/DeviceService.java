package com.github.habahnow.productsapi.service;

import com.github.habahnow.productsapi.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository repository;

    public List<Device> getAllDevices(){
        List<Device> deviceList = respository.findAll();
        if(deviceList.size() > 0){
            return deviceList;
        }
        else{
            return new ArrayList<Device>();
        }
    }

    public Device createOrUpdateDevice(StudentEntity entity)
            throws RecordNotFoundException{

    }

}
