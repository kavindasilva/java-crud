package com.example.rentsystem;

import org.springframework.beans.factory.annotation.Autowired;

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

//    private CarRepository carRepository;
    @Autowired
    private VehicleRepository vr;
    // lorry repo also

    public VehicleResponse(Optional<Vehicle> vehicle, int purpose) {
        // return default if Vehicle is null
        if(!vehicle.isPresent()){
            return;
        }

        Vehicle thisVehicle = vehicle.get();
        this.id = thisVehicle.getId();
        this.license_expiry_date = thisVehicle.getLicense_expiry_date();
        this.color = thisVehicle.getColor();
        this.make = thisVehicle.getMake();
        this.model = thisVehicle.getModel();
        this.reg_no = thisVehicle.getReg_no();

//        this.
        if(purpose == this.VEHICLE_FOR_PUBLIC) {
            this.customAttr1 = "PUBLIC-vehicle";
            this.reg_no = thisVehicle.getReg_no().substring( 0, thisVehicle.getReg_no().length()-3 )+"xxx";
        }
        this.purposeParam = purpose;

        Optional<Vehicle> thisCar;
//        assert false;
//        Optional<Car> thisCar = carRepository.findById(this.id);
        try {
            thisCar = vr.findById(2);
        }
        catch (NullPointerException e){
            this.customAttr1 = "NULL-EXception";
        }
//        if(  thisCar.isPresent() ){
////        if( carRepository.findByVehicleId(1).isPresent() ){
////        if(true){
//            //
////            carRepository.find
//            this.purposeParam = 99;
//        }
    }
}