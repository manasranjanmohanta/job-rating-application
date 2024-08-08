package com.example.job.jobs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    List<Job> jobList = new ArrayList<>();
    private Long jobId = 1L;

    @Override
    public List<Job> getAllJobs() {
        return jobList;
    }

    @Override
    public String createJob(Job job) {
        job.setId(jobId++);
        jobList.add(job);
        return "Job added successfully";
    }
}
