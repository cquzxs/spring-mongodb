package com.zxs.ssh.template.dao.parking.impl;

import com.zxs.ssh.template.dao.parking.api.IParkingLogDao;
import com.zxs.ssh.template.model.ParkingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project Name:log
 * File Name:ParkingLogDaoImpl
 * Package Name:com.yk.plap.log.dao.impl
 * Date:2018/7/31
 * Author:zhanghualong
 * Description:
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */
@Repository("parkingLogDao")
public class ParkingLogDaoImpl implements IParkingLogDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate originMongoTemplate;

    @Value("${mongo.collection.name}")
    private String originParking;

    @Override
    public int add(ParkingModel parkingModel) {
        originMongoTemplate.insert(parkingModel,originParking);
        return 1;
    }

    @Override
    public int delete(String id) {
        ParkingModel parkingModel = new ParkingModel();
        parkingModel.setId(id);
        return (int)originMongoTemplate.remove(parkingModel,originParking).getDeletedCount();
    }

    @Override
    public int update(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("Plate","123456");
        return (int)originMongoTemplate.updateFirst(query,update,originParking).getMatchedCount();
    }

    @Override
    public ParkingModel queryById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        query.limit(10);
        List<ParkingModel> list = originMongoTemplate.find(query,ParkingModel.class,originParking);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ParkingModel> queryModels(String keyword) {
        Query query = new Query();
        String pattern = "^.*"+keyword+".*$";
        query.addCriteria(Criteria.where("Message").regex(pattern));
        query.limit(10);
        return originMongoTemplate.find(query,ParkingModel.class,originParking);
    }
}
