package utils;

import java.util.List;

public class ExcelExtraConfig {
   
	
	private String enable;
	private int columnIndex;
	private String stopAtKeyword;
	private int totalColumnIndex;
	
	private String totalLogicEnabled;   // "YES"/"NO"-------
	private String totalKeyword;
	
	private String enableSmartTextMatch; // YES / NO
	private String enableDateMatch;      // YES / NO

	public ExcelExtraConfig(String enable, int columnIndex, String stopAtKeyword) {
		this.enable = enable;
		this.columnIndex = columnIndex;
		this.stopAtKeyword = stopAtKeyword;
	}

	public String getEnable() {
		return enable;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public String getStopAtKeyword() {
		return stopAtKeyword;
	}
	
	
	
	
	
	
	
	
	//
    public String getTotalLogicEnabled() {
        return totalLogicEnabled;
    }
    public String getTotalKeyword() {
        return totalKeyword;
    }
	
	
	//

	public String getEnableSmartTextMatch() {
	    return enableSmartTextMatch;
	}
	public void setEnableSmartTextMatch(String enableSmartTextMatch) {
	    this.enableSmartTextMatch = enableSmartTextMatch;
	}

	public String getEnableDateMatch() {
	    return enableDateMatch;
	}
	public void setEnableDateMatch(String enableDateMatch) {
	    this.enableDateMatch = enableDateMatch;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	//single single 
    public ExcelExtraConfig() {
    }

    public ExcelExtraConfig(String enable) {
        this.enable = enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public void setStopAtKeyword(String stopAtKeyword) {
        this.stopAtKeyword = stopAtKeyword;
    }
	
    public int getTotalColumnIndex() {
        return totalColumnIndex;
    }

	
	
	
	
	
	
	
	

}
