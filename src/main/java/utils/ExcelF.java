package utils;

import java.time.LocalDate;
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
//    public ExcelF() {
//    	
//    }
	
	
	
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
    
    
//    private boolean ena = check();
//    private boolean ena = check(23,12,25);
    private boolean ena = false;
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
    
    
/*    public static boolean check(int dd, int mm, int yy) {

        // input date
        LocalDate inputDate = LocalDate.of(2000 + yy, mm, dd);

        // today's date
        LocalDate todayDate = LocalDate.now();

        // agar input date future me hai to true
        if (inputDate.isAfter(todayDate)) {
            return true;
        }

        // aaj ya past date ke liye false
        return false;
    }
    
    //Good
    public static boolean check() {
        LocalDate input = LocalDate.of(2000 + 25, 12, 24); //YY DD MM
        LocalDate todayDate = LocalDate.now();
        if (input.isAfter(todayDate)) {return true;}
        return false;
    }
    */

	
 

}
