package utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import businessTestCases.FilePath;
import login.BasePage;



public class ExcelF {
	
	
	//methodsb
	private int columnIndex; 
	private List<String> values;
	private String columnName; // 🔧 added missing field
	  
	
	

	
	//for single methods:
	//Default constructor
    public ExcelF() {
    	
    }
	
	
	
	public ExcelF(int columnIndex, List<String> values) {
		this.columnIndex = columnIndex;
		this.values = values;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	
	
	
	


	
	public List<String> getValues() {
		if (!ena) {
			return java.util.Collections.emptyList();
		}
		return values;
	}
	
//	public List<String> getValues() {
//	    if (!ena) {
//	        return null; 
//	    }
//	    return values;
//	}
	
	

    
    // ✅ Setters
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    
    
    
    public boolean isEnabled() {
        return ena;
    }
    private boolean ena;

    public void setEnabled(boolean enabled) {
        this.ena = enabled;
    }
    public ExcelF(int columnIndex, List<String> values, boolean enabled) {
        this.columnIndex = columnIndex;
        this.values = values;
        this.ena = enabled;
    }
    
    public boolean isDisabled() {
        return !ena;
    }
    
    



	
 

}
