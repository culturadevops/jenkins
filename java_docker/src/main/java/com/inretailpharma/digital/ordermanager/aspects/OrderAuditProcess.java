package com.inretailpharma.digital.ordermanager.aspects;


import com.inretailpharma.digital.ordermanager.canonical.OrderFulfillmentCanonical;
import com.inretailpharma.digital.ordermanager.proxy.OrderExternalService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class OrderAuditProcess {

    private final OrderExternalService orderExternalService;

    public OrderAuditProcess(@Qualifier("auditProxy") OrderExternalService orderExternalService) {
        this.orderExternalService = orderExternalService;
    }

    @AfterReturning(value = "execution(* com.inretailpharma.digital.ordermanager.facade.*.*(..))", returning="retVal")
    public void afterCreateOrderFulfillment(JoinPoint joinPoint, Object retVal) {
        log.info("Success aop process {} - {}",joinPoint.getTarget(), retVal);

        if (retVal instanceof OrderFulfillmentCanonical) {
            orderExternalService.sendOrder((OrderFulfillmentCanonical)retVal);
        } else {
            // send to audit microservice to update the order
        }


    }
}
