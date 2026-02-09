package com.example.projects.bookMyShowClassDiagramAssignment.registries;

import com.example.projects.bookMyShowClassDiagramAssignment.models.SeatIntrinsicData;
import com.example.projects.bookMyShowClassDiagramAssignment.models.contants.SeatType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatIntrinsicDataRegistry {
    private static SeatIntrinsicDataRegistry instance;
    private Map<SeatType, SeatIntrinsicData> data;

    private SeatIntrinsicDataRegistry() {
        data = new HashMap<>();
    }

    public static SeatIntrinsicDataRegistry getInstance() {
        if (instance == null) {
            instance = new SeatIntrinsicDataRegistry();
        }
        return instance;
    }

    public void add(SeatIntrinsicData seatIntrinsicData) {
        data.put(seatIntrinsicData.getSeatType(), seatIntrinsicData);
    }

    public SeatIntrinsicData remove(SeatType seatType) {
        return data.remove(seatType);
    }

    public SeatIntrinsicData get(SeatType seatType) {
        return data.get(seatType);
    }

    public Map<SeatType, SeatIntrinsicData> getData() {
        return data;
    }

    public void setData(Map<SeatType, SeatIntrinsicData> data) {
        this.data = data;
    }

    public List<SeatIntrinsicData> getAll() {
        return List.copyOf(data.values());
    }
}
