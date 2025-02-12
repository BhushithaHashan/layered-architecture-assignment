package org.example.schoolmanagement.dto;

public class ClassDTO {
    private int classId;
    private String className;
    private String section;
    private int maxStudents;
    private Integer gradeId;
    private Integer streamId;

    // Constructors
    public ClassDTO(int classId, String className, String section, int maxStudents, Integer gradeId, Integer streamId) {
        this.classId = classId;
        this.className = className;
        this.section = section;
        this.maxStudents = maxStudents;
        this.gradeId = gradeId;
        this.streamId = streamId;
    }

    public ClassDTO() {}

    // Getters and Setters
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        if (section.length() != 1) {
            throw new IllegalArgumentException("Section must be a single character.");
        }
        this.section = section;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents <= 0) {
            throw new IllegalArgumentException("Max students must be positive.");
        }
        this.maxStudents = maxStudents;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStreamId() {
        return streamId;
    }

    public void setStreamId(Integer streamId) {
        this.streamId = streamId;
    }

    // ToString for debugging
    @Override
    public String toString() {
        return "ClassDTO{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", section='" + section + '\'' +
                ", maxStudents=" + maxStudents +
                ", gradeId=" + gradeId +
                ", streamId=" + streamId +
                '}';
    }
}
