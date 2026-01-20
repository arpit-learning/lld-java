package com.example.designPatterns.creationalDesignPatterns.registry;

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

    public static void main(String[] args) {
        Student lldMWFBatch = new Student();
        lldMWFBatch.setBatchId(1);
        lldMWFBatch.setInstructorId(1);
        lldMWFBatch.setBatchAttendance(100);
        lldMWFBatch.setBatchPsp(90);
        lldMWFBatch.setModuleName("LLD");
        lldMWFBatch.setBatchTiming("MWF 10:00 AM - 11:00 AM");

        Student lldTTSBatch = new Student();
        lldMWFBatch.setBatchId(1);
        lldMWFBatch.setInstructorId(1);
        lldMWFBatch.setBatchAttendance(100);
        lldMWFBatch.setBatchPsp(90);
        lldMWFBatch.setModuleName("LLD");
        lldMWFBatch.setBatchTiming("TTS 10:00 AM - 11:00 AM");

        Student dsaMWFBatch = new Student();
        lldMWFBatch.setBatchId(1);
        lldMWFBatch.setInstructorId(1);
        lldMWFBatch.setBatchAttendance(100);
        lldMWFBatch.setBatchPsp(90);
        lldMWFBatch.setModuleName("DSA");
        lldMWFBatch.setBatchTiming("MWF 10:00 AM - 11:00 AM");

        Student dsaTTSBatch = new Student();
        lldMWFBatch.setBatchId(1);
        lldMWFBatch.setInstructorId(1);
        lldMWFBatch.setBatchAttendance(100);
        lldMWFBatch.setBatchPsp(90);
        lldMWFBatch.setModuleName("DSA");
        lldMWFBatch.setBatchTiming("TTS 10:00 AM - 11:00 AM");

        StudentRegistry registry = StudentRegistry.getInstance();
        registry.addPrototype(BatchType.LLD_MWF, lldMWFBatch);
        registry.addPrototype(BatchType.LLD_TTS, lldTTSBatch);
        registry.addPrototype(BatchType.DSA_MWF, dsaMWFBatch);
        registry.addPrototype(BatchType.DSA_MWF, dsaTTSBatch);

        // Student rohit from lld batch
        Student rohit = registry.getPrototype(BatchType.LLD_MWF).copy();
        rohit.setId("10");
        rohit.setName("Rohit");
        rohit.setPsp(80);
        rohit.setContactDetails("Place A, City B");

        System.out.println(rohit);
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
        copy.moduleName = this.moduleName;
        copy.batchPsp = this.batchPsp;
        copy.batchAttendance = this.batchAttendance;
        copy.batchTiming = this.batchTiming;
        return copy;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", psp=" + psp + ", contactDetails=" + contactDetails +
                ", batchId=" + batchId + ", instructorId=" + instructorId + ", moduleName=" + moduleName + ", batchPsp="
                + batchPsp + ", batchAttendance=" + batchAttendance + ", batchTiming=" + batchTiming + "]";
    }
}
