package com.example.job.jobs;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();

    String createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job job);
}
