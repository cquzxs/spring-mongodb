package com.zxs.ssh.template.controller;

import com.zxs.ssh.template.model.ParkingModel;
import com.zxs.ssh.template.model.response.ResponseResult;
import com.zxs.ssh.template.service.parking.api.IParkingLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name:spring-mongodb
 * File Name:ParkingLogController
 * Package Name:com.zxs.ssh.template.controller
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@RestController("parkingLogController")
public class ParkingLogController {

    @Resource(name = "parkingLogService")
    private IParkingLogService parkingLogService;

    @PostMapping("parkingLog/add")
    public Object add(@RequestBody ParkingModel parkingModel) throws Exception {
        try{
            int res = this.parkingLogService.add(parkingModel);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @PostMapping("parkingLog/delete")
    public Object delete(@RequestParam String id) throws Exception {
        try{
            int res = this.parkingLogService.delete(id);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @PostMapping("parkingLog/update")
    public Object update(@RequestParam String id) throws Exception {
        try{
            int res = this.parkingLogService.update(id);
            Map<String,Object> map = new HashMap<>();
            map.put("count",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("parkingLog/queryById")
    public Object queryById(@RequestParam String id) throws Exception {
        try{
            ParkingModel res = this.parkingLogService.queryById(id);
            Map<String,Object> map = new HashMap<>();
            map.put("parkingLog",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("parkingLog/queryModels")
    public Object queryModels(@RequestParam String keyword) throws Exception {
        try{
            List<ParkingModel> res = this.parkingLogService.queryModels(keyword);
            Map<String,Object> map = new HashMap<>();
            map.put("parkingLog",res);
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, map, "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
}
