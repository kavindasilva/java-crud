package com.example.rentsystem;

import javax.persistence.*;
import java.util.Optional;

public class VehicleResponse {
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


    public VehicleResponse(Optional<Vehicle> vehicle, int purp) {
        this.id = vehicle.get().getId();
        this.reg_no = vehicle.get().getReg_no();
        this.license_expiry_date = vehicle.get().getLicense_expiry_date();
        this.color = vehicle.get().getColor();
        this.make = vehicle.get().getMake();
        this.model = vehicle.get().getModel();

//        this.
        this.customAttr1 = "KK";
    }
}