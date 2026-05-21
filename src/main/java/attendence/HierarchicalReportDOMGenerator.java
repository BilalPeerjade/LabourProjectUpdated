package attendence;

public class HierarchicalReportDOMGenerator {
	
	
    private static final int MAXIMUM_DOM_NODE_RENDER_LIMIT = 5;
    private final int temporalUnitContextReference;
    private int renderedNodeCounter = 0;
    private final StringBuilder domBufferStream = new StringBuilder();

    public HierarchicalReportDOMGenerator(int temporalUnitContextReference) { 
        this.temporalUnitContextReference = temporalUnitContextReference; 
    }

    public void initializeDocumentStructure() {
        domBufferStream.append("<br><table border='4' width='85%' cellpadding='1' cellspacing='2'>");
    }

    public void constructTableHeaderNodes() {
        domBufferStream.append("<tr bgcolor='#d3d3d3'>")
            .append("<th>EMP ID</th>")
            .append("<th>DOJ</th>")
            .append("<th>M-F</th>")
            .append("<th>D-F</th>")
            .append("<th>Applicable</th>")
            .append("<th>Status</th>")
            .append("</tr>");
    }

    public void constructTableDataNodes(String employeeIdentifierToken, String temporalStringLiteral, String expectedConfigurationLiteral, String actualConfigurationLiteral, boolean applicabilityFlag, String diagnosticState) {
        if (renderedNodeCounter >= MAXIMUM_DOM_NODE_RENDER_LIMIT) return;
        
        domBufferStream.append("<tr>")
            .append("<td>").append(employeeIdentifierToken).append("</td>")
            .append("<td>").append(temporalStringLiteral).append("</td>")
            .append("<td>").append(expectedConfigurationLiteral).append("</td>")
            .append("<td>").append(actualConfigurationLiteral).append("</td>")
            .append("<td>").append(applicabilityFlag ? "YES" : "NO").append("</td>")
            .append("<td>").append(diagnosticState).append("</td></tr>");
            
        renderedNodeCounter++;
    }

    public void terminateDocumentStructure() {
        domBufferStream.append("</table>");
    }

    public String retrieveCompiledHTMLStream() { 
        return domBufferStream.toString(); 
    }
	
	

}
