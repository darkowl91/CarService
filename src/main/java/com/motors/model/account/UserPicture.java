package com.motors.model.account;

import com.motors.model.BaseEntity;
import com.motors.programm.util.ImageUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_PICTURE", schema = "carservice")
public class UserPicture extends BaseEntity {

    private static final long serialVersionUID = 5938238834247670972L;

    @Column(name = "PICTURE_NAME")
    private String pictureName;

    @Column(name = "IMAGE", columnDefinition = "mediumblob")
    private byte[] image;

    @Transient
    private String imageAsString;

    public UserPicture() {
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
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
