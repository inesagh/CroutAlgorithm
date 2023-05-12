package com.example.croutalgorithm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CroutAlgorithmController {

    @GetMapping("/matrix/crout")
    public ResponseEntity<CroutAlgorithm> get(@RequestBody double[][] matrix){
        CroutAlgorithm croutAlgorithm = new CroutAlgorithm();
        croutAlgorithm.croutAlgorithm(matrix);
        return ResponseEntity.ok(croutAlgorithm);
    }
}
