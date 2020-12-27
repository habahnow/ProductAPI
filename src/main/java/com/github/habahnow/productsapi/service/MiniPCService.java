package com.github.habahnow.productsapi.service;

import com.github.habahnow.productsapi.exception.RecordNotFoundException;
import com.github.habahnow.productsapi.repository.MiniPCRepository;
import com.github.habahnow.productsapi.model.MiniPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MiniPCService {

    @Autowired
    MiniPCRepository repository;

    //TODO: change this method to separate create or upddate methods i think
    public MiniPC createOrUpdateDevice(MiniPC entity)
            throws RecordNotFoundException {
        if(entity.getPartNumber()!=null){
            Optional<MiniPC> device = //
                    repository.findById(entity.getPartNumber());

            if(device.isPresent()){
                MiniPC newDevice = entity;
                newDevice = repository.save(newDevice);

                return newDevice;
            }
            else{
                entity = repository.save(entity);
                return entity;
            }

        }

        else{
            entity =repository.save(entity);
            return entity;
        }
    }

    public List<MiniPC> getAllMiniPCs(){
        List<MiniPC> miniPCList = repository.findAll();
        if(miniPCList.size() > 0){
            return miniPCList;
        }
        else{
            return new ArrayList<MiniPC>();
        }
    }

    public boolean miniPCIsChanged(MiniPC miniPC){
        MiniPC existing = repository.getOne(miniPC.getPartNumber());
        if (existing.equals(miniPC)){
            return false;
        }
        return true;
    }

    public boolean partNumberExists(String partNumber){
        if(!repository.findById(partNumber).isPresent()){
            return false;
        }
        else{
            return true;
        }

    }


    public void deleteMiniPCByPartNumber(String name) //
            throws RecordNotFoundException{
        Optional<MiniPC> device = repository.findById(name);

        if(device.isPresent()){
            repository.deleteById(name);
        }
        else{
            throw new RecordNotFoundException("No student record exists for " +
                    "the given part number:", name);
        }

    }



}
