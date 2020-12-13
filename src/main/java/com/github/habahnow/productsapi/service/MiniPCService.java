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

    public MiniPC createOrUpdateDevice(MiniPC entity)
            throws RecordNotFoundException {
        if(entity.getPartNumber()!=null){
            Optional<MiniPC> device = //
                    repository.findById(entity.getPartNumber());
            //repository.findByPartNumber(entity.getPartNumber());

            if(device.isPresent()){
                MiniPC newDevice = device.get();
                newDevice.setAudioOutPorts(entity.getAudioOutPorts());
                newDevice.setComPorts(entity.getComPorts());
                newDevice.setCores(entity.getCores());
                newDevice.setCpuName(entity.getCpuName());
                newDevice.setCpuSpeed(entity.getCpuSpeed());
                newDevice.seteMMC(entity.geteMMC());
                newDevice.setFastLanPorts(entity.getFastLanPorts());
                newDevice.setGigaLanPorts(entity.getGigaLanPorts());
                newDevice.setHdmiPorts(entity.getHdmiPorts());
                newDevice.setMicInPorts(entity.getMicInPorts());
                newDevice.setmPCIESlots(entity.getmPCIESlots());
                newDevice.setmSataCombinedMpcieSlots( //
                        entity.getmSataCombinedMpcieSlots());
                newDevice.setmSataSlots(entity.getmSataSlots());
                newDevice.setRam(entity.getRam());
                newDevice.setSataConnectors(entity.getSataConnectors());
                newDevice.setVgaPorts(entity.getVgaPorts());
                newDevice.setUsb3PortsExternal(entity.getUsb3PortsExternal());
                newDevice.setUsb2PortsExternal(entity.getUsb2PortsExternal());
                newDevice.setSlimSataConnectors(entity.getSlimSataConnectors());
                newDevice.setSimCardSlots(entity.getSimCardSlots());

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

    //TODO: change this method to separate create or upddate methods i think

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
