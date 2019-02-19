package com.zxs.ssh.template.dao.parking.api;

import com.zxs.ssh.template.model.ParkingModel;

import java.util.List;

/**
 * Project Name:log
 * File Name:IParkingLogDao
 * Package Name:com.yk.plap.log.dao.api
 * Date:2018/7/31
 * Author:zhanghualong
 * Description:
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

public interface IParkingLogDao {
    int add(ParkingModel parkingModel);
    int delete(String id);
    int update(String id);
    ParkingModel queryById(String id);
    List<ParkingModel> queryModels(String keyword);
}
