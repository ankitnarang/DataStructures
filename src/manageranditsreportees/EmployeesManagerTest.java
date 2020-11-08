package manageranditsreportees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EmployeesManagerTest {
	
	public static void main(String[] args) {
		Map<String,String> employeeManagerMap = new HashMap<String,String>() {
			{
				put("A", "C");
                put("B", "C");
                put("C", "F");
                put("D", "E");
                put("E", "F");
                put("F", "F");
			}
		};
		Map<String,Integer> reporteeCount  = EmployeesManager.getReporteeCount(employeeManagerMap);
		System.out.println("Result " + reporteeCount);
	}

}
class EmployeesManager {

	public static Map<String, Integer> getReporteeCount(Map<String, String> employeeManagerMap) {
		
		Map<String,List<String>> managerEmployeeMap = getManagerEmployeeMap(employeeManagerMap);
		
		Map<String,Integer> reporteeCountMap = new HashMap<>();
		
		for(String employee : employeeManagerMap.keySet()) {
			calculateEmployeeReportee(employee,managerEmployeeMap,reporteeCountMap);
		}
		
		return reporteeCountMap;
	}

	private static void calculateEmployeeReportee(String manager, Map<String, List<String>> managerEmployeeMap,
			Map<String, Integer> reporteeCountMap) {
		
		if(!managerEmployeeMap.containsKey(manager)) {
			reporteeCountMap.put(manager,0);
			return;
		}
		
		int totalReportee = managerEmployeeMap.get(manager).size();
		
		for(String reportee : managerEmployeeMap.get(manager)) {
			if(!reporteeCountMap.containsKey(reportee)) {
				calculateEmployeeReportee(reportee, managerEmployeeMap, reporteeCountMap);
			}
			totalReportee += reporteeCountMap.get(reportee);
		}
		
		reporteeCountMap.put(manager,totalReportee);
	}

	private static Map<String, List<String>> getManagerEmployeeMap(Map<String, String> employeeManagerMap) {

		Map<String,List<String>> managerEmployeeMap = new HashMap<>();
		
		for(Map.Entry<String,String> entry : employeeManagerMap.entrySet()) {
			
			if(entry.getKey().equals(entry.getValue())) {
				continue;
			}
			
			addEmployeeToManager(managerEmployeeMap,entry);
			
		}
		
		return managerEmployeeMap;
	}

	private static void addEmployeeToManager(Map<String, List<String>> managerEmployeeMap,
			Entry<String, String> entry) {
		if(managerEmployeeMap.containsKey(entry.getValue())) {
			managerEmployeeMap.get(entry.getValue()).add(entry.getValue());
		} else {
			List<String> employees = new ArrayList<String>() {
				{
					add(entry.getValue());
				}
			};
			managerEmployeeMap.put(entry.getValue(),employees);
		}
	}
	
}
