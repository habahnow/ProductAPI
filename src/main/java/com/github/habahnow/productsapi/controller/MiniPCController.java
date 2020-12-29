package com.github.habahnow.productsapi.controller;

import com.github.habahnow.productsapi.exception.RecordNotFoundException;
import com.github.habahnow.productsapi.model.MiniPC;
import com.github.habahnow.productsapi.service.MiniPCService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/minipc")
public class MiniPCController {
    
    @Autowired
    MiniPCService service;

    @GetMapping("/")
    public String index(){
        return "miniPCIndex";
    }

    @PostMapping("/csv-reviewer-properties-result")
    public String csvReviewerPropertiesResult(
            @RequestParam("file")MultipartFile file, Model model){

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file " + //
                    "to upload.");
            model.addAttribute("status", false);
        }
        else {
            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new //
                    InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<MiniPC> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(MiniPC.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<MiniPC> miniPCs = csvToBean.parse();

                List<String> miniPCStatus = new ArrayList<>();
                for (MiniPC miniPC: miniPCs){
                    boolean exists = service.partNumberExists(//
                            miniPC.getPartNumber());
                    if(exists){
                        if(!service.miniPCIsChanged(miniPC)){
                            miniPCStatus.add("Will be Unchanged");
                        }
                        else {
                            miniPCStatus.add("Will be Updated");
                        }
                    }
                    else{
                        miniPCStatus.add("Will be Created");
                    }

                }

                // save users list on model
                model.addAttribute("miniPCs", miniPCs);
                model.addAttribute("status", true);
                model.addAttribute("miniPCStatus", miniPCStatus);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred " + //
                        "while processing the CSV file.\n\nError:\n" +ex) ;
                model.addAttribute("status", false);
            }
        }

        return "csv-reviewer-result";
    }

    @GetMapping("/csv-reviewer-properties-upload")
    public String startPageCSVReviewerProperties(){
        return "csv-reviewer-properties-upload";

    }

    @GetMapping("/csv-upload-update-properties")
    public String csvUploadUpdateProperties(){
        return "csv-upload-update-properties";

    }

    @PostMapping("/csv-upload-update-properties-result")
    public String csvUploadUpdatePropertiesResult(
            @RequestParam("file")MultipartFile file, Model model){

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file " + //
                    "to upload.");
            model.addAttribute("status", false);
        }
        else {
            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new //
                    InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<MiniPC> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(MiniPC.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<MiniPC> miniPCs = csvToBean.parse();

                List<String> miniPCStatus = new ArrayList<>();
                for (MiniPC miniPC: miniPCs){
                    boolean exists = service.partNumberExists(//
                            miniPC.getPartNumber());
                    if(exists){
                        if(!service.miniPCIsChanged(miniPC)){
                            miniPCStatus.add("Will be Unchanged");
                        }
                        else {
                            miniPCStatus.add("Will be Updated");
                        }
                    }
                    else{
                        miniPCStatus.add("Will be Created");
                    }

                }

                // save users list on model
                model.addAttribute("miniPCs", miniPCs);
                model.addAttribute("status", true);
                model.addAttribute("miniPCStatus", miniPCStatus);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred " + //
                        "while processing the CSV file.\n\nError:\n" +ex) ;
                model.addAttribute("status", false);
            }
        }

        return "csv-reviewer-result";
    }

    @PostMapping("/save-csv-file")
    public String saveCSVFile(
            @RequestParam("miniPCs")List<MiniPC> miniPCs  , Model model){
        if (miniPCs.isEmpty() ){
            //TODO: fix message
            model.addAttribute("message", "Error, didn't receive miniPCs");
            model.addAttribute("status", false);

        }
        else{
            model.addAttribute("status", true);

        }

        model.addAttribute("status", true);

        return "success";

    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFileConfirmation(
            @RequestParam("file")MultipartFile file,Model model){

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file " + //
                    "to upload.");
            model.addAttribute("status", false);
        }
        else {
            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new //
                    InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<MiniPC> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(MiniPC.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<MiniPC> miniPCs = csvToBean.parse();

                List<String> miniPCStatus = new ArrayList<>();
                for (MiniPC miniPC: miniPCs){
                    boolean exists = service.partNumberExists(//
                            miniPC.getPartNumber());
                    if(exists){
                        if(!service.miniPCIsChanged(miniPC)){
                            miniPCStatus.add("Unchanged");
                        }
                        else {
                            miniPCStatus.add("Updated");
                            service.createOrUpdateDevice(miniPC);
                        }
                    }
                    else{
                        miniPCStatus.add("Created");
                        service.createOrUpdateDevice(miniPC);
                    }

                }

                // save users list on model
                model.addAttribute("miniPCs", miniPCs);
                model.addAttribute("status", true);
                model.addAttribute("miniPCStatus", miniPCStatus);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred " + //
                        "while processing the CSV file.\nError:\n" +ex) ;
                model.addAttribute("status", false);
            }
        }

        return "file-upload-status";
    }

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
