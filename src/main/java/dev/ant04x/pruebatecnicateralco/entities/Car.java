package dev.ant04x.pruebatecnicateralco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String modelName;
  private String colorName;
  @ManyToOne
  private Brand carBrandIdFk;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL)
  private List<Price> prices;


  public Car() {}


  public Car(String modelName, String colorName, Brand carBrandIdFk) {
    setModelName(modelName);
    setColorName(colorName);
    setCarBrandIdFk(carBrandIdFk);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }


  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }

  public Brand getCarBrandIdFk() {
    return carBrandIdFk;
  }

  public void setCarBrandIdFk(Brand carBrandIdFk) {
    this.carBrandIdFk = carBrandIdFk;
  }

  public List<Price> getPrices() {
    return prices;
  }

  public void setPrices(List<Price> prices) {
    this.prices = prices;
  }

  public static List<String> getColumns() {
    return new ArrayList<>(){
      {
        add("id");
        add("modelName");
        add("colorName");
        add("carBrandIdFk");
        add("prices");
      }
    };
  }
}
