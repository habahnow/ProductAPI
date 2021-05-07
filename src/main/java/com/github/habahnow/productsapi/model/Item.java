package com.github.habahnow.productsapi.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {


    //TODO: add error messages
    @NotBlank(message = "Please include the part number.")
    @Id
    @CsvBindByName
    @Column(name = "part_number" , nullable = false)
    private String partNumber;

    @NotNull(message = "Please include the import price.")
    @PositiveOrZero(message = "Import price must be positive or zero.")
    @CsvBindByName
    @Column(name = "import_price")
    private BigDecimal importPrice;

    @CsvBindByName
    @Column(name = "quantity_price_breaks_id")
    private int quantityPriceBreaksID;

    @CsvBindByName
    @Column(name = "price_breaks_mark_ups_id")
    private int priceBreakMarkUpsID;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public BigDecimal getImportPrice() {
        return importPrice;
//        return importPrice.round(new MathContext(3));
    }

    public void setImportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public int getQuantityPriceBreaksID() {
        return quantityPriceBreaksID;
    }

    public void setQuantityPriceBreaksID(int quantityPriceBreaksID) {
        this.quantityPriceBreaksID = quantityPriceBreaksID;
    }

    public int getPriceBreakMarkUpsID() {
        return priceBreakMarkUpsID;
    }

    public void setPriceBreakMarkUpsID(int priceBreakMarkUpsID) {
        this.priceBreakMarkUpsID = priceBreakMarkUpsID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getPartNumber().equals(item.getPartNumber()) &&
                Objects.equals(getImportPrice(), item.getImportPrice()) &&
                Objects.equals(getQuantityPriceBreaksID(),
                        item.getQuantityPriceBreaksID()) &&
                Objects.equals(getPriceBreakMarkUpsID(),
                        item.getPriceBreakMarkUpsID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartNumber(), getImportPrice(),
                getQuantityPriceBreaksID(), getPriceBreakMarkUpsID() );
    }
}