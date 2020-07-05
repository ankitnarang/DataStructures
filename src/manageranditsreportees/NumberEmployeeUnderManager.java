package manageranditsreportees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberEmployeeUnderManager 
{ 
    static Map<String,Integer> result = new HashMap<String, Integer>(); 
  
    public static void main(String[] args) 
    { 
        Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Employee 1", "Manager"); 
        dataSet.put("Employee 2", "Manager"); 
        dataSet.put("Manager", "CEO"); 
        dataSet.put("Employee 3", "Snr Manager"); 
        dataSet.put("Snr Manager", "CEO"); 
        dataSet.put("CEO", "CEO"); 
        System.out.println("Employee - Manager Map " + dataSet);
        populateResult(dataSet); 
        System.out.println("Result = " + result); 
    } 
  
    private static void populateResult(Map<String, String> dataSet) 
    { 
        Map<String, List<String>> mngrEmpMap = 
                                  new HashMap<String, List<String>>(); 
  
        for (Map.Entry<String,String> entry: dataSet.entrySet()) 
        { 
            String emp = entry.getKey(); 
            String mngr = entry.getValue(); 
            if (!emp.equals(mngr))
            { 
                List<String> directReportList = mngrEmpMap.get(mngr); 
  
                if (directReportList == null) 
                { 
                    directReportList = new ArrayList<String>(); 
                    mngrEmpMap.put(mngr, directReportList); 
                } 
                directReportList.add(emp); 
            } 
        } 
        
        System.out.println("Manager - Direct Reportees Map " + mngrEmpMap);
  
        for (String mngr: dataSet.keySet()) 
            populateResultUtil(mngr, mngrEmpMap); 
    } 
  
    private static int populateResultUtil(String mngr, 
                               Map<String, List<String>> mngrEmpMap) 
    { 
        int count = 0; 
  
        if (!mngrEmpMap.containsKey(mngr)) 
        { 
            result.put(mngr, 0); 
            return 0; 
        } else if (result.containsKey(mngr)) {
        	count = result.get(mngr); 
        } else { 
            List<String> directReportEmpList = mngrEmpMap.get(mngr); 
            count = directReportEmpList.size(); 
            for (String directReportEmp: directReportEmpList) 
               count +=  populateResultUtil(directReportEmp, mngrEmpMap); 
  
            result.put(mngr, count); 
        } 
        return count; 
    } 
} 


