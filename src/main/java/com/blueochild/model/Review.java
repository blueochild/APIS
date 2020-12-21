package com.blueochild.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column
    private int userId;

    @Column
    private int rate;

    @Column
    private String review;

    @Builder
    public Review(int userId, int rate, String review) {
        this.userId = userId;
        this.rate = rate;
        this.review = review;
    }

    @Override
    public String toString() {
        return String.format(
                "Review[reviewId=%d, userId=%d, rate=%d, review='%s']",
                this.reviewId, this.userId, this.rate, this.review
        );
    }
}
