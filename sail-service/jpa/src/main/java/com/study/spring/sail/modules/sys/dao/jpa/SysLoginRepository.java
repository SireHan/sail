package com.study.spring.sail.modules.sys.dao.jpa;

import com.study.spring.sail.domain.modules.sys.SysLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SysLoginRepository extends JpaRepository<SysLogin,Long> {

    /**
     * 根据登陆名查询登陆账户
     * @param loginName
     * @return
     */
    SysLogin findByLoginName(String loginName);

    /**
     * 分页查询数据
     * @param pageable
     * @return
     */
    Page<SysLogin> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from SysLogin where id = ?1")
    void deleteSysLoginById(Long id);
}
