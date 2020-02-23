--
-- Table structure for table `application_parameter`
--
DROP TABLE IF EXISTS `application_parameter`;
CREATE TABLE `application_parameter` (
  `code` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `value` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `order_status`
--
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `code` varchar(16) NOT NULL,
  `type` varchar(32) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `service_type`
--
DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_type` (
  `code` varchar(32) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `company`
--
DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `code` varchar(16) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `local`
--
DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `code` varchar(16) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `company_code` varchar(32) NOT NULL,
  PRIMARY KEY (`code`),
  CONSTRAINT `local_fk_1` FOREIGN KEY (`company_code`) REFERENCES `company` (`code`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `order_tracker`
--

DROP TABLE IF EXISTS `order_fulfillment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_fulfillment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source` varchar(5) NOT NULL,
  `ecommerce_purchase_id` bigint(20) DEFAULT NULL,
  `external_purchase_id` bigint(20) DEFAULT NULL,
  `bridge_purchase_id` bigint(20) DEFAULT NULL,
  `total_cost` decimal(10,2) DEFAULT NULL,
  `delivery_cost` decimal(10,2) DEFAULT NULL,
  `document_number` varchar(16) NOT NULL,
  `created_order` datetime NOT NULL,
  `scheduled_time` datetime NOT NULL,
  `notes` varchar(200) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_updated_by` varchar(100) DEFAULT NULL,
  `date_last_updated` datetime DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `OrderFulfillmentItem`
--
DROP TABLE IF EXISTS `order_fulfillment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_fulfillment_item` (
  `order_fulfillment_id` bigint(20) NOT NULL,
  `product_code` varchar(16) NOT NULL,
  `product_sap_code` varchar(10) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `short_description` varchar(1000) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `fractionated` char(1) DEFAULT NULL,
  KEY `order_fulfillment_id` (`order_fulfillment_id`),
  CONSTRAINT `order_fulfillment_item_ibfk_1` FOREIGN KEY (`order_fulfillment_id`) REFERENCES `order_fulfillment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_method` (
  `order_fulfillment_id` bigint(20) NOT NULL,
  `payment_type` varchar(15) NOT NULL,
  `card_provider` varchar(50) DEFAULT NULL,
  `card_name` varchar(100) DEFAULT NULL,
  `card_number` char(4) DEFAULT NULL,
  `paid_amount` decimal(10,2) DEFAULT NULL,
  `change_amount` decimal(10,2) DEFAULT NULL,
  `payment_note` varchar(100) DEFAULT NULL,
  KEY `order_fulfillment_id` (`order_fulfillment_id`),
  CONSTRAINT `payment_method_ibfk_1` FOREIGN KEY (`order_fulfillment_id`) REFERENCES `order_fulfillment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `receipt_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt_type` (
  `order_fulfillment_id` bigint(20) NOT NULL,
  `name` varchar(15) NOT NULL,
  `document_number` varchar(8) NOT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `company_address` varchar(100) DEFAULT NULL,
  `receipt_note` varchar(100) DEFAULT NULL,
  KEY `order_fulfillment_id` (`order_fulfillment_id`),
  CONSTRAINT `receipt_type_ibfk_1` FOREIGN KEY (`order_fulfillment_id`) REFERENCES `order_fulfillment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `service_local_tracker`
--
DROP TABLE IF EXISTS `order_process_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_process_status` (
  `service_type_code` varchar(32) NOT NULL,
  `local_code` varchar(16) NOT NULL,
  `order_fulfillment_id` bigint(20) NOT NULL,
  `order_status_code` varchar(16) NOT NULL,
  `lead_time` int(11) DEFAULT NULL,
  `days_to_pickup` int(11) DEFAULT NULL,
  `start_hour` time DEFAULT NULL,
  `end_hour` time DEFAULT NULL,
  `status_detail` varchar(512) DEFAULT NULL,
  `attempt` int(11) DEFAULT NULL,
  `reprogrammed` tinyint(1) DEFAULT NULL,
  KEY `service_type_code` (`service_type_code`),
  KEY `local_code` (`local_code`),
  KEY `order_fulfillment_id` (`order_fulfillment_id`),
  KEY `order_status_code` (`order_status_code`),
  CONSTRAINT `service_local_order_ibfk_1` FOREIGN KEY (`service_type_code`) REFERENCES `service_type` (`code`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `service_local_order_ibfk_2` FOREIGN KEY (`local_code`) REFERENCES `local` (`code`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `service_local_order_ibfk_3` FOREIGN KEY (`order_fulfillment_id`) REFERENCES `order_fulfillment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `service_local_order_ibfk_4` FOREIGN KEY (`order_status_code`) REFERENCES `order_status` (`code`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;