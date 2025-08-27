package utils;

import java.util.List;



public class ExcelFilter {
	
	private int columnIndex; 
	private List<String> values;
	  private String columnName; // 🔧 added missing field

	
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
		return values;
	}
	
	
	
	
	
	
	

    
    // ✅ Setters
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
	
	

}
