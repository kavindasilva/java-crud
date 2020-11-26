package com.example.rentsystem;

import javax.persistence.*;
import java.util.Optional;

public class VehicleResponse {
    protected final int VEHICLE_FOR_ADMIN = 1;
    protected final int VEHICLE_FOR_PUBLIC = 2;

    public Integer id = 0;
    public String reg_no = "WPGA-0099";
    public String license_expiry_date = "2020-12-31";
    public String color = "white";
    public String make = "Default make";
    public String model = "Default model";
    public String transmission = "";
    public boolean available = false;
    public boolean deleted = false;

    private int owner_id = 1;
    private int subEntity = 1; // Car, lorry
    public String customAttr1 = "";
    public int purposeParam = 0;


    public VehicleResponse(Optional<Vehicle> vehicle, int purpose) {
        //@TODO: handle null vehicle

        Vehicle thisVehicle = vehicle.get();
        this.id = thisVehicle.getId();
        this.license_expiry_date = thisVehicle.getLicense_expiry_date();
        this.color = thisVehicle.getColor();
        this.make = thisVehicle.getMake();
        this.model = thisVehicle.getModel();

//        this.
        if(purpose == this.VEHICLE_FOR_PUBLIC) {
            this.customAttr1 = "PUBLIC-vehicle";
            this.reg_no = "hidden";
        }
        this.purposeParam = purpose;
    }
}