--
-- Alter table add column name_service
--
ALTER TABLE `service_type` ADD COLUMN `name` VARCHAR(32) NULL AFTER `code`;
ALTER TABLE `order_process_status` ADD COLUMN `attempt_tracker` int(11) NULL AFTER `attempt`;
