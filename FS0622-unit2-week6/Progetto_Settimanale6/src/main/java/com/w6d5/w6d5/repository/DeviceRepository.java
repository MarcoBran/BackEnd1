package com.w6d5.w6d5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w6d5.w6d5.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{

}
