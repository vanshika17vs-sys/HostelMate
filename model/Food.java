package com.hostelmate.model;

public record Food(
    String name,
    double min,
    double max,
    String tag
) {
}