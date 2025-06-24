package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dto.RoleDTO;
import com.jwt.entity.Role;
import com.jwt.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Create a new role
    public Role createRole(RoleDTO roleDTO) {
        Role role = new Role(roleDTO.getName());
        return roleRepository.save(role);
    }

    // Read role by ID
    public Role getRoleById(Long id) throws Exception {
        return roleRepository.findById(id).orElseThrow(() -> new Exception("Role not found"));
    }

    // Update role
    public Role updateRole(Long id, RoleDTO roleDTO) throws Exception {
        Role role = getRoleById(id);
        role.setName(roleDTO.getName());
        return roleRepository.save(role);
    }

    // Delete role
    public void deleteRole(Long id) throws Exception {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }

    
}

