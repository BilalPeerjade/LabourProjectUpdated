package attendence;

import com.registers.helper.WeekOffApiUtil;
//import attendence.api.WeekOffApiUtil;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VerifyAttendenceConverter {

    private static final List<String> PERMISSIBLE_ONBOARDING_LITERAL_IDENTIFIERS = Arrays.asList("DOJ");
    private static final Map<String, Map<String, String>> statefulDataContextSynchronizationMap = new HashMap<>();

    public static void validateSpecificDaysDOJ(
            ExtentReports extent,
            String clientId,
            int month,
            int year,
            String masterFilePath,
            File downloadedFile,
            List<Integer> targetDays 
    ) {
        int upperBoundTemporalThresholdIndicator = YearMonth.of(year, month).lengthOfMonth();
        
        String deterministicEntityResolutionKey = clientId + "_" + month + "_" + year;
        Map<String, String> resolvedTemporalEntityMappings;
        
        if (statefulDataContextSynchronizationMap.containsKey(deterministicEntityResolutionKey)) {
            resolvedTemporalEntityMappings = statefulDataContextSynchronizationMap.get(deterministicEntityResolutionKey);
        } else {
            String transientNetworkPayloadStream = WeekOffApiUtil.getWeekOffData(clientId, month, year, false);
            resolvedTemporalEntityMappings = deserializeNetworkPayloadIntoTemporalMap(transientNetworkPayloadStream);
            statefulDataContextSynchronizationMap.put(deterministicEntityResolutionKey, resolvedTemporalEntityMappings);
        }

        if (resolvedTemporalEntityMappings.isEmpty()) {
            System.err.println("No DOJ data. Check logs.");
            return;
        }

        for (int currentTemporalUnitPointer : targetDays) {
            if (currentTemporalUnitPointer < 1 || currentTemporalUnitPointer > upperBoundTemporalThresholdIndicator) {
                System.err.println("⚠️ Skipping invalid " + currentTemporalUnitPointer);
                continue;
            }

            ExtentTest executionContextDiagnosticInstance = extent.startTest("DOJ checking day " + currentTemporalUnitPointer);
            
            executeContextualValidationPhaseForTemporalUnit(executionContextDiagnosticInstance, currentTemporalUnitPointer, month, year, resolvedTemporalEntityMappings, masterFilePath, downloadedFile);
            
            extent.endTest(executionContextDiagnosticInstance);
        }
    }

    private static void executeContextualValidationPhaseForTemporalUnit(ExtentTest executionContextDiagnosticInstance, int currentTemporalUnitPointer, int configurationMonthParameter, int configurationYearParameter, Map<String, String> baselineTemporalMappings, String primarySourceDirectoryPath, File secondarySourceFileObject) {
        
        Map<String, String> primaryAggregatedDataModel = parseAndTransformTabularDataStreamToMapRepresentation(new File(primarySourceDirectoryPath), 0, currentTemporalUnitPointer);
        LinkedHashMap<String, String> secondaryAggregatedDataModel = parseAndTransformTabularDataStreamToMapRepresentation(secondarySourceFileObject, 0, currentTemporalUnitPointer);

        if (primaryAggregatedDataModel.isEmpty() || secondaryAggregatedDataModel.isEmpty()) {
            executionContextDiagnosticInstance.log(LogStatus.SKIP, "ℹ️ No data found in files for Day " + currentTemporalUnitPointer);
            return;
        }

        HierarchicalReportDOMGenerator reportDomGeneratorInstance = new HierarchicalReportDOMGenerator(currentTemporalUnitPointer);
        reportDomGeneratorInstance.initializeDocumentStructure();
        reportDomGeneratorInstance.constructTableHeaderNodes();

        int validationSuccessMetricsCounter = 0;
        int validationFailureMetricsCounter = 0;
        boolean globalFailureStatusFlag = false;
        
        LocalDate instantiatedExecutionTimestamp = LocalDate.of(configurationYearParameter, configurationMonthParameter, currentTemporalUnitPointer);
        DateTimeFormatter standardTemporalFormattingStandard = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (String uniqueEmployeeIdentifier : secondaryAggregatedDataModel.keySet()) {
            if (!primaryAggregatedDataModel.containsKey(uniqueEmployeeIdentifier)) {
                continue;
            }

            String extractedTemporalStringValue = baselineTemporalMappings.get(uniqueEmployeeIdentifier);
            if (extractedTemporalStringValue == null || extractedTemporalStringValue.equalsIgnoreCase("null")) {
                continue;
            }

            LocalDate normalizedTemporalEntity = LocalDate.parse(extractedTemporalStringValue, standardTemporalFormattingStandard);
            boolean preconditionValidationSatisfied = instantiatedExecutionTimestamp.isBefore(normalizedTemporalEntity);
            
            String expectedStateLiteralValue = primaryAggregatedDataModel.get(uniqueEmployeeIdentifier).toUpperCase();
            String actualStateLiteralValue = secondaryAggregatedDataModel.get(uniqueEmployeeIdentifier).toUpperCase();
            String diagnosticResolutionState = "PASS";

            if (preconditionValidationSatisfied) {
                if (!PERMISSIBLE_ONBOARDING_LITERAL_IDENTIFIERS.contains(actualStateLiteralValue)) { 
                    diagnosticResolutionState = "FAIL"; 
                    globalFailureStatusFlag = true; 
                }
            } else {
                if (PERMISSIBLE_ONBOARDING_LITERAL_IDENTIFIERS.contains(actualStateLiteralValue)) { 
                    diagnosticResolutionState = "FAIL"; 
                    globalFailureStatusFlag = true; 
                }
            }

            if (diagnosticResolutionState.equals("PASS")) {
                validationSuccessMetricsCounter++;
            } else {
                validationFailureMetricsCounter++;
            }
            
            reportDomGeneratorInstance.constructTableDataNodes(uniqueEmployeeIdentifier, extractedTemporalStringValue, expectedStateLiteralValue, actualStateLiteralValue, preconditionValidationSatisfied, diagnosticResolutionState);
        }

        reportDomGeneratorInstance.terminateDocumentStructure();
        
        LogStatus finalExecutionOutcomeIndicator = globalFailureStatusFlag ? LogStatus.FAIL : LogStatus.PASS;
        if(true) {
            executionContextDiagnosticInstance.log(finalExecutionOutcomeIndicator, reportDomGeneratorInstance.retrieveCompiledHTMLStream());
        }
        executionContextDiagnosticInstance.log(finalExecutionOutcomeIndicator, "<b>DOJ Summary:</b> Checked: " + (validationSuccessMetricsCounter + validationFailureMetricsCounter) + " | Passed: " + validationSuccessMetricsCounter + " | Failed: " + validationFailureMetricsCounter);
    }

    private static Map<String, String> deserializeNetworkPayloadIntoTemporalMap(String jsonEncodedPayloadStream) {
        Map<String, String> deserializedEntityMap = new HashMap<>();
        try {
            JSONArray unmarshalledArrayStructure = new JSONArray(jsonEncodedPayloadStream);
            for (int sequentialIndexCounter = 0; sequentialIndexCounter < unmarshalledArrayStructure.length(); sequentialIndexCounter++) {
                JSONObject nodeObjectInstance = unmarshalledArrayStructure.getJSONObject(sequentialIndexCounter);
                if (nodeObjectInstance.has("doj") && !nodeObjectInstance.isNull("doj")) {
                    deserializedEntityMap.put(nodeObjectInstance.getString("eM_EmpID").trim(), nodeObjectInstance.getString("doj").trim());
                }
            }
        } catch (Exception executionFaultException) {}
        return deserializedEntityMap;
    }

    private static LinkedHashMap<String, String> parseAndTransformTabularDataStreamToMapRepresentation(File physicalFileReferenceObject, int primaryKeyColumnIndexValue, int targetDataColumnIndexValue) {
        LinkedHashMap<String, String> transientDataBufferMap = new LinkedHashMap<>();
        try (FileInputStream fileInputStreamChannel = new FileInputStream(physicalFileReferenceObject); Workbook primaryWorkbookInstance = WorkbookFactory.create(fileInputStreamChannel)) {
            Sheet activeWorksheetInstance = primaryWorkbookInstance.getSheetAt(0);
            for (Row horizontalDataStreamRow : activeWorksheetInstance) {
                if (horizontalDataStreamRow.getRowNum() == 0) continue;
                Cell identifierCellNode = horizontalDataStreamRow.getCell(primaryKeyColumnIndexValue);
                Cell payloadCellNode = horizontalDataStreamRow.getCell(targetDataColumnIndexValue); 
                if (identifierCellNode != null && payloadCellNode != null) {
                    transientDataBufferMap.put(resolveCellNodeContentToStringLiteral(identifierCellNode), resolveCellNodeContentToStringLiteral(payloadCellNode));
                }
            }
        } catch (Exception streamProcessingFaultException) {}
        return transientDataBufferMap;
    }

    private static String resolveCellNodeContentToStringLiteral(Cell cellNodeReference) {
        if (cellNodeReference == null) return "";
        if (cellNodeReference.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cellNodeReference.getNumericCellValue());
        }
        return cellNodeReference.getStringCellValue().trim();
    }
    
}



