package com.cdac.acts.printer;

import java.io.Serializable;
import java.time.LocalDate;

public class Printer implements Serializable {

//	private static final long serialVersionUID = 7362842029908941037L;
//	private static final long serialVersionUID = 1L;
	private String serialNo;
    private String modelNo;
    private double price;
    private PrinterType printerType;
    private LocalDate manufacturingDate;

    public Printer(String serialNo, String modelNo, double price, PrinterType printerType, LocalDate manufacturingDate) {
        this.serialNo = serialNo;
        this.modelNo = modelNo;
        this.price = price;
        this.printerType = printerType;
        this.manufacturingDate = manufacturingDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Printer [Serial No=" + serialNo + ", Model No=" + modelNo + ", Price=" + price +
               ", Type=" + printerType + ", Mfg Date=" + manufacturingDate + "]";
    }
}
