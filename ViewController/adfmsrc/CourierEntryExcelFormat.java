import java.util.LinkedHashMap;

public class CourierEntryExcelFormat {
    public CourierEntryExcelFormat() {
        super();
    }
    
    private LinkedHashMap<String , String> courierEntryImportExcelMap;
    
    public LinkedHashMap<String, String > getCourierEntryImportExcelMap(){
        
        return courierEntryImportExcelMap;   
    }
    
    /**
     * getCourierEntryExcelFile() means getting excel file mapping that user will download from the oracle system
     * @return courierEntryImportExcelMap is the #hashmap the user will use
     */
    public LinkedHashMap<String, String> getCourierEntryExcelFile(){
        
        courierEntryImportExcelMap = getExcelMap();
        return courierEntryImportExcelMap ;   
        
    }
    
    /**
     *getExcelMap() means courier entry file's information that needs to be inserted in the #hashmap
     * @return courierEntryImportExcelMap is the #hashmap of the excel file that user will use
     */
    private LinkedHashMap <String, String>  getExcelMap(){
    
        courierEntryImportExcelMap = new LinkedHashMap<String, String>();
        
        courierEntryImportExcelMap.put("CONCIGNEE UNIT", "ConcigneeUnit");
        courierEntryImportExcelMap.put("PAYEE UNIT", "PayeeUnit");
        courierEntryImportExcelMap.put("RECEIVER", "DeliveryLocation");
        courierEntryImportExcelMap.put("SUPPLIER", "SenderUnit");
        courierEntryImportExcelMap.put("SUPPLIER COUNTRY", "SupplierCountry");
        courierEntryImportExcelMap.put("COURIER NAME", "CourierName");
        courierEntryImportExcelMap.put("AIRWAY BILL NO", "AwbId");
        courierEntryImportExcelMap.put("AIRWAY BILL DATE", "CourierDate");
//        courierEntryImportExcelMap.put("ITEM", "Item");
        courierEntryImportExcelMap.put("ITEM CATEGORY", "ItemCode");
        courierEntryImportExcelMap.put("QTY", "Qty");
//        courierEntryImportExcelMap.put("PACKAGE QTY", "PackageQty");
        courierEntryImportExcelMap.put("UOM", "Uom");
        courierEntryImportExcelMap.put("PRICE", "ValuePrice");
//        courierEntryImportExcelMap.put("CURRENCY", "Currency");
//        courierEntryImportExcelMap.put("WEIGHT", "Weight");
        courierEntryImportExcelMap.put("PURPOSE", "DevSampleBulk");
        courierEntryImportExcelMap.put("BUYER", "Buyer");
        courierEntryImportExcelMap.put("SEASON", "Season");
        courierEntryImportExcelMap.put("STYLE", "StyleNumber");
//        courierEntryImportExcelMap.put("DOC RECEIEVD DATE", "DocRcvdDate");
//        courierEntryImportExcelMap.put("INVOICE NO", "InvoiceNo");
//        courierEntryImportExcelMap.put("INVOICE DATE", "InvoiceDate");
//        courierEntryImportExcelMap.put("EXPECTED DELIVERY DATE", "ExpectedDeliveryDate");
//        courierEntryImportExcelMap.put("ACTUAL DELIVERY DATE", "ActualDeliveryDate");
//        courierEntryImportExcelMap.put("UD NO", "UdNo");
//        courierEntryImportExcelMap.put("EXPORT LC NO", "ExportLcNo");
//        courierEntryImportExcelMap.put("CNF AGENT NAME", "CnfAgentName");
//        courierEntryImportExcelMap.put("DOC HANDOVER DATE", "DocHandoverDate");
//        courierEntryImportExcelMap.put("DELIVERY DATE", "DeliveryDate");

        
        return courierEntryImportExcelMap;
    }
    

    
}
