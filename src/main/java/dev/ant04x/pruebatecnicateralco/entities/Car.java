package dev.ant04x.pruebatecnicateralco.entities;

import javax.persistence.*;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String modelName;
  private String colorName;
  @ManyToOne
  private Brand carBrandIdFk;


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

}
