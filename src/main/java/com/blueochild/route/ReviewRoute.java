package com.blueochild.route;

import com.blueochild.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewRoute {
    private final ReviewService reviewService;

    @Autowired
    public ReviewRoute(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/initialize")
    public void initializeReviews(){
        this.reviewService.initializeReviews();
    }
}
