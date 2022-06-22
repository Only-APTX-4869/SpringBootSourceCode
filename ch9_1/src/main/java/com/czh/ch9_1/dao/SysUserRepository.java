package com.czh.ch9_1.dao;

import com.czh.ch9_1.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);

}
