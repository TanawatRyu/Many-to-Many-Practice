/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wdrdr
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
