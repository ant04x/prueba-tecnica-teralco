package dev.ant04x.pruebatecnicateralco.responses;

import java.sql.Timestamp;

public class PriceByCarAndDateObject {
    private long carId;
    private long brandId;
    private long priceId;
    private double priceCost;
    private java.sql.Timestamp priceStartDate;
    private java.sql.Timestamp priceEndDate;

    public PriceByCarAndDateObject(
            long carId,
            long brandId,
            long priceId,
            double priceCost,
            Timestamp priceStartDate,
            Timestamp priceEndDate
    ) {
        this.carId = carId;
        this.brandId = brandId;
        this.priceId = priceId;
        this.priceCost = priceCost;
        this.priceStartDate = priceStartDate;
        this.priceEndDate = priceEndDate;
    }
}
