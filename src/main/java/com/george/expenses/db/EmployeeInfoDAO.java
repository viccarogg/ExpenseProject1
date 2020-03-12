package com.george.expenses.db;

import com.george.expenses.models.EmployeeInfo;

public interface EmployeeInfoDAO {
	public EmployeeInfo getMyInformation(int emp_id);
	public void updateMyInformation(EmployeeInfo info);
}
