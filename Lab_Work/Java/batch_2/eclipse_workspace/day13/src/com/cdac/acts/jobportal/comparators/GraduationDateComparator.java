package com.cdac.acts.jobportal.comparators;

import java.util.Comparator;

import com.cdac.acts.jobportal.JobSeeker;

public class GraduationDateComparator implements Comparator<JobSeeker> {
    public int compare(JobSeeker j1, JobSeeker j2) {
        return j1.getGraduationDate().compareTo(j2.getGraduationDate());
    }
}