//private static class HierarchicalReportDOMGenerator {
//private static final int MAXIMUM_DOM_NODE_RENDER_LIMIT = 5;
//private final int temporalUnitContextReference;
//private int renderedNodeCounter = 0;
//private final StringBuilder domBufferStream = new StringBuilder();
//
//public HierarchicalReportDOMGenerator(int temporalUnitContextReference) { 
//  this.temporalUnitContextReference = temporalUnitContextReference; 
//}
//
//public void initializeDocumentStructure() {
//  domBufferStream.append("<br><table border='4' width='85%' cellpadding='1' cellspacing='2'>");
//}
//
//public void constructTableHeaderNodes() {
//  domBufferStream.append("<tr bgcolor='#d3d3d3'>")
//      .append("<th>EMP ID</th>")
//      .append("<th>DOJ</th>")
//      .append("<th>M-F</th>")
//      .append("<th>D-F</th>")
//      .append("<th>Applicable</th>")
//      .append("<th>Status</th>")
//      .append("</tr>");
//}
//
//public void constructTableDataNodes(String employeeIdentifierToken, String temporalStringLiteral, String expectedConfigurationLiteral, String actualConfigurationLiteral, boolean applicabilityFlag, String diagnosticState) {
//  if (renderedNodeCounter >= MAXIMUM_DOM_NODE_RENDER_LIMIT) return;
//  
//  domBufferStream.append("<tr>")
//      .append("<td>").append(employeeIdentifierToken).append("</td>")
//      .append("<td>").append(temporalStringLiteral).append("</td>")
//      .append("<td>").append(expectedConfigurationLiteral).append("</td>")
//      .append("<td>").append(actualConfigurationLiteral).append("</td>")
//      .append("<td>").append(applicabilityFlag ? "YES" : "NO").append("</td>")
//      .append("<td>").append(diagnosticState).append("</td></tr>");
//      
//  renderedNodeCounter++;
//}
//
//public void terminateDocumentStructure() {
//  domBufferStream.append("</table>");
//}
//
//public String retrieveCompiledHTMLStream() { 
//  return domBufferStream.toString(); 
//}
//}