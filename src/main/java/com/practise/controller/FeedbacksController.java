package com.practise.controller;

import com.practise.entity.Feedbacks;
import com.practise.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbacksController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/addFeedback")
    public ResponseEntity<String> addFeedback(@RequestBody Feedbacks feedbacks){
        System.err.println(feedbacks);
        feedbackService.savedFeedback(feedbacks);
        return new ResponseEntity<>("Feedback Add Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllFeedback")
    public ResponseEntity<List<Feedbacks>> getAllData(){
      List<Feedbacks> feedbacksList = feedbackService.getAllFeedback();
      return new ResponseEntity<>(feedbacksList, HttpStatus.OK);
    }
    @GetMapping("/getFeedbackById/{id}")
    public ResponseEntity<Feedbacks> getFeedBackById(@PathVariable ("id") int id){
        Feedbacks feedbacks = feedbackService.getFeedbackById(id);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFeedbackById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
        String delete = feedbackService.deleteFeedbackById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateFeedback/{id}")
    public ResponseEntity<Feedbacks> updateFeedback(@PathVariable ("id") int id, @RequestBody Feedbacks feedbacks){
        Feedbacks updateFeedback = feedbackService.updateFeedback(id, feedbacks);
        return new ResponseEntity<>(updateFeedback, HttpStatus.OK);
    }

    @PostMapping("/listOfFeedback")
    public ResponseEntity<List<Feedbacks>> savelistOfFeedback(@RequestBody List<Feedbacks> feedbacksList){
         feedbackService.savelistOfFeedbacks(feedbacksList);
        return new ResponseEntity<>(feedbacksList, HttpStatus.CREATED);
    }
}

