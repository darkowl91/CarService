package com.motors.model.auto;

import com.motors.model.BaseEntity;
import com.motors.programm.util.ImageUtil;

import javax.persistence.*;

@Entity
@Table(name = "CAR_PICTURE", schema = "carservice")
public class CarPicture extends BaseEntity {

    @Column(name = "PICTURE_NAME")
    private String pictureName;

    @Column(name = "IMAGE", columnDefinition = "mediumblob")
    private byte[] image;

    @ManyToOne
    private Car car;

    @Transient
    private String imageAsString;

    public CarPicture(String pictureName, byte[] image) {
        this.pictureName = pictureName;
        this.image = image;
    }

    public CarPicture() {
    }


    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageAsString() {
        return ImageUtil.getInstance().getEncoded(image, "");
    }
}
