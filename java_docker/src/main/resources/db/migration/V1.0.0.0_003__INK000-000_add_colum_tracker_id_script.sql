--
-- Alter table order_fulfillment add column name_service
--
ALTER TABLE `order_fulfillment` ADD COLUMN `tracker_id` bigint(20) DEFAULT NULL AFTER `ecommerce_purchase_id`;

