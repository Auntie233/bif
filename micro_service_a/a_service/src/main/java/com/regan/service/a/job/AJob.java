package com.regan.service.a.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class AJob {

    Log logger = LogFactory.getLog(AJob.class);

    @XxlJob("countOne2Ten")
    public ReturnT<String> countOne2Ten(String name) {
        logger.info("Hello "+name);
        for (int i=0; i<10; i++) {
            logger.info("Read after me: "+(i+1));
        }
        return ReturnT.SUCCESS;
    }

}
