package com.practise.serviceimpl;

import com.practise.entity.Feedbacks;
import com.practise.repository.FeedbackRepository;
import com.practise.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceimpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public String savedFeedback(Feedbacks feedbacks) {
        Feedbacks savedFeedback = feedbackRepository.save(feedbacks);
        return "feedback saved";
    }

    @Override
    public List<Feedbacks> getAllFeedback() {
        List<Feedbacks> feedbacksList = feedbackRepository.findAll();
        return feedbacksList;
    }

    @Override
    public Feedbacks getFeedbackById(int id) {
        Feedbacks feedbacks = feedbackRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("feedback with id not found" +id));
        return feedbacks;
    }

    @Override
    public String deleteFeedbackById(int id) {
        feedbackRepository.deleteById(id);
        return "Feedback Deleted";
    }

    @Override
    public Feedbacks updateFeedback(int id, Feedbacks newFeedback) {
        Feedbacks feedbacks = feedbackRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Feedback with id not found in database" +id));
        System.err.println("old feedback from db "+feedbacks);
        System.err.println("Feedback object with value to be updated " +newFeedback);
        feedbacks.setUserName(newFeedback.getUserName());
        feedbacks.setEmail(newFeedback.getEmail());
        feedbacks.setRating(newFeedback.getRating());
        feedbacks.setComments(newFeedback.getComments());

        Feedbacks updateFeedback = feedbackRepository.save(feedbacks);
        System.err.println("Feedback with updated value" +feedbacks);
        return updateFeedback;
    }

    @Override
    public List<Feedbacks> savelistOfFeedbacks(List<Feedbacks> feedbacksList) {
        feedbackRepository.saveAll(feedbacksList);
        return feedbacksList;
    }
}
