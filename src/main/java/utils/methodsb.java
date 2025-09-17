package utils;

import java.util.List;



public class methodsb {
	
	private int columnIndex; 
	private List<String> values;
	private String columnName; // 🔧 added missing field
	  
	
	

	
	//for single methods:
	   // ✅ Default constructor
 public methodsb() {
 }
	
	
	
	public methodsb(int columnIndex, List<String> values) {
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
    public methodsb(int columnIndex, List<String> values, boolean enabled) {
        this.columnIndex = columnIndex;
        this.values = values;
        this.ena = enabled;
    }
    
    public boolean isDisabled() {
        return !ena;
    }
    
    private boolean ena = false; 



	
 

}
