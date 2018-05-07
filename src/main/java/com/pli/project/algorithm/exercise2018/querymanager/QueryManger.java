package com.pli.project.algorithm.exercise2018.querymanager;

import com.pli.project.algorithm.exercise2018.querymanager.exception.CyclicRelationFoundException;
import com.pli.project.algorithm.exercise2018.querymanager.exception.EmployeeNotFoundException;

public interface QueryManger {
    public void setManger(int manager, int employee) throws CyclicRelationFoundException;
    public void setPeer(int managerFrom, int target) throws CyclicRelationFoundException, EmployeeNotFoundException;
    public boolean queryManager(int manager, int employee);
}
