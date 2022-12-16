
package com.itlizesession.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "technical_detail")
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technical_detail_id")
    private int technicalDetailId;

    @Column(name = "airflow")
    private int airflow;

    @Column(name = "power")
    private int power;

    @Column(name = "operating_voltage")
    private int operatingVoltage;

    @Column(name = "fan_speed")
    private int fanSpeed;

    @Column(name = "sound_at_max_speed")
    private int soundAtMaxSpeed;

    @Column(name = "fan_sweep_diameter")
    private int fanSweepDiameter;

    @Column(name = "height")
    private int height;

    @OneToOne(mappedBy = "technicalDetail", cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Product product;

    public TechnicalDetail() {

    }

    public TechnicalDetail(int airflow, int power, int operatingVoltage, int fanSpeed, int soundAtMaxSpeed,
                           int fanSweepDiameter, int height) {
        this.airflow = airflow;
        this.power = power;
        this.operatingVoltage = operatingVoltage;
        this.fanSpeed = fanSpeed;
        this.soundAtMaxSpeed = soundAtMaxSpeed;
        this.fanSweepDiameter = fanSweepDiameter;
        this.height = height;
    }

    public int getTechnicalDetailId() {
        return technicalDetailId;
    }

    public void setTechnicalDetailId(int technicalDetailId) {
        this.technicalDetailId = technicalDetailId;
    }

    public int getAirflow() {
        return airflow;
    }

    public void setAirflow(int airflow) {
        this.airflow = airflow;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage(int operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public int getSoundAtMaxSpeed() {
        return soundAtMaxSpeed;
    }

    public void setSoundAtMaxSpeed(int soundAtMaxSpeed) {
        this.soundAtMaxSpeed = soundAtMaxSpeed;
    }

    public int getFanSweepDiameter() {
        return fanSweepDiameter;
    }

    public void setFanSweepDiameter(int fanSweepDiameter) {
        this.fanSweepDiameter = fanSweepDiameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "TechnicalDetail{" +
                "technicalDetailId=" + technicalDetailId +
                ", airflow=" + airflow +
                ", power=" + power +
                ", operatingVoltage=" + operatingVoltage +
                ", fanSpeed=" + fanSpeed +
                ", soundAtMaxSpeed=" + soundAtMaxSpeed +
                ", fanSweepDiameter=" + fanSweepDiameter +
                ", height=" + height +
                '}';
    }
}
