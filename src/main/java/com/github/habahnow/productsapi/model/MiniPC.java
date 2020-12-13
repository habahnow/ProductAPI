package com.github.habahnow.productsapi.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "mini_pc")
public class MiniPC extends Item {

    //TODO: read up on message for @NotNUll. i think i can add error messages

    @NotBlank
    @CsvBindByName
    @Column(name = "cpu_name")
    private String cpuName;

    @NotNull
    @CsvBindByName
    @Column(name = "cpu_speed")
    //Speed in GHz
    private Long cpuSpeed;

    @NotNull
    @CsvBindByName
    private Long cores;

    @NotNull
    @CsvBindByName
    @Column(name = "usb3_ports_external")
    private int usb3PortsExternal;

    @NotNull
    @CsvBindByName
    @Column(name = "usb2_ports_external")
    private int usb2PortsExternal;

    @NotNull
    @CsvBindByName
    @Column(name = "hdmi_ports")
    private int hdmiPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "vga_ports")
    private int vgaPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "com_ports")
    private int comPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "giga_lan_ports")
    private int gigaLanPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "fast_lan_ports")
    private int fastLanPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "audio_out_ports")
    private int audioOutPorts;

    @NotNull
    @CsvBindByName
    @Column(name = "mic_in_ports")
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
    @Column(name = "sim_card_slots")
    private int simCardSlots;

    @NotNull
    @CsvBindByName
    @Column(name = "mpcie_slots")
    private int mPCIESlots;

    @NotNull
    @CsvBindByName
    @Column(name = "msata_slots")
    private int mSataSlots;

    @NotNull
    @CsvBindByName
    @Column(name = "msata_combined_mpcie_slots")
    private int mSataCombinedMpcieSlots;

    @NotNull
    @CsvBindByName
    @Column(name = "sata_connectors")
    private int sataConnectors;

    @NotNull
    @CsvBindByName
    @Column(name = "slimsata_connectors")
    private int slimSataConnectors;

    public MiniPC(){
        this.setPriceBreakMarkUpsID(1);
        this.setQuantityPriceBreaksID(1);
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
        return Objects.hash(this.cpuName,this.cpuSpeed,
                this.cores, this.hdmiPorts, this.usb2PortsExternal,
                this.usb3PortsExternal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiniPC)) return false;
        if (!super.equals(o)) return false;
        MiniPC miniPC = (MiniPC) o;
        return getUsb3PortsExternal() == miniPC.getUsb3PortsExternal() && //
                getUsb2PortsExternal() == miniPC.getUsb2PortsExternal() && //
                getHdmiPorts() == miniPC.getHdmiPorts() && //
                getVgaPorts() == miniPC.getVgaPorts() && //
                getComPorts() == miniPC.getComPorts() && //
                getGigaLanPorts() == miniPC.getGigaLanPorts() && //
                getFastLanPorts() == miniPC.getFastLanPorts() && //
                getAudioOutPorts() == miniPC.getAudioOutPorts() && //
                getMicInPorts() == miniPC.getMicInPorts() && //
                getSimCardSlots() == miniPC.getSimCardSlots() && //
                getmPCIESlots() == miniPC.getmPCIESlots() &&//
                getmSataSlots() == miniPC.getmSataSlots() &&//
                getmSataCombinedMpcieSlots() == //
                        miniPC.getmSataCombinedMpcieSlots() &&//
                getSataConnectors() == miniPC.getSataConnectors() &&//
                getSlimSataConnectors() == miniPC.getSlimSataConnectors() &&//
                getCpuName().equals(miniPC.getCpuName()) &&//
                Objects.equals(getCpuSpeed(), miniPC.getCpuSpeed()) &&//
                Objects.equals(getCores(), miniPC.getCores()) &&//
                Objects.equals(getRam(), miniPC.getRam()) &&//
                Objects.equals(geteMMC(), miniPC.geteMMC());
    }

    @Override
    public String toString() {
        return "MiniPC {" +
                "partNumber=" + this.getPartNumber()+
                ", importPrice=" + this.getImportPrice()+
                ", quantity Price Breaks=" + this.getQuantityPriceBreaksID() +
                ", Price Break Mark ups=" + this.getPriceBreakMarkUpsID() +
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
