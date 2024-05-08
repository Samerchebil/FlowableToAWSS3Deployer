package com.example.demo.app.controller;

import com.example.demo.app.service.AmazonS3Service;
import com.example.demo.app.service.FlowableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/deploy")
public class DeployFilesController {

    @Autowired
    private FlowableService deployService;

    @Autowired
    private AmazonS3Service amazonS3Service;

    @GetMapping("/flowableToS3")
    public void flowableToS3() {
        deployService.getContents().forEach(contentItemDto -> amazonS3Service.uploadContentItemFromFlowableToS3(contentItemDto));
    }

}
