package com.zxs.ssh.template.service.parking.api;

import com.zxs.ssh.template.model.ParkingModel;

import java.util.List;

/**
 * Project Name:spring-mongodb
 * File Name:IParkingLogService
 * Package Name:com.zxs.ssh.template.service.parking.api
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IParkingLogService {
    int add(ParkingModel parkingModel)throws Exception;
    int delete(String id)throws Exception;
    int update(String id)throws Exception;
    ParkingModel queryById(String id)throws Exception;
    List<ParkingModel> queryModels(String keyword)throws Exception;
}
