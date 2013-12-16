package com.motors.model.account;

import com.motors.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PICTURE", schema = "carservice")
public class UserPicture extends BaseEntity {

    @Column(name = "PICTURE_NAME")
    private String pictureName;

    @Column(name = "IMAGE", columnDefinition = "mediumblob")
    private byte[] image;

    @ManyToOne
    private User user;

    public UserPicture() {
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
