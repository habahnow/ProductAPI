package com.github.habahnow.productsapi.controller;

import com.github.habahnow.productsapi.exception.RecordNotFoundException;
import com.github.habahnow.productsapi.model.MiniPC;
import com.github.habahnow.productsapi.service.MiniPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/")
public class MiniPCController {
    
    @Autowired
    MiniPCService service;
    
    @GetMapping("/getAll")
    public ResponseEntity<List<MiniPC>> getAllStudents(){
        List<MiniPC> list = service.getAllMiniPCs();

        return new ResponseEntity<List<MiniPC>>(list, new HttpHeaders(),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MiniPC> createOrUpdateMiniPC( //
            @Valid @RequestBody MiniPC pc ) throws RecordNotFoundException {
        MiniPC updated = service.createOrUpdateDevice(pc);
        return new ResponseEntity<MiniPC>(updated, new HttpHeaders(), //
                HttpStatus.OK);

    }

    @DeleteMapping("/{partNumber}")
    @ResponseBody
    public HttpStatus deleteMiniPCByPartNumber(//
            @PathVariable("partNumber") String name)
            throws RecordNotFoundException{
        service.deleteMiniPCByPartNumber(name);
        return HttpStatus.OK;
    }
}
