package com.example.backend.mvc;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.backend.entity.Result;
import com.example.backend.entity.ResultRepository;
import com.example.backend.entity.Shot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Autowired
    ResultRepository repository;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173");
            }
        };
    }

    @PostMapping("/process")
    void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestData = request.getReader().lines().collect(Collectors.joining());

        DataPreprocessor preprocessor = new DataPreprocessor();
        Shot shot = preprocessor.preprocess(requestData);
        if (shot != null) {
            repository.save(new Result(shot.getX(), shot.getY(), shot.getR(), shot.isHit(), shot.getOwner()));
        }
        response.setStatus(200);

        response.getWriter().println(repository.findAll());
    }

    @PostMapping("/clear")
    void clear(HttpServletResponse response) throws IOException{
        repository.deleteAll();
        response.setStatus(200);
        response.getWriter().println("Cleared data");
    }

}
