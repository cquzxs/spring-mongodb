package com.zxs.ssh.template.service.parking.impl;

import com.zxs.ssh.template.dao.parking.api.IParkingLogDao;
import com.zxs.ssh.template.model.ParkingModel;
import com.zxs.ssh.template.service.parking.api.IParkingLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project Name:spring-mongodb
 * File Name:ParkingLogLogServiceImpl
 * Package Name:com.zxs.ssh.template.service.parking.impl
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("parkingLogService")
public class ParkingLogLogServiceImpl implements IParkingLogService {

    @Resource(name = "parkingLogDao")
    private IParkingLogDao parkingLogDao;

    @Override
    public int add(ParkingModel parkingModel) throws Exception {
        checkAdd(parkingModel);
        return this.parkingLogDao.add(parkingModel);
    }

    private void checkAdd(ParkingModel parkingModel) throws Exception{
        if(parkingModel == null){
            throw new Exception("参数不能为空");
        }
        if(parkingModel.getTime()==null){
            throw new Exception("时间不能为空");
        }
        if(parkingModel.getRobotId()==null || parkingModel.getRobotId().isEmpty()){
            throw new Exception("道口ID不能为空");
        }
        if(parkingModel.getPlate()==null || parkingModel.getPlate().isEmpty()){
            throw new Exception("车牌不能为空");
        }
        if(parkingModel.getLevel()==null || parkingModel.getLevel().isEmpty()){
            throw new Exception("日志级别不能为空");
        }
        if(parkingModel.getMessage()==null || parkingModel.getMessage().isEmpty()){
            throw new Exception("日志内容不能为空");
        }
    }

    @Override
    public int delete(String id) throws Exception {
        if(id==null || id.isEmpty()){
            throw new Exception("id不能为空");
        }
        return this.parkingLogDao.delete(id);
    }

    @Override
    public int update(String id) throws Exception {
        if(id==null || id.isEmpty()){
            throw new Exception("id不能为空");
        }
        return this.parkingLogDao.update(id);
    }

    @Override
    public ParkingModel queryById(String id) throws Exception {
        if(id==null || id.isEmpty()){
            throw new Exception("id不能为空");
        }
        return this.parkingLogDao.queryById(id);
    }

    @Override
    public List<ParkingModel> queryModels(String keyword) throws Exception {
        return this.parkingLogDao.queryModels(keyword);
    }
}
