package com.example.designPatterns.creationalDesignPatterns.prototypeNBuilder;

public class Student implements Prototype<Student> {
    private String id;
    private String name;
    private float psp;
    private String contactDetails;
    private int batchId;
    private int instructorId;
    private String moduleName;
    private float batchPsp;
    private float batchAttendance;
    private String batchTiming;

    private Student(
            String id,
            String name,
            float psp,
            String contactDetails,
            int batchId,
            int instructorId,
            String moduleName,
            float batchPsp,
            float batchAttendance,
            String batchTiming
    ) {
        this.id = id;
        this.name = name;
        this.psp = psp;
        this.contactDetails = contactDetails;
        this.batchId = batchId;
        this.instructorId = instructorId;
        this.moduleName = moduleName;
        this.batchPsp = batchPsp;
        this.batchAttendance = batchAttendance;
        this.batchTiming = batchTiming;
    }

    private Student() {
    }

    private Student(Student student) {
        this(student.id, student.name, student.psp, student.contactDetails, student.batchId, student.instructorId, student.moduleName, student.batchPsp, student.batchAttendance, student.batchTiming);
    }

    private Student(Builder builder) {
        this(builder.id, builder.name, builder.psp, builder.contactDetails, builder.batchId, builder.instructorId, builder.moduleName, builder.batchPsp, builder.batchAttendance, builder.batchTiming);
    }

    public static void main(String[] args) {
        Student lldMWFBatch = new Builder()
                .batchId(1)
                .instructorId(1)
                .batchAttendance(100)
                .batchPsp(90)
                .moduleName("LLD")
                .batchTiming("MWF 10:00 AM - 11:00 AM")
                .build();

        // Student rohit from lld batch
        Student rohit = lldMWFBatch.copy();
        rohit.setId("10");
        rohit.setName("Rohit");
        rohit.setPsp(80);
        rohit.setContactDetails("Place A, City B");

        // Student sachin from lld batch
        Student sachin = lldMWFBatch.copy();
        sachin.setId("11");
        sachin.setName("Sachin");
        sachin.setPsp(90);
        sachin.setContactDetails("Place C, City B");
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPsp() {
        return psp;
    }

    public void setPsp(float psp) {
        this.psp = psp;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public float getBatchPsp() {
        return batchPsp;
    }

    public void setBatchPsp(float batchPsp) {
        this.batchPsp = batchPsp;
    }

    public float getBatchAttendance() {
        return batchAttendance;
    }

    public void setBatchAttendance(float batchAttendance) {
        this.batchAttendance = batchAttendance;
    }

    public String getBatchTiming() {
        return batchTiming;
    }

    public void setBatchTiming(String batchTiming) {
        this.batchTiming = batchTiming;
    }

    @Override
    public Student copy() {
        Student copy = new Student();
        copy.batchId = this.batchId;
        copy.instructorId = this.instructorId;
        copy.batchAttendance = this.batchAttendance;
        copy.batchPsp = this.batchPsp;
        copy.moduleName = this.moduleName;
        copy.batchTiming = this.batchTiming;
        return copy;
    }

    static class Builder {
        private String id;
        private String name;
        private float psp;
        private String contactDetails;
        private int batchId;
        private int instructorId;
        private String moduleName;
        private float batchPsp;
        private float batchAttendance;
        private String batchTiming;

        public Student.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Student.Builder name(String name) {
            this.name = name;
            return this;

        }

        public Student.Builder psp(float psp) {
            this.psp = psp;
            return this;

        }

        public Student.Builder contactDetails(String contactDetails) {
            this.contactDetails = contactDetails;
            return this;

        }

        public Student.Builder batchId(int batchId) {
            this.batchId = batchId;
            return this;

        }

        public Student.Builder instructorId(int instructorId) {
            this.instructorId = instructorId;
            return this;

        }

        public Student.Builder moduleName(String moduleName) {
            this.moduleName = moduleName;
            return this;

        }

        public Student.Builder batchPsp(float batchPsp) {
            this.batchPsp = batchPsp;
            return this;

        }

        public Student.Builder batchAttendance(float batchAttendance) {
            this.batchAttendance = batchAttendance;
            return this;

        }

        public Student.Builder batchTiming(String batchTiming) {
            this.batchTiming = batchTiming;
            return this;

        }

        private void validate() {
        }

        public Student build() {
            validate();
            return new Student(this);
        }

    }
}
