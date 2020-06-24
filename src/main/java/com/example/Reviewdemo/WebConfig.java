package com.example.Reviewdemo;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

public class WebConfig {

  @Bean
  public Filter TracingFilter() {
    return new AWSXRayServletFilter("review");
  }
}