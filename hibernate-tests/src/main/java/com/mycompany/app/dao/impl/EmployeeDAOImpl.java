package com.mycompany.app.dao.impl;

import com.mycompany.app.dao.EmployeeDAO;
import com.mycompany.app.entity.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class EmployeeDAOImpl extends BaseDAOImpl<EmployeeEntity, Long> implements EmployeeDAO {

}
