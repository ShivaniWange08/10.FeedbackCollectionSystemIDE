package com.practise.service;

import com.practise.entity.Feedbacks;

import java.util.List;

public interface FeedbackService {

    String savedFeedback(Feedbacks feedbacks);

    List<Feedbacks> getAllFeedback();

    Feedbacks getFeedbackById(int id);

    String deleteFeedbackById(int id);

    Feedbacks updateFeedback(int id, Feedbacks newFeedback);

    List<Feedbacks> savelistOfFeedbacks(List<Feedbacks> feedbacksList);
}
