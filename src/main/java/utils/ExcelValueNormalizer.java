package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelValueNormalizer {

    // 🔹 State code
    private static final Map<String, String> STATE_MAP = new HashMap<>();
    static {
        STATE_MAP.put("guj", "gujarat");
        STATE_MAP.put("mah", "maharashtra");
        STATE_MAP.put("kar", "karnataka");
        STATE_MAP.put("anp", "andhra pradesh");
        STATE_MAP.put("bhr", "bihar");
        STATE_MAP.put("jak", "jharkhand");
        STATE_MAP.put("krl", "kerala");
        STATE_MAP.put("map", "Madhya Pradesh");
        STATE_MAP.put("ors", "orissa");
        STATE_MAP.put("pnd", "pondicherry");
        STATE_MAP.put("trp", "tripura");
        STATE_MAP.put("web", "west bengal");
        STATE_MAP.put("map", "madhya pradesh");
        STATE_MAP.put("map", "madhya pradesh");
        STATE_MAP.put("pjb", "punjab");
        STATE_MAP.put("Tmn", "tamil Nadu");

        
         
    }

    /**
     * 🔹 Normalizes text values for consistent comparison.
     * Removes extra spaces, makes lowercase, and maps known short forms.
     */
    public static String normalize(String value) {
        if (value == null) return "";
        String normalized = value.trim().toLowerCase();

        // ✅ Apply mapping if exists
        if (STATE_MAP.containsKey(normalized)) {
            normalized = STATE_MAP.get(normalized);
        }

        return normalized;
    }

    /**
     * 🔹 Normalizes dates to a fixed format (yyyy-MM-dd).
     */
    public static String normalizeDate(String value) {
        if (value == null) return "";
        String normalized = value.trim().toLowerCase();
        
        try {
            java.text.SimpleDateFormat inputFormat1 = new java.text.SimpleDateFormat("dd/MM/yyyy" );
            java.text.SimpleDateFormat inputFormat2 = new java.text.SimpleDateFormat("dd-MM-yyyy");
            java.text.SimpleDateFormat outputFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            
    //        java.text.SimpleDateFormat outputFormat = new java.text.SimpleDateFormat("dd MMM yyy"); //Not working
            
//            java.text.SimpleDateFormat inputFormat3 = new java.text.SimpleDateFormat("dd-MMM-yyyy", java.util.Locale.ENGLISH); //New            
//            if (value.contains("/")) {
//                date = inputFormat1.parse(value);
//            } else if (value.contains("-")) {
//                date = inputFormat2.parse(value);
//            } else if (value.matches("\\d{2}\\s+[A-Za-z]{3}\\s+\\d{4}")) {
//                date = inputFormat3.parse(value);
//            } else {
//                return normalized;
//            }
            
            
            java.util.Date date;
            if (value.contains("/")) {
                date = inputFormat1.parse(value);
            } else if (value.contains("-")) {
                date = inputFormat2.parse(value);
            } else {
                return normalized; // Not a date format we handle
            }
            return outputFormat.format(date);
            
        } catch (Exception e) {
            return normalized; // If parsing fails, return original normalized
        }
    }
    
    
    
    
    

    
    
    
    //---------
    
    //for Backed values PT slab amounts
    
    // ✅ PT Slabs state-wise
    private static final Map<String, List<SlabRule>> PT_SLAB_MAP = new HashMap<>();

    static {   
        // 🔹 Andhra Pradesh
        List<SlabRule> andhraPradeshSlabs = new ArrayList<>(); //new ArrayList<>(); Object create karega yaha
        andhraPradeshSlabs.add(new SlabRule(1, 15000, 0));
        andhraPradeshSlabs.add(new SlabRule(15001, 20000, 150));
        andhraPradeshSlabs.add(new SlabRule(20001, 99999, 200));
        PT_SLAB_MAP.put("andhra pradesh", andhraPradeshSlabs);

        // 🔹 Assam
        List<SlabRule> assamSlabs = new ArrayList<>();
        assamSlabs.add(new SlabRule(1, 10000, 0));
        assamSlabs.add(new SlabRule(10001, 15000, 150));
        assamSlabs.add(new SlabRule(15001, 25000, 180));
        assamSlabs.add(new SlabRule(25001, 99999, 208));
        PT_SLAB_MAP.put("assam", assamSlabs);

        // 🔹 Bihar
        List<SlabRule> biharSlabs = new ArrayList<>();
        biharSlabs.add(new SlabRule(1, 25000, 0));
        biharSlabs.add(new SlabRule(25001, 41666, 84));
        biharSlabs.add(new SlabRule(41667, 83333, 167));
        biharSlabs.add(new SlabRule(83334, 99999, 209));
        PT_SLAB_MAP.put("bihar", biharSlabs);

        // 🔹 Chhattisgarh
        List<SlabRule> chhattisgarhSlabs = new ArrayList<>();
        chhattisgarhSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("chhattisgarh", chhattisgarhSlabs);

        // 🔹 Dadra and Nagar Haveli
        List<SlabRule> dadraAndNagarHaveliSlabs = new ArrayList<>();
        dadraAndNagarHaveliSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("dadra and nagar haveli", dadraAndNagarHaveliSlabs);

        // 🔹 Delhi
        List<SlabRule> delhiSlabs = new ArrayList<>();
        delhiSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("delhi", delhiSlabs);

        // 🔹 Goa
        List<SlabRule> goaSlabs = new ArrayList<>();
        goaSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("goa", goaSlabs);

        // 🔹 Gujarat
        List<SlabRule> gujaratSlabs = new ArrayList<>();
        gujaratSlabs.add(new SlabRule(1, 12000, 0));
        gujaratSlabs.add(new SlabRule(12001, 99999, 200));
        PT_SLAB_MAP.put("gujarat", gujaratSlabs);

        // 🔹 Haryana
        List<SlabRule> haryanaSlabs = new ArrayList<>();
        haryanaSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("haryana", haryanaSlabs);

        // 🔹 Himachal Pradesh
        List<SlabRule> himachalPradeshSlabs = new ArrayList<>();
        himachalPradeshSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("himachal pradesh", himachalPradeshSlabs);

        // 🔹 Jammu and Kashmir
        List<SlabRule> jammuAndKashmirSlabs = new ArrayList<>();
        jammuAndKashmirSlabs.add(new SlabRule(1, 24999, 0));
        jammuAndKashmirSlabs.add(new SlabRule(25000, 41667, 100));
        jammuAndKashmirSlabs.add(new SlabRule(41668, 66667, 150));
        jammuAndKashmirSlabs.add(new SlabRule(66668, 83333, 175));
        jammuAndKashmirSlabs.add(new SlabRule(83334, 99999, 208));
        PT_SLAB_MAP.put("jammu and kashmir", jammuAndKashmirSlabs);

        // 🔹 Karnataka
        List<SlabRule> karnatakaSlabs = new ArrayList<>();
        karnatakaSlabs.add(new SlabRule(1, 24999, 0));
        karnatakaSlabs.add(new SlabRule(25000, 99999, 200));
        PT_SLAB_MAP.put("karnataka", karnatakaSlabs);

        // 🔹 Kerala
        List<SlabRule> keralaSlabs = new ArrayList<>();
        keralaSlabs.add(new SlabRule(1, 11999, 0));
        keralaSlabs.add(new SlabRule(12000, 17999, 120));
        keralaSlabs.add(new SlabRule(18000, 29999, 180));
        keralaSlabs.add(new SlabRule(30000, 44999, 300));
        keralaSlabs.add(new SlabRule(45000, 59999, 450));
        keralaSlabs.add(new SlabRule(60000, 74999, 600));
        keralaSlabs.add(new SlabRule(75000, 99999, 750));
        keralaSlabs.add(new SlabRule(100000, 124999, 1000));
        keralaSlabs.add(new SlabRule(125000, 999999, 1250));
        PT_SLAB_MAP.put("kerala", keralaSlabs);

        // 🔹 Maharashtra
        List<SlabRule> maharashtraSlabs = new ArrayList<>();
        maharashtraSlabs.add(new SlabRule(1, 7500, 0));
        maharashtraSlabs.add(new SlabRule(7501, 10000, 175));
        maharashtraSlabs.add(new SlabRule(10001, 99999, 200));
        PT_SLAB_MAP.put("maharashtra", maharashtraSlabs);

        // 🔹 Meghalaya
        List<SlabRule> meghalayaSlabs = new ArrayList<>();
        meghalayaSlabs.add(new SlabRule(8334, 12500, 42));
        meghalayaSlabs.add(new SlabRule(12501, 16667, 63));
        meghalayaSlabs.add(new SlabRule(16668, 20833, 84));
        meghalayaSlabs.add(new SlabRule(20834, 25000, 105));
        meghalayaSlabs.add(new SlabRule(25001, 29167, 125));
        meghalayaSlabs.add(new SlabRule(29168, 33333, 150));
        meghalayaSlabs.add(new SlabRule(33334, 37500, 175));
        meghalayaSlabs.add(new SlabRule(37501, 41667, 200));
        meghalayaSlabs.add(new SlabRule(41668, 99999, 208));
        meghalayaSlabs.add(new SlabRule(1, 4166, 0));
        meghalayaSlabs.add(new SlabRule(4167, 6250, 17));
        meghalayaSlabs.add(new SlabRule(6251, 8333, 25));
        PT_SLAB_MAP.put("meghalaya", meghalayaSlabs);

        // 🔹 Mizoram
        List<SlabRule> mizoramSlabs = new ArrayList<>();
        mizoramSlabs.add(new SlabRule(1, 5000, 0));
        mizoramSlabs.add(new SlabRule(5001, 8000, 75));
        mizoramSlabs.add(new SlabRule(8001, 10000, 120));
        mizoramSlabs.add(new SlabRule(10001, 12000, 150));
        mizoramSlabs.add(new SlabRule(12001, 15000, 180));
        mizoramSlabs.add(new SlabRule(15001, 99999, 208));
        PT_SLAB_MAP.put("mizoram", mizoramSlabs);

        // 🔹 Nagaland
        List<SlabRule> nagalandSlabs = new ArrayList<>();
        nagalandSlabs.add(new SlabRule(1, 4000, 0));
        nagalandSlabs.add(new SlabRule(4001, 5000, 35));
        nagalandSlabs.add(new SlabRule(5001, 7000, 75));
        nagalandSlabs.add(new SlabRule(7001, 9000, 110));
        nagalandSlabs.add(new SlabRule(9001, 12000, 180));
        nagalandSlabs.add(new SlabRule(12001, 99999, 208));
        PT_SLAB_MAP.put("nagaland", nagalandSlabs);

        // 🔹 Odisha (ORS in excel)
        List<SlabRule> odishaSlabs = new ArrayList<>();
        odishaSlabs.add(new SlabRule(1, 13333, 0));
        odishaSlabs.add(new SlabRule(13334, 25000, 125));
        odishaSlabs.add(new SlabRule(25001, 99999, 200));
 //     PT_SLAB_MAP.put("odisha", odishaSlabs);
        PT_SLAB_MAP.put("orissa", odishaSlabs);

        // 🔹 Punjab
        List<SlabRule> punjabSlabs = new ArrayList<>();
        punjabSlabs.add(new SlabRule(1, 20832, 0));
        punjabSlabs.add(new SlabRule(20833, 99999, 200));
        PT_SLAB_MAP.put("punjab", punjabSlabs);

        // 🔹 Rajasthan
        List<SlabRule> rajasthanSlabs = new ArrayList<>();
        rajasthanSlabs.add(new SlabRule(1, 99999, 0));
        PT_SLAB_MAP.put("rajasthan", rajasthanSlabs);

        // 🔹 Sikkim
        List<SlabRule> sikkimSlabs = new ArrayList<>();
        sikkimSlabs.add(new SlabRule(1, 8332, 0));
        sikkimSlabs.add(new SlabRule(8333, 16667, 13));
        sikkimSlabs.add(new SlabRule(16668, 41667, 25));
        sikkimSlabs.add(new SlabRule(41668, 166667, 42));
        sikkimSlabs.add(new SlabRule(166668, 416667, 83));
        sikkimSlabs.add(new SlabRule(416668, 833333, 125));
        sikkimSlabs.add(new SlabRule(833334, 1666667, 167));
        sikkimSlabs.add(new SlabRule(1666668, 999999, 208));
        PT_SLAB_MAP.put("sikkim", sikkimSlabs);

        // 🔹 Tamil Nadu
        List<SlabRule> tamilNaduSlabs = new ArrayList<>();
        tamilNaduSlabs.add(new SlabRule(1, 3500, 0));
        tamilNaduSlabs.add(new SlabRule(3501, 5000, 23));
        tamilNaduSlabs.add(new SlabRule(5001, 7500, 53));
        tamilNaduSlabs.add(new SlabRule(7501, 10000, 115));
        tamilNaduSlabs.add(new SlabRule(10001, 12500, 171));
        tamilNaduSlabs.add(new SlabRule(12501, 99999, 209));
        PT_SLAB_MAP.put("tamil nadu", tamilNaduSlabs);

        // 🔹 Telangana
        List<SlabRule> telanganaSlabs = new ArrayList<>();
        telanganaSlabs.add(new SlabRule(1, 15000, 0));
        telanganaSlabs.add(new SlabRule(15001, 20000, 150));
        telanganaSlabs.add(new SlabRule(20001, 99999, 200));
        PT_SLAB_MAP.put("telangana", telanganaSlabs);

        // 🔹 Tripura
        List<SlabRule> tripuraSlabs = new ArrayList<>();
        tripuraSlabs.add(new SlabRule(1, 7500, 0));
        tripuraSlabs.add(new SlabRule(7501, 15000, 150));
        tripuraSlabs.add(new SlabRule(15001, 99999, 208));
        PT_SLAB_MAP.put("tripura", tripuraSlabs);

        // 🔹 West Bengal (WEB in excel already mapped)
        List<SlabRule> westBengalSlabs = new ArrayList<>();
        westBengalSlabs.add(new SlabRule(0, 10000, 0));
        westBengalSlabs.add(new SlabRule(10001, 15000, 110));
        westBengalSlabs.add(new SlabRule(15001, 25000, 130));
        westBengalSlabs.add(new SlabRule(25001, 40000, 150));
        westBengalSlabs.add(new SlabRule(40001, 99999, 200));
        PT_SLAB_MAP.put("west bengal", westBengalSlabs);
        
        // 🔹 MAP: Madhey Pardesh 
        List<SlabRule> madheyPardesh = new ArrayList<>();
        madheyPardesh.add(new SlabRule(0, 18750, 0));
        madheyPardesh.add(new SlabRule(18750, 25000, 125));
        madheyPardesh.add(new SlabRule(25001, 33333, 166));
        madheyPardesh.add(new SlabRule(33334, 99999, 208));
        PT_SLAB_MAP.put("madhya pradesh", madheyPardesh);
        
        // 🔹 JAK : Jarkhand
        List<SlabRule> jharkhand = new ArrayList<>();
        jharkhand.add(new SlabRule(0, 24999, 0));
        jharkhand.add(new SlabRule(25000, 41667, 100));
        jharkhand.add(new SlabRule(41668, 66667, 150));
        jharkhand.add(new SlabRule(66668, 83333, 175));
        jharkhand.add(new SlabRule(83334, 999999, 208));
        PT_SLAB_MAP.put("jharkhand", jharkhand);
        
        // 🔹 PND : Jarkhand
        List<SlabRule> pondicherry = new ArrayList<>();
        pondicherry.add(new SlabRule(1, 16666, 0));
        pondicherry.add(new SlabRule(16667, 33334, 42));
        pondicherry.add(new SlabRule(33335, 50000, 84));
        pondicherry.add(new SlabRule(50001, 66667, 125));
        pondicherry.add(new SlabRule(66668, 83334, 167));
        pondicherry.add(new SlabRule(83335, 999999, 209));
        PT_SLAB_MAP.put("pondicherry", pondicherry);
        
        
        
        
        
    }


    //Rule class
    static class SlabRule {
        int min;
        int max;
        int amount;

        SlabRule(int min, int max, int amount) {
            this.min = min;
            this.max = max;
            this.amount = amount;
        }

        boolean matches(int wage) {
            return wage >= min && wage <= max;
        }
    }

    
    
    
    
    
    // ✅ Get PT amount for state and gross wage
    public static int getPTAmount(String state, int grossWage) {
        List<SlabRule> slabs = PT_SLAB_MAP.get(state.toLowerCase());
        if (slabs != null) {
            for (SlabRule rule : slabs) {
                if (rule.matches(grossWage)) {
                    return rule.amount;
                }
            }
        }
        return 0; // default agar slab nahi mila
    }
 // ✅ Overload: support double gross wages (Excel numeric cell se aata hai)
    public static int getPTAmount(String state, double grossWage) {
        int wageInt = (int) Math.round(grossWage);  // ya floor cast kar sakta hai
        return getPTAmount(state, wageInt);         // reuse existing int method
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
}




/**
Calling:- 
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

**/





//package utils;
//
//import java.text.Normalizer;
//
//public class ExcelValueNormalizer {
//
//    /**
//     * ✅ Normalizes text for loose matching.
//     *  - Trims spaces
//     *  - Converts to lowercase
//     *  - Removes extra spaces between words
//     *  - Removes accents/diacritics (like é → e)
//     */
//	
//	
//    public static String normalize(String input) {
//        if (input == null) return "";
//        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
//        normalized = normalized.replaceAll("\\p{M}", ""); // remove accents
//        return normalized.trim().replaceAll("\\s+", " ").toLowerCase();
//    }
//
//    /**
//     * ✅ Normalizes date strings to a standard format (yyyy-MM-dd)
//     * Accepts multiple date formats like dd/MM/yyyy, MM-dd-yyyy, etc.
//     */
//    public static String normalizeDate(String input) {
//        if (input == null || input.trim().isEmpty()) return "";
//        try {
//            String[] possibleFormats = {
//                "dd/MM/yyyy", "MM/dd/yyyy", "yyyy-MM-dd", "dd-MM-yyyy",
//                "dd MMM yyyy", "MMM dd, yyyy"
//            };
//            for (String format : possibleFormats) {
//                try {
//                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
//                    sdf.setLenient(false);
//                    java.util.Date date = sdf.parse(input.trim());
//                    return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
//                } catch (Exception ignored) {}
//            }
//        } catch (Exception e) {
//            return input.trim().toLowerCase();
//        }
//        return input.trim().toLowerCase();
//    }
//}
