package com.nepxion.discovery.platform.server.mysql.service;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Ning Zhang
 * @version 1.0
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nepxion.discovery.platform.server.entity.dto.RouteGatewayDto;
import com.nepxion.discovery.platform.server.entity.dto.RouteZuulDto;
import com.nepxion.discovery.platform.server.mysql.mapper.MySqlRouteMapper;
import com.nepxion.discovery.platform.server.tool.DateTool;
import com.nepxion.discovery.platform.server.tool.MybatisPlusTool;

public class MySqlRouteService {
    @Autowired
    private MySqlRouteMapper mySqlRouteMapper;

    public Integer getNextMaxCreateTimesInDayOfGateway() {
        return mySqlRouteMapper.getNextMaxCreateTimesInDay(MybatisPlusTool.getTableName(RouteGatewayDto.class));
    }

    public Integer getNextMaxCreateTimesInDayOfZuul() {
        return mySqlRouteMapper.getNextMaxCreateTimesInDay(MybatisPlusTool.getTableName(RouteZuulDto.class));
    }

    public String getRouteId(String prefix, Integer nextMaxCreateTimesInDay) {
        return String.format("%s_%s_%s", prefix, DateTool.getDataSequence(), StringUtils.leftPad(String.valueOf(nextMaxCreateTimesInDay), 3, "0"));
    }
}