package com.zxs.ssh.template.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Project Name:log
 * File Name:ParkingModel
 * Package Name:com.yk.plap.log.model
 * Date:2018/7/31
 * Author:zhanghualong
 * Description:
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */
@Document(collection = "parking")
public class ParkingModel {
    @Id
    private String id;

    @Indexed(direction = IndexDirection.DESCENDING)
    @Field("Time")
    private Date time;
    @Field("RobotId")
    private String robotId;
    @Field("Plate")
    private String plate;
    @Field("Level")
    private String level;
    @Field("Message")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingModel that = (ParkingModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (robotId != null ? !robotId.equals(that.robotId) : that.robotId != null) return false;
        if (plate != null ? !plate.equals(that.plate) : that.plate != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (robotId != null ? robotId.hashCode() : 0);
        result = 31 * result + (plate != null ? plate.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParkingModel{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", robotId='" + robotId + '\'' +
                ", plate='" + plate + '\'' +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
