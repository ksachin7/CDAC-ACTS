package eclipse_workspace.day13.comparators;

import eclipse_workspace.day13.jobportal.JobSeeker;

import java.util.Comparator;

public class DobComparator implements Comparator<JobSeeker> {
    public int compare(JobSeeker j1, JobSeeker j2) {
        return j1.getDateOfBirth().compareTo(j2.getDateOfBirth());
    }
}
