package com.atguigu.cloud.order.feign;

import feign.RetryableException;
import feign.Retryer;
import org.apache.http.impl.io.SocketOutputBuffer;

public class FeignClientRetryer implements Retryer {

    private int start = 1;
    private int end = 3;

    @Override
    public void continueOrPropagate(RetryableException e) {
        System.out.println("retrying");
        if(start >= end){
            throw new RuntimeException(e);
        }
        start++;
    }

    @Override
    public Retryer clone() {
        return new FeignClientRetryer();
    }
}
