package utils;

import java.util.List;



public class ExcelFilter {
	
	private int columnIndex; 
	private List<String> values;
	private String columnName; // 🔧 added missing field
	  
	
	private boolean ena = false; 

	
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

	

	
	
	
	public List<String> getValues() {
	    if (!ena) {
	        return null; 
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
    
    
    
    //flags below
    public boolean isEnabled() {
        return ena;
    }

    public void setEnabled(boolean enabled) {
        this.ena = enabled;
    }
    public ExcelFilter(int columnIndex, List<String> values, boolean enabled) {
        this.columnIndex = columnIndex;
        this.values = values;
        this.ena = enabled;
    }
    
    public boolean isDisabled() {
        return !ena;
    }



	
	

}
