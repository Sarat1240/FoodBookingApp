package com.example.DesignYourDelicacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DesignYourDelicacy.entity.VendorMenu;


@Repository
public interface VendorRepository extends JpaRepository<VendorMenu, Integer> {

	List<VendorMenu> findByVendorName(String vendorName);

	List<VendorMenu> findByItemName(String item);

	VendorMenu findByVendorNameAndItemName(String vendorname, String item);

}
