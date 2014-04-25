package com.forest.handlers;

import com.forest.events.OrderEvent;

/**
 *
 * @author markito
 */
public interface IOrderHandler  {
    
    public void onNewOrder(OrderEvent event);
    
}
