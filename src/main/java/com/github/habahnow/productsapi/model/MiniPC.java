package com.github.habahnow.productsapi.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class MiniPC {

    //TODO: read up on message for @NotNUll. i think i can add error messages
    @NotBlank
    @Id
    @CsvBindByName
    private String partNumber;

    @NotBlank
    @CsvBindByName
    private String cpuName;

    @NotNull
    @CsvBindByName
    //Speed in GHz
    private Long cpuSpeed;

    @NotNull
    @CsvBindByName
    private Long cores;

    @NotNull
    @CsvBindByName
    private int usb3PortsExternal;

    @NotNull
    @CsvBindByName
    private int usb2PortsExternal;

    @NotNull
    @CsvBindByName
    private int hdmiPorts;

    @NotNull
    @CsvBindByName
    private int vgaPorts;

    @NotNull
    @CsvBindByName
    private int comPorts;

    @NotNull
    @CsvBindByName
    private int gigaLanPorts;

    @NotNull
    @CsvBindByName
    private int fastLanPorts;

    @NotNull
    @CsvBindByName
    private int audioOutPorts;

    @NotNull
    @CsvBindByName
    private int micInPorts;

    @NotNull
    @CsvBindByName
    //Ram in Gigabytes
    private Long ram;

    @NotNull
    @CsvBindByName
    //eMMC in gigabytes
    private Long eMMC;

    @NotNull
    @CsvBindByName
    private int simCardSlots;

    @NotNull
    @CsvBindByName
    private int mPCIESlots;

    @NotNull
    @CsvBindByName
    private int mSataSlots;

    @NotNull
    @CsvBindByName
    private int mSataCombinedMpcieSlots;

    @NotNull
    @CsvBindByName
    private int sataConnectors;

    @NotNull
    @CsvBindByName
    private int slimSataConnectors;


    public String getPartNumber() {
        return partNumber;
    }

    public MiniPC(){

    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public Long getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Long cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public Long getCores() {
        return cores;
    }

    public void setCores(Long cores) {
        this.cores = cores;
    }

    public int getUsb3PortsExternal() {
        return usb3PortsExternal;
    }

    public void setUsb3PortsExternal(int usb3PortsExternal) {
        this.usb3PortsExternal = usb3PortsExternal;
    }

    public int getUsb2PortsExternal() {
        return usb2PortsExternal;
    }

    public void setUsb2PortsExternal(int usb2PortsExternal) {
        this.usb2PortsExternal = usb2PortsExternal;
    }

    public int getHdmiPorts() {
        return hdmiPorts;
    }

    public void setHdmiPorts(int hdmiPorts) {
        this.hdmiPorts = hdmiPorts;
    }

    public int getVgaPorts() {
        return vgaPorts;
    }

    public void setVgaPorts(int vgaPorts) {
        this.vgaPorts = vgaPorts;
    }

    public int getComPorts() {
        return comPorts;
    }

    public void setComPorts(int comPorts) {
        this.comPorts = comPorts;
    }

    public int getGigaLanPorts() {
        return gigaLanPorts;
    }

    public void setGigaLanPorts(int gigaLanPorts) {
        this.gigaLanPorts = gigaLanPorts;
    }

    public int getFastLanPorts() {
        return fastLanPorts;
    }

    public void setFastLanPorts(int fastLanPorts) {
        this.fastLanPorts = fastLanPorts;
    }

    public int getAudioOutPorts() {
        return audioOutPorts;
    }

    public void setAudioOutPorts(int audioOutPorts) {
        this.audioOutPorts = audioOutPorts;
    }

    public int getMicInPorts() {
        return micInPorts;
    }

    public void setMicInPorts(int micInPorts) {
        this.micInPorts = micInPorts;
    }

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public Long geteMMC() {
        return eMMC;
    }

    public void seteMMC(Long eMMC) {
        this.eMMC = eMMC;
    }

    public int getSimCardSlots() {
        return simCardSlots;
    }

    public void setSimCardSlots(int simCardSlots) {
        this.simCardSlots = simCardSlots;
    }

    public int getmPCIESlots() {
        return mPCIESlots;
    }

    public void setmPCIESlots(int mPCIESlots) {
        this.mPCIESlots = mPCIESlots;
    }

    public int getmSataSlots() {
        return mSataSlots;
    }

    public void setmSataSlots(int mSataSlots) {
        this.mSataSlots = mSataSlots;
    }

    public int getmSataCombinedMpcieSlots() {
        return mSataCombinedMpcieSlots;
    }

    public void setmSataCombinedMpcieSlots(int mSataCombinedMpcieSlots) {
        this.mSataCombinedMpcieSlots = mSataCombinedMpcieSlots;
    }

    public int getSataConnectors() {
        return sataConnectors;
    }

    public void setSataConnectors(int sataConnectors) {
        this.sataConnectors = sataConnectors;
    }

    public int getSlimSataConnectors() {
        return slimSataConnectors;
    }

    public void setSlimSataConnectors(int slimSataConnectors) {
        this.slimSataConnectors = slimSataConnectors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.partNumber, this.cpuName,this.cpuSpeed,
                this.cores, this.hdmiPorts, this.usb2PortsExternal,
                this.usb3PortsExternal);
    }

    @Override
    public String toString() {
        return "Device{" +
                "partNumber=" + partNumber +
                ", CPUName='" + cpuName + '\'' +
                ", CPUSpeed=" + cpuSpeed +
                ", cores=" + cores +
                ", usb3PortsExternal=" + usb3PortsExternal +
                ", usb2PortsExternal=" + usb2PortsExternal +
                ", hdmiPorts=" + hdmiPorts +
                ", vgaPorts=" + vgaPorts +
                ", comPorts=" + comPorts +
                ", gigaLanPorts=" + gigaLanPorts +
                ", fastLanPorts=" + fastLanPorts +
                ", audioOutPorts=" + audioOutPorts +
                ", micInPorts=" + micInPorts +
                ", ram=" + ram +
                ", eMMC=" + eMMC +
                ", simCardSlots=" + simCardSlots +
                ", mPCIESlots=" + mPCIESlots +
                ", mSataSlots=" + mSataSlots +
                ", mSataCombinedMpcieSlots=" + mSataCombinedMpcieSlots +
                ", sataConnectors=" + sataConnectors +
                ", slimSataConnectors=" + slimSataConnectors +
                '}';
    }
}
