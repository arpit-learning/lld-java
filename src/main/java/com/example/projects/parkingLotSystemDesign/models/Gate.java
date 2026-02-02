package com.example.projects.parkingLotSystemDesign.models;

import com.example.projects.parkingLotSystemDesign.models.constants.GateStatus;
import com.example.projects.parkingLotSystemDesign.models.constants.GateType;

public class Gate extends BaseModel {
    private GateType type;
    private GateStatus status;
    private Operator operator;

    public Gate(GateType type, GateStatus status, Operator operator) {
        this.type = type;
        this.status = status;
        this.operator = operator;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
