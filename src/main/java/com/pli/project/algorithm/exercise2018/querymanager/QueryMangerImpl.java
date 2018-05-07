package com.pli.project.algorithm.exercise2018.querymanager;

import com.pli.project.algorithm.exercise2018.querymanager.exception.CyclicRelationFoundException;
import com.pli.project.algorithm.exercise2018.querymanager.exception.EmployeeNotFoundException;

import java.util.Map;

public class QueryMangerImpl implements QueryManger{

    Map<Integer, Integer> employmentMap;

    public QueryMangerImpl () {}

    @Override
    public void setManger(int manager, int employee) throws CyclicRelationFoundException {
        if (queryManager(employee, manager)) {
            throw new CyclicRelationFoundException(String.format("There is management relation from %s to %s",
                    manager, employee));
        }
        employmentMap.put(employee, manager);
    }

    @Override
    public void setPeer(int managerFrom, int employee) throws EmployeeNotFoundException, CyclicRelationFoundException {
        if (!employmentMap.containsKey(managerFrom)) {
            throw new EmployeeNotFoundException(String.format("Employee %s is not found"));
        }
        int newManager = employmentMap.get(managerFrom);
        if (queryManager(employee, newManager)) {
            throw new CyclicRelationFoundException(String.format("There is management relation from %s to %s", newManager, employee));
        }
        employmentMap.put(employee, newManager);
    }

    @Override
    public boolean queryManager(int manager, int employee) {
        if (manager == employee) {
            return false;
        }
        while (employmentMap.containsKey(employee)) {
            employee = employmentMap.get(employee);
            if (employee == manager) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        throw new CyclicRelationFoundException("adsf");
    }
}
