package utils;

import java.util.List;

//import businessTestCases.ExcelFilter;

//import businessTestCases.CommonBusinessUtilis.ExcelFilter;

public class ExcelFileDetails {
	
	
     
	private String filePath; //Making public
	private String sheetName;
	private int empNameColumnIndex;
	private List<ExcelFilter> filters;
	private String applyFilter;

	public ExcelFileDetails(String filePath, String sheetName, int empNameColumnIndex, List<ExcelFilter> filters,
			String applyFilter) {
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.empNameColumnIndex = empNameColumnIndex;
		this.filters = filters;
		this.applyFilter = applyFilter;
	}

    public ExcelFileDetails() {
    }
	
	
	
	public String getFilePath() {
		return filePath;
	}

	public String getSheetName() {
		return sheetName;
	}

	public int getEmpNameColumnIndex() {
		return empNameColumnIndex;
	}

	public List<ExcelFilter> getFilters() {
		return filters;
	}

	public String getApplyFilter() {
		return applyFilter;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Added for single single methods:
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setEmpNameColumnIndex(int empNameColumnIndex) {
        this.empNameColumnIndex = empNameColumnIndex;
    }

    public void setFilters(List<ExcelFilter> filters) {
        this.filters = filters;
    }

    public void setApplyFilter(String applyFilter) {
        this.applyFilter = applyFilter;
    }

    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	
	


