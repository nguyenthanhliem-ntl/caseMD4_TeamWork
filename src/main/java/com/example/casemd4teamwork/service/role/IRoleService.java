package com.example.casemd4teamwork.service.role;

import com.example.casemd4teamwork.model.Role;
import com.example.casemd4teamwork.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
