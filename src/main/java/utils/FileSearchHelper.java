package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//import com.google.common.io.Files;
import java.nio.file.Files;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 📂 Helper class to search a specific file inside the latest downloaded folder.
 *
 * ✅ Purpose:
 * - Used when a folder (containing multiple files) is downloaded instead of a single file.
 * - Searches recursively until the target file is found.
 *
 * 🔧 Usage:
 * File foundFile = FileSearchHelper.getFileFromDownloadedFolder("MyReport.xlsx", test);
 */
public class FileSearchHelper {

    /**
	 * Finds a file inside the latest downloaded folder.
	 *
	 * @param targetFileName Exact file name to search for.
	 * @param test           ExtentTest instance for logging.
	 * @return File object if found, otherwise null.
	 *
	 * 
	 * this code is written for search file to download folder insde folder search downloaded file   
	 *    
	 *         Sample calling first time:-- 
	 *         
	 *         // Step 1: Download folder manually
	 *         getDriver().findElement(By.xpath("//img[@alt='Download
	 *         Folder']")).click(); Thread.sleep(8000);
	 * 
	 *         // Step 2: Find specific file from folder & set globally
	 *              downloadedExcelFile = FileSearchHelper.getFileFromLatestFolder(
		        		    "KAR Central Form A (Part-A)",
		        		    test
		        		);
		          
		          if (downloadedExcelFile == null) {
		        	    test.log(LogStatus.FAIL, "File not found in the latest downloaded folder");
		        	}
	 * 
	 *  NOTE: Remaining calling similar hogi jo existing test cases me chal rahi hai
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static File getFileFromLatestFolder(String targetFileName, ExtentTest test) {
	    File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");

	    File[] folders = downloadDir.listFiles(File::isDirectory);
	    if (folders == null || folders.length == 0) {
	        test.log(LogStatus.FAIL, "❌ No folders found in Downloads.");
	        return null;
	    }

	    // Sort by lastModified
	    Arrays.sort(folders, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

	    // Debug list top 3 folders so we know kaun pick hua
	    for (int i = 0; i < Math.min(3, folders.length); i++) {
	        System.out.println("📂 Candidate folder: " + folders[i].getName() + " | Modified: " + folders[i].lastModified());
	    }

	    File latestFolder = folders[0];
	    System.out.println("✅ Searching inside: " + latestFolder.getAbsolutePath());

	    File foundFile = searchFileRecursive(latestFolder, targetFileName);
	    if (foundFile != null && foundFile.exists()) {
	        test.log(LogStatus.PASS, "📄 Data Fetch file name: " + foundFile.getName());
	        return foundFile;
	    } else {
	        test.log(LogStatus.FAIL, "❌ Target file not found in: " + latestFolder.getName());
	        return null;
	    }
	}




    // 🔍 Recursive search method
	// 🔍 Recursive search method - now supports partial match
	private static File searchFileRecursive(File dir, String targetFileName) {
	    File[] files = dir.listFiles();
	    if (files != null) {
	        for (File file : files) {
	            System.out.println("🔍 Checking: " + file.getAbsolutePath());
	            if (file.isFile() && file.getName().toLowerCase().contains(targetFileName.toLowerCase())) {
	                System.out.println("✅ Match found: " + file.getAbsolutePath());
	                return file;
	            } else if (file.isDirectory()) {
	                File found = searchFileRecursive(file, targetFileName);
	                if (found != null) return found;
	            }
	        }
	    }
	    return null;
	}
	
	
	
	
	
	
	
	
	

/*
   //code is taken from perplixity not working for zip extractor 
	    public static File extractedZipFolder;
	    public static File currentTestFile;

	    public static final String DOWNLOADS_DIR = "C:\\Users\\bilali\\Downloads";
	    public static final String ZIP_FILE_PATH = DOWNLOADS_DIR + File.separator + "projectZip.zip";
	    public static final String EXTRACTED_FOLDER_PATH = DOWNLOADS_DIR + File.separator + "projectExtractedFolder";

	    public static void extractZipOnce() throws IOException {
	        extractedZipFolder = new File(EXTRACTED_FOLDER_PATH);
	        if (extractedZipFolder.exists()) {
	            System.out.println("Zip already extracted at: " + extractedZipFolder.getAbsolutePath());
	            return;
	        }
	        extractedZipFolder.mkdirs();

	        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(ZIP_FILE_PATH)))) {
	            ZipEntry entry;
	            while ((entry = zis.getNextEntry()) != null) {
	                File outFile = new File(extractedZipFolder, entry.getName());
	                if (entry.isDirectory()) {
	                    outFile.mkdirs();
	                } else {
	                    outFile.getParentFile().mkdirs();
	             //       Files.copy(zis, outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	                    Files.copy(zis, outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

	                }
	                zis.closeEntry();
	            }
	        }

	        System.out.println("Zip extracted successfully to: " + extractedZipFolder.getAbsolutePath());
	    }

	    public static void setCurrentTestFile(String relativePathInExtracted) {
	        if (extractedZipFolder == null) {
	            throw new RuntimeException("Zip folder not extracted yet. Call extractZipOnce() first.");
	        }
	        currentTestFile = new File(extractedZipFolder, relativePathInExtracted);
	        if (!currentTestFile.exists()) {
	            throw new RuntimeException("File not found: " + currentTestFile.getAbsolutePath());
	        }
	        System.out.println("Current test file set to: " + currentTestFile.getAbsolutePath());
	    }

	    public static File getCurrentTestFile() {
	        return currentTestFile;
	    }

	    // ... (existing utility methods)
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
