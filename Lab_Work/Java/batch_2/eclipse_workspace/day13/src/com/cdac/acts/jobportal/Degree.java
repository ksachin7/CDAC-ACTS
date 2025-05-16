package com.cdac.acts.jobportal;

//public enum Degree {
//    HIGH_SCHOOL,
//    ASSOCIATE,
//    BACHELOR,
//    MASTER,
//    DOCTORATE,
//    DIPLOMA,
//    CERTIFICATION,
//    OTHER
//}

public enum Degree {
    HIGH_SCHOOL("High School Diploma"),
    ASSOCIATE("Associate Degree"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTORATE("Doctorate or PhD"),
    DIPLOMA("Diploma"),
    CERTIFICATION("Certification"),
    OTHER("Other");

    private final String degree;

    Degree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return degree;
    }
}
