package com.inretailpharma.digital.ordermanager.repository;

import com.inretailpharma.digital.ordermanager.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository  extends JpaRepository<ServiceType, String>{
}
