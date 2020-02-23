package com.inretailpharma.digital.ordermanager.repository;

import com.inretailpharma.digital.ordermanager.entity.OrderFulfillment;
import com.inretailpharma.digital.ordermanager.entity.projection.IOrderFulfillment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<OrderFulfillment, Long> {

    @Query(value = "select o.ecommerce_purchase_id as orderId, o.scheduled_time as leadTime, " +
            "o.document_number as documentNumber, o.total_cost as totalAmount, p.payment_type as paymentMethod, " +
            "l.code as localCode, l.name as local, c.name as company, " +
            "s.order_status_code as statusCode, s.status_detail as statusDetail, os.type as status " +
            "from order_fulfillment o " +
            "inner join payment_method p on o.id = p.order_fulfillment_id " +
            "inner join order_process_status s on o.id = s.order_fulfillment_id " +
            "inner join order_status os on s.order_status_code = os.code " +
            "inner join local l on s.local_code = l.code " +
            "inner join company c on l.company_code = c.code " +
            "where o.status in :status",
            nativeQuery = true
    )
    List<IOrderFulfillment> getListOrdersByStatus(@Param("status") Set<String> status);

    OrderFulfillment getOrderFulfillmentByEcommercePurchaseIdIs(Long ecommerceId);

    @Query(value = "select o.id as orderId, " +
            "s.order_status_code as statusCode, s.attempt as attempt, s.attempt_tracker as attemptTracker, " +
            "st.code as serviceTypeCode, st.name as serviceTypeName " +
            "from order_fulfillment o " +
            "inner join order_process_status s on o.id = s.order_fulfillment_id " +
            "inner join service_type st on s.service_type_code = st.code " +
            "where o.ecommerce_purchase_id = :ecommerceId",
            nativeQuery = true
    )
    IOrderFulfillment getOrderByecommerceId(@Param("ecommerceId") Long ecommerceId);

    @Modifying
    @Transactional
    @Query(value = "Update order_fulfillment " +
            " set external_purchase_id = :externalPurchaseId " +
            " where order_fulfillment_id = :orderFulfillmentId",
            nativeQuery = true)
    void updateExternalPurchaseId(@Param("orderFulfillmentId") Long orderFulfillmentId,
                                  @Param("externalPurchaseId") Long externalPurchaseId
    );

    @Modifying
    @Transactional
    @Query(value = "Update order_fulfillment " +
            " set tracker_id = :trackerId " +
            " where id = :orderFulfillmentId",
            nativeQuery = true)
    void updateTrackerId(@Param("orderFulfillmentId") Long orderFulfillmentId,
                                  @Param("trackerId") Long trackerId
    );

    @Modifying
    @Transactional
    @Query(value = "Update order_fulfillment " +
            " set tracker_id = :trackerId, external_purchase_id = :externalPurchaseId " +
            " where id = :orderFulfillmentId",
            nativeQuery = true)
    void updateExternalAndTrackerId(@Param("orderFulfillmentId") Long orderFulfillmentId,
                                                   @Param("externalPurchaseId") Long externalPurchaseId,
                                                   @Param("trackerId") Long trackerId);
}
