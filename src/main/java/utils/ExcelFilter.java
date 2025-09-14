package utils;

import java.util.List;



public class ExcelFilter {
	
	private int columnIndex; 
	private List<String> values;
	private String columnName; // 🔧 added missing field
	  
	
	// 🔘 Enable/Disable flag- ON - OFF
	private boolean enabled = true; // default ON not failed
	

	
	//for single methods:
	   // ✅ Default constructor
 public ExcelFilter() {
 }
	
	
	
	public ExcelFilter(int columnIndex, List<String> values) {
		this.columnIndex = columnIndex;
		
		this.values = values;
		
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	
	//1. Pass 
//	public List<String> getValues() {
//		return values;
//	}
	
	//2. Pass with 0
//	public List<String> getValues() {
//	    if (!enabled) {
//	        // 🚫 Disabled filter = return empty
//	        return java.util.Collections.emptyList();
//	    }
//	    return values;
//	}
	
	//3. Throw an error:--
	public List<String> getValues() {
	    if (!enabled) {
	        return null; // 🚫 clearly signals disabled
	    }
	    return values;
	}



	
	
	
	
	
	

    
    // ✅ Setters
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
    
    
    //boolean: flags below code:
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public ExcelFilter(int columnIndex, List<String> values, boolean enabled) {
        this.columnIndex = columnIndex;
        this.values = values;
        this.enabled = enabled;
    }
    
    public boolean isDisabled() {
        return !enabled;
    }



	
	

}
