package com.example.projects.parkingLotSystemAssignment.models;

import com.example.projects.parkingLotSystemAssignment.models.constants.GateStatus;
import com.example.projects.parkingLotSystemAssignment.models.constants.GateType;

public class Gate extends BaseModel {
    private String name;
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;

    public Gate() {
    }

    public Gate(String name, Operator operator, GateType gateType, GateStatus gateStatus) {
        this.name = name;
        this.operator = operator;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
