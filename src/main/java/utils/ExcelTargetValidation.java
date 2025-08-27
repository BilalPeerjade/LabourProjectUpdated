package utils;

public class ExcelTargetValidation {
  
	
	private String sheetName;
	private int columnIndex;
	
	private String headerKeyword; //for Report HTML table (Enhancement added) this will capture header A B C D in html report
	
	private String keyword;
	private int rowOffset;
	
	public ExcelTargetValidation() {
	    // default no-arg constructor
	}
	

	public ExcelTargetValidation(String sheetName, int columnIndex, String keyword, int rowOffset) {
		this.sheetName = sheetName;
		this.columnIndex = columnIndex;
		
		this.headerKeyword = headerKeyword; //for Report HTML table (Enhancement added)
		
		this.keyword = keyword;
		this.rowOffset = rowOffset;
	}

	public String getSheetName() {
		return sheetName;
	}

	public int getColumnIndex() {
		return columnIndex;
	}
	
	
    public String getHeaderKeyword() { //for Report HTML table (Enhancement added)
        return headerKeyword;
    }
	
	
	

	public String getKeyword() {
		return keyword;
	}

	public int getRowOffset() {
		return rowOffset;
	}
	
	
	
	
	
	
	
	
	
	
	
 
	//for single single methods

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }


    public void setHeaderKeyword(String headerKeyword) {
        this.headerKeyword = headerKeyword;
    }
	
	
	
	
	
	
	
	

} 
