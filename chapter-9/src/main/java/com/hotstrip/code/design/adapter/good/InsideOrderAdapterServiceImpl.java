package com.hotstrip.code.design.adapter.good;

/**
 * @author hotstrip
 * 内部订单 service 适配器
 */
public class InsideOrderAdapterServiceImpl implements OrderAdapterService {
    @Override
    public boolean isFirst(String userId) {
        return false;
    }
}
