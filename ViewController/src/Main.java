
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import oracle.jbo.domain.*;

import java.io.OutputStreamWriter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.RowId;
import java.sql.SQLException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.services.AppModuleImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.util.FacesMessageUtils;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.render.ExtendedRenderer;
import org.apache.myfaces.trinidad.util.Service;

import java.util.Calendar;


import utils.system;

import java.sql.*;

import javax.faces.convert.NumberConverter;


public class Main {
    private RichInputText awbNoInputFieldBind;
    private RichTable courierEntryImportTableBind;
    private LinkedHashMap<String, String> CourierEntryExcelMap;
    private RichTable courierEntryPdMerchantUIBindingTable;
    private RichInputFile uploadImportEntryFileBinding;

    CourierEntryExcelFormat CourierEntryExcelFormatObj =
        new CourierEntryExcelFormat();
    private RichCommandButton getUpdateCourierDocNoBind;
    private RichInputText consigneeInputTextBind;
    private RichInputText payeeInputTextBind;
    private RichInputText entryTypeExportInputTextBind;
    private RichInputListOfValues getConsigneeUnitLOVBind;
    private String awbNoImport;
    private RichInputText awbNoMerchantImportInputField;
    private RichInputText awbNoCommercialImportInputField;
    private RichInputText awbNoExportInputField;
    private RichInputDate actualDelDateInputFieldBind;
    private Map sessionScope;
    private String respId;
    private RichInputText getqtyInputValueBinding;
    private RichSelectOneChoice getUomInputValueBinding;
    private RichInputDate docHanoverDateInputDateBinding;
    private String trimmedDocHODAte;


    public Main() {
    }


    public ApplicationModule getAppM() {
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
        AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
        return appM;
    }
    AppModuleImpl appM = (AppModuleImpl)this.getAppM();

    /**
     * Custom save method
     * @param actionEvent
     */
    public void save(ActionEvent actionEvent) {
        try {
            //            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            //            String item =
            //                (String)vo.getCurrentRow().getAttribute("ItemCodeCombination");
            //            System.out.println(item);
            //
            //                        Number costCode =
            //                (Number)vo.getCurrentRow().getAttribute("CostCenterCode");
            //            System.out.println(costCode);
            //            //            oracle.jbo.domain.Number  costCode = (oracle.jbo.domain.Number)vo.getCurrentRow().getAttribute("CostCenterCode");
            //            //            System.out.println(costCode);
            //            String payUnit =
            //                (String)vo.getCurrentRow().getAttribute("PayeeUnit");
            //            System.out.println(payUnit);
            //            Date courierDate =
            //                (Date)vo.getCurrentRow().getAttribute("CourierDate");
            //            System.out.println(courierDate);
            //            //            oracle.jbo.domain.Date courierDate = (oracle.jbo.domain.Date)vo.getCurrentRow().getAttribute("CourierDate");
            //            //            System.out.println(courierDate);
            //            //String srt = costCode.stringValue();
            //            //String srt1 = costCode.stringValue();
            //            Class.forName("oracle.jdbc.driver.OracleDriver");
            //            Connection conn =
            //                DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.117:1531:adf2",
            //                                            "apps", "apps");
            //            CallableStatement cstmt =
            //                conn.prepareCall("begin :1 := XX_GET_CURIER_CONSUMPTION_F(:2,:3,:4,:5); end;");
            //            cstmt.registerOutParameter(1, Types.INTEGER);
            //            cstmt.setString(2, item);
            //            cstmt.setObject(3, costCode);
            //            cstmt.setString(4, payUnit);
            //            cstmt.setObject(5, courierDate);
            //            //cstmt.setInt(3, 1001);
            //            cstmt.execute();
            //            int result = cstmt.getInt(1);
            //            vo.getCurrentRow().setAttribute("Consumption", result);
            //            System.out.println("Result: " + result);
            //            //System.out.println(cstmt.getString());
            //            conn.close();
            System.out.println("Enter into save");
            appM.getDBTransaction().commit();
            refreshAll();
            showMessage("Data Updated Successfully!", "info");

        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }
    }

    public void save2(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            String item =
                (String)vo.getCurrentRow().getAttribute("ItemCodeCombination");
            System.out.println(item);

            Number costCode =
                (Number)vo.getCurrentRow().getAttribute("CostCenterCode");
            System.out.println(costCode);
            //            oracle.jbo.domain.Number  costCode = (oracle.jbo.domain.Number)vo.getCurrentRow().getAttribute("CostCenterCode");
            //            System.out.println(costCode);
            String payUnit =
                (String)vo.getCurrentRow().getAttribute("PayeeUnit");
            System.out.println(payUnit);
            Date courierDate =
                (Date)vo.getCurrentRow().getAttribute("CourierDate");
            System.out.println(courierDate);
            //            oracle.jbo.domain.Date courierDate = (oracle.jbo.domain.Date)vo.getCurrentRow().getAttribute("CourierDate");
            //            System.out.println(courierDate);
            //String srt = costCode.stringValue();
            //String srt1 = costCode.stringValue();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.117:1531:adf2",
                                            "apps", "apps");
            CallableStatement cstmt =
                conn.prepareCall("begin :1 := XX_GET_CURIER_CONSUMPTION_F(:2,:3,:4,:5); end;");
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, item);
            cstmt.setObject(3, costCode);
            cstmt.setString(4, payUnit);
            cstmt.setObject(5, courierDate);
            //cstmt.setInt(3, 1001);
            cstmt.execute();
            int result = cstmt.getInt(1);
            vo.getCurrentRow().setAttribute("Consumption", result);
            System.out.println("Result: " + result);
            //System.out.println(cstmt.getString());
            conn.close();
            appM.getDBTransaction().commit();
            refreshAll();
            System.out.println("Commit Executed @Save");
            showMessage("Data Save Successfully!", "info");

        } catch (Exception e) {

            e.printStackTrace();
            showMessage(e.toString(), "warn");


        }
    }

    public void setAwbNoInputFieldBind(RichInputText awbNoInputFieldBind) {
        this.awbNoInputFieldBind = awbNoInputFieldBind;
    }

    public RichInputText getAwbNoInputFieldBind() {
        return awbNoInputFieldBind;
    }

    public void setCourierEntryImportTableBind(RichTable courierEntryImportTableBind) {
        this.courierEntryImportTableBind = courierEntryImportTableBind;
    }

    public RichTable getCourierEntryImportTableBind() {
        return courierEntryImportTableBind;
    }

    public void importEntryFileFormat(javax.faces.context.FacesContext facesContext,
                                      OutputStream outputStream) throws IOException {
        // Add event code here...
        try {
            createExcelFile(outputStream);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    private void createExcelFile(OutputStream outputStream) throws IOException {

        BufferedWriter writer;

        writer =
                new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

        excelFileWrite(writer);

    }

    public void excelFileWrite(BufferedWriter writer) throws IOException {


        CourierEntryExcelMap =
                CourierEntryExcelFormatObj.getCourierEntryExcelFile();

        System.out.println("ExcelfileMap: " + CourierEntryExcelMap);

        writeIntoExcelFile(CourierEntryExcelMap, writer);


    }

    private void writeIntoExcelFile(LinkedHashMap<String, String> CourierEntryExcelMap,
                                    BufferedWriter writer) throws IOException {
        Iterator it;
        it = CourierEntryExcelMap.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry entrySet = (Map.Entry)it.next();
            writer.write(entrySet.getKey().toString());
            writer.write(",");
        }

        writer.newLine();
        writer.flush();
        writer.close();
    }


    //    public void uploadImportEntryFileValueChangeListener(ValueChangeEvent valueChangeEvent) {
    //
    //        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
    //
    //        try {
    //            parseFile(file.getInputStream());
    //
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(courierEntryPdMerchantUIBindingTable);
    //
    //        } catch (Exception e) {
    //
    //            e.printStackTrace();
    //        }
    //
    //        uploadImportEntryFileBinding.setValue(null);
    //        AdfFacesContext.getCurrentInstance().addPartialTarget(uploadImportEntryFileBinding);
    //    }

    public void setCourierEntryPdMerchantUIBindingTable(RichTable courierEntryPdMerchantUIBindingTable) {
        this.courierEntryPdMerchantUIBindingTable =
                courierEntryPdMerchantUIBindingTable;
    }

    public RichTable getCourierEntryPdMerchantUIBindingTable() {
        return courierEntryPdMerchantUIBindingTable;
    }

    public void setUploadImportEntryFileBinding(RichInputFile uploadImportEntryFileBinding) {
        this.uploadImportEntryFileBinding = uploadImportEntryFileBinding;
    }

    public RichInputFile getUploadImportEntryFileBinding() {
        return uploadImportEntryFileBinding;
    }

    //    public void parseFile(java.io.InputStream file){
    //
    //        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
    //
    //        String strLine;
    //
    //        int lineNumber = 0;
    //
    //        Row lineRow = null;
    //
    //        ViewObject vo = appM.getMnjCourierInformationImportVO1();
    //
    //        String[] excelColumnHeaders = null, excelColumnValues = null;
    //        String colHeader, colValue, voAttrName;
    //
    //        CourierEntryExcelMap = CourierEntryExcelFormatObj.getCourierEntryExcelFile();
    //
    //            if (CourierEntryExcelMap.keySet().size() == 0){
    //
    //                showMessage("Excel not generated yet " , "info");
    //
    //                return;
    //            }
    //
    //        try {
    //            while ((strLine = reader.readLine()) != null) {
    //
    //            lineNumber++;
    //
    //                //the first line is excel header row
    //                if (lineNumber == 1){
    //
    //                    excelColumnHeaders = strLine.split(",");
    //                }
    //
    //                //rest of the lines are values
    //                else if (lineNumber > 1){
    //
    //                    lineRow = vo.createRow();
    //                    insertInfoInCourierImportEntry(lineRow, vo);
    //
    //                    excelColumnValues = strLine.split(",");
    //
    //                    for (int i = 0; i < excelColumnValues.length; i++) {
    //
    //                        colHeader = excelColumnHeaders[i];
    //
    //                        colValue = excelColumnValues[i];
    //
    //                        voAttrName = CourierEntryExcelMap.get(colHeader);
    //
    //                        System.out.println("====================   i: " + i);
    //                        System.out.println("====================   colHeader: " + colHeader);
    //                        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><<><><><><><><>");
    //                        System.out.println("====================   voAttrName: " + voAttrName);
    //                        System.out.println("====================   colValue: " + colValue);
    //
    //
    //                        lineRow.setAttribute(voAttrName, colValue);
    //
    //
    //
    //                        try {
    //                            //no mapping found for excel header
    //                            if(!voAttrName.equals(null)){
    //
    //                                oracle.jbo.domain.Date d = castToJBODate (colValue);
    //
    //                                if( d == null){
    //                                    lineRow.setAttribute(voAttrName, colValue);
    //
    //                                }
    //                                else{
    //                                    lineRow.setAttribute(voAttrName, d);
    //                                }
    //
    //                            }
    //
    //                        } catch (Exception e) {
    //
    //                            e.printStackTrace();
    //                        }
    //                    }
    //
    //                }
    //
    //            }
    //
    //            reader = null;
    //
    //        } catch (Exception e) {
    //
    //            e.printStackTrace();
    //            FacesContext fctx = FacesContext.getCurrentInstance();
    //
    //            fctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Error in Uploaded file" , e.getMessage() ));
    //        }
    //
    //    }

    public void showMessage(String message, String severity) {

        FacesMessage fm = new FacesMessage(message);

        if (severity.equals("info")) {
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
        } else if (severity.equals("warn")) {
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
        } else if (severity.equals("error")) {
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }

    /**
     * Converts a String to oracle.jbo.domain.Date
     * @param String
     * @return oracle.jbo.domain.Date
     *
     */

    public oracle.jbo.domain.Date castToJBODate(String aDate) {


        java.util.Date date;

        if (aDate != null) {

            try {

                SimpleDateFormat formatter =
                    new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
                date = formatter.parse(aDate);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                oracle.jbo.domain.Date jboDate =
                    new oracle.jbo.domain.Date(sqlDate);

                System.out.println("### Date: " + jboDate);
                return jboDate;
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return null;
    }


    public void insertInfoInCourierImportEntry(Row newRow, ViewObject vo) {


        try {

            //        newRow.setAttribute("CreatedBy", userId);
            newRow.setAttribute("ImportExport", "Import");
            newRow.setAttribute("KnowStyle", "N");
            /* Sequence Generation Code of Header by PwC */
            oracle.jbo.server.SequenceImpl s =
                new oracle.jbo.server.SequenceImpl("MNJ_COURIER_INFORMATION_S",
                                                   appM.getDBTransaction());
            oracle.jbo.domain.Number sVal = s.getSequenceNumber();
            newRow.setAttribute("CourierId", sVal);
            newRow.setAttribute("CreationDate", Date.getCurrentDate());


            System.out.println("In Line Recently Created Line ID --> " + sVal);

            vo.insertRow(newRow);

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    public void customCreateForCourierLine(ActionEvent actionEvent) {

        try {


            ViewObject voLine = appM.getMnjCourierInformationLineVO1();


            Row newRow = voLine.createRow();

            voLine.insertRow(newRow);

        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }

    }

    public void setGetUpdateCourierDocNoBind(RichCommandButton getUpdateCourierDocNoBind) {
        this.getUpdateCourierDocNoBind = getUpdateCourierDocNoBind;
    }

    public RichCommandButton getGetUpdateCourierDocNoBind() {
        return getUpdateCourierDocNoBind;
    }

    public void warnCommandButton(RichCommandButton commandButton,
                                  String message) {
        FacesMessage Message = new FacesMessage(message);
        Message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(commandButton.getClientId(fc), Message);


    }

    public void customCreateForCourierLine2(ActionEvent actionEvent) {

        try {


            ViewObject voLine = appM.getMnjCourierInformationLine2VO1();


            Row newRow = voLine.createRow();

            voLine.insertRow(newRow);


        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }

    }

    public void customCreateForCourierDetail(ActionEvent actionEvent) {

        try {


            ViewObject voDetail = appM.getMnjCourierInformationDetailVO1();


            Row newRow = voDetail.createRow();

            voDetail.insertRow(newRow);


        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }

    }

    public void refreshAll(ActionEvent actionEvent) {
        try {
            refreshAll();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void refreshAll() {
        System.out.println("enter into refreshAll method....");
        ViewObject vo1, vo2, vo3, vo4, vo5, vo6, vo7, vo8, vo9, vo10;

        vo1 = appM.getMnjCourierInformationHeaderVO1();
        vo2 = appM.getMnjCourierInformationLineVO1();
        vo3 = appM.getMnjCourierInformationLine2VO1();
        vo4 = appM.getMnjCourierInformationDetailVO1();
        vo5 = appM.getMnjCourierInformationLine2ViewOnly1();
        vo6 = appM.getMnjCourierInformationDetailViewOnly1();
        vo7 = appM.getMnjCourierInformationHeaderViewOnly1();
        vo8 = appM.getCourierLineImportVO1();
        vo9 = appM.getCourierLineExportVO1();
        vo10 = appM.getMnjCourierInformationLineVOEx1();

        vo1.executeQuery();
        vo2.executeQuery();
        vo7.executeQuery();
        vo8.executeQuery();
        vo9.executeQuery();
        vo10.executeQuery();
    }

    public void setConsigneeInputTextBind(RichInputText consigneeInputTextBind) {
        this.consigneeInputTextBind = consigneeInputTextBind;
    }

    public RichInputText getConsigneeInputTextBind() {
        return consigneeInputTextBind;
    }

    public void setPayeeInputTextBind(RichInputText payeeInputTextBind) {
        this.payeeInputTextBind = payeeInputTextBind;
    }

    public RichInputText getPayeeInputTextBind() {
        return payeeInputTextBind;
    }

    public void consigneeInputTextValueChangeListener(ValueChangeEvent valueChangeEvent) {

        System.out.println("Changed Value: " + valueChangeEvent.getNewValue());
        ViewObject vo = appM.getMnjCourierInformationLineVO1();
        vo.getCurrentRow().setAttribute("PayeeUnit",
                                        valueChangeEvent.getNewValue());

    }

    public void setEntryTypeExportInputTextBind(RichInputText entryTypeExportInputTextBind) {
        this.entryTypeExportInputTextBind = entryTypeExportInputTextBind;
    }

    public RichInputText getEntryTypeExportInputTextBind() {
        return entryTypeExportInputTextBind;
    }

    public void notifyCommercial(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            String needDetails =
                (String)vo.getCurrentRow().getAttribute("NeedDetails");

            //            if (needDetails.equals("No")){
            vo.getCurrentRow().setAttribute("NeedDetails", "Yes");
            vo.getCurrentRow().setAttribute("ProcessIndicatorFlag",
                                            "NotificationSent");
            appM.getDBTransaction().commit();
            showMessage("Successfully Notified to Commercial! ", "info");
            //            vo.executeQuery();
            //             }

            if (vo.getCurrentRow().getAttribute("CompletionFlagCommercial").equals("No")) {
                vo.getCurrentRow().setAttribute("ProcessIndicatorCommerFlag",
                                                "Pending");
                appM.getDBTransaction().commit();
            }
        } catch (Exception e) {

            e.printStackTrace();
            showMessage(e.toString(), "warn");
        }


    }

    public void notifyMerchant(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            String needDetails =
                (String)vo.getCurrentRow().getAttribute("NeedDetailsCommercial");
            vo.getCurrentRow().setAttribute("NeedDetailsCommercial", "Yes");
            vo.getCurrentRow().setAttribute("ProcessIndicatorCommerFlag",
                                            "NotificationSent");

            showMessage("Successfully Notified to Merchant/PD! ", "info");
            appM.getDBTransaction().commit();

            if (vo.getCurrentRow().getAttribute("CompletionFlag").toString().equals("No")) {
                vo.getCurrentRow().setAttribute("ProcessIndicatorFlag",
                                                "Pending");
                appM.getDBTransaction().commit();
            }
            //            else (needDetails.equals("No")){

            //            vo.executeQuery();
            //             }
            //            appM.getDBTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            showMessage(e.toString(), "warn");
        }

    }

    public void submitCompleteCommandLinkListener(ActionEvent actionEvent) {
        System.out.println("enter in submitCompleteCommandLinkListener");
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            ViewObject voEx = appM.getMnjCourierInformationLineVOEx1();
            String completionFlag =
                (String)vo.getCurrentRow().getAttribute("CompletionFlag");

            if (completionFlag.equals("No")) {
                vo.getCurrentRow().setAttribute("CompletionFlag", "Yes");
                vo.getCurrentRow().setAttribute("ProcessIndicatorFlag",
                                                "Completed");
                appM.getDBTransaction().commit();
                //
                vo.executeQuery();
                voEx.executeQuery();
                showMessage("See Completed AWB No. In Completed Tab! ",
                            "info");
            }

        } catch (Exception e) {

            e.printStackTrace();
            showMessage(e.toString(), "warn");
        }
    }

    public void submitCompleteCommercialCommandLinkListener(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            ViewObject voEx = appM.getMnjCourierInformationLineVOEx1();
            String completionFlag =
                (String)vo.getCurrentRow().getAttribute("CompletionFlagCommercial");
            if (completionFlag.equals("No")) {
                vo.getCurrentRow().setAttribute("CompletionFlagCommercial",
                                                "Yes");
                vo.getCurrentRow().setAttribute("ProcessIndicatorCommerFlag",
                                                "Completed");
                appM.getDBTransaction().commit();
                showMessage("Successfully Completed! ", "info");
                vo.executeQuery();
                voEx.executeQuery();

            }

        } catch (Exception e) {

            e.printStackTrace();
            showMessage(e.toString(), "warn");
        }
    }

    public void submitCompleteMerchnatEnd(ActionEvent actionEvent) {

        try {
            ViewObject vo = appM.getMnjCourierInformationHeaderVO1();
            String submitStatusComplete =
                (String)vo.getCurrentRow().getAttribute("CompletionStatusMerchant");

            if (submitStatusComplete.equals("No")) {
                vo.getCurrentRow().setAttribute("CompletionStatusMerchant",
                                                "Yes");
                appM.getDBTransaction().commit();
                showMessage("Successfully Completed!", "info");
            }

        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }


    }

    public void submitCompleteCommercialEnd(ActionEvent actionEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationHeaderVO1();
            String submitStatusComplete =
                (String)vo.getCurrentRow().getAttribute("CompletionStatusCommercial");

            if (submitStatusComplete.equals("No")) {
                vo.getCurrentRow().setAttribute("CompletionStatusCommercial",
                                                "Yes");
                appM.getDBTransaction().commit();
                showMessage("Successfully Completed!", "info");
            }

        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }
    }

    public void setGetConsigneeUnitLOVBind(RichInputListOfValues getConsigneeUnitLOVBind) {
        this.getConsigneeUnitLOVBind = getConsigneeUnitLOVBind;
    }

    public RichInputListOfValues getGetConsigneeUnitLOVBind() {
        return getConsigneeUnitLOVBind;
    }

    public void awbIdValueChangeListener(ValueChangeEvent valueChangeEvent) {

        try {
            String newValue = valueChangeEvent.getNewValue().toString().trim();
            System.out.println("New Value: " + newValue);
            awbNoDoSpaceValidation(newValue,
                                   awbNoMerchantImportInputField); // method for checking any space appears in AWB No.
            awbNoDuplicateCheck(newValue, awbNoMerchantImportInputField,
                                appM.getCourierLineImportVO1()); // method for checking duplicate AWB No. exists or not
        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }


    }

    /**
     * method for finding duplicate AWB No
     * @param newValue
     * @param inputField
     * @param vo
     */
    private void awbNoDuplicateCheck(String newValue, RichInputText inputField,
                                     ViewObjectImpl vo) {


        try {
            RowSetIterator it = vo.createRowSetIterator("aa");
            String rowWiseAwbNo;
            while (it.hasNext()) {
                Row row = it.next();
                rowWiseAwbNo = (String)row.getAttribute("AwbId");
                if (newValue.equals(rowWiseAwbNo)) {

                    System.out.println("rowWiseAwbNo: " + rowWiseAwbNo);

                    warnInputText(inputField, "Found Duplicate AWB No!");

                    showMessage("Found Duplicate AWB No!", "warn");

                    break;

                }
            }
            it.closeRowSetIterator();

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    /**
     * method for validating any space appears in AWB No.
     * @param newValue
     * @param inputField
     *
     */
    private void awbNoDoSpaceValidation(String newValue,
                                        RichInputText inputField) {
        try {
            if (newValue.toString().contains(" ")) {
                warnInputText(inputField,
                              "Please Avoid Spaces Inside AWB No!");
                showMessage("Please Avoid Spaces Inside AWB No!", "warn");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void seasonValueChangeListner(ValueChangeEvent valueChangeEvent) {
        try {
            String season = valueChangeEvent.getNewValue().toString();
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            ViewObject voEx = appM.getMnjCourierInformationLineVOEx1();
            if (season != null) {
                System.out.println("Changed Season Value: " + season);
                vo.getCurrentRow().setAttribute("CompletionFlag", "Yes");
                vo.getCurrentRow().setAttribute("ProcessIndicatorFlag",
                                                "Completed");

            }

        } catch (Exception e) {

            showMessage(e.toString(), "warn");
        }

    }

    public void warnInputText(RichInputText inputText, String message) {
        FacesMessage Message = new FacesMessage(message);
        Message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(inputText.getClientId(fc), Message);


    }

    public void warnChoiceList(RichSelectOneChoice choiceList,
                               String message) {
        FacesMessage Message = new FacesMessage(message);
        Message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(choiceList.getClientId(fc), Message);
    }

    public void setAwbNoMerchantImportInputField(RichInputText awbNoMerchantImportInputField) {
        this.awbNoMerchantImportInputField = awbNoMerchantImportInputField;
    }

    public RichInputText getAwbNoMerchantImportInputField() {
        return awbNoMerchantImportInputField;
    }

    public void setAwbNoCommercialImportInputField(RichInputText awbNoCommercialImportInputField) {
        this.awbNoCommercialImportInputField = awbNoCommercialImportInputField;
    }

    public RichInputText getAwbNoCommercialImportInputField() {
        return awbNoCommercialImportInputField;
    }

    public void awbNoCommercialValueChangeListener(ValueChangeEvent valueChangeEvent) {
        try {
            String newValue = valueChangeEvent.getNewValue().toString().trim();
            System.out.println("New Value: " + newValue);
            awbNoDoSpaceValidation(newValue,
                                   awbNoCommercialImportInputField); // method for checking any space appears in AWB No.
            awbNoDuplicateCheck(newValue, awbNoCommercialImportInputField,
                                appM.getCourierLineImportVO1()); // method for checking duplicate AWB No. exists or not
        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }
    }

    public void setAwbNoExportInputField(RichInputText awbNoExportInputField) {
        this.awbNoExportInputField = awbNoExportInputField;
    }

    public RichInputText getAwbNoExportInputField() {
        return awbNoExportInputField;
    }

    public void awbNoExportValueChangeListener(ValueChangeEvent valueChangeEvent) {
        try {
            String newValue = valueChangeEvent.getNewValue().toString().trim();
            System.out.println("New Value: " + newValue);
            awbNoDoSpaceValidation(newValue,
                                   awbNoExportInputField); // method for checking any space appears in AWB No.
            awbNoDuplicateCheck(newValue, awbNoExportInputField,
                                appM.getCourierLineExportVO1()); // method for checking duplicate AWB No. exists or not
        } catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }
    }

    public void actualDelDateValChangeListener(ValueChangeEvent valueChangeEvent) {
        try {
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            ViewObject voEx = appM.getMnjCourierInformationLineVOEx1();

            if (!valueChangeEvent.getNewValue().equals(null)) {
                System.out.println("Actual DD changed val: " +
                                   valueChangeEvent.getNewValue());
                //                    System.out.println("Actual DD changed val2: "+ getActualDelDateInputFieldBind().getValue());
                vo.getCurrentRow().setAttribute("CompletionFlagCommercial",
                                                "Yes");
                vo.getCurrentRow().setAttribute("ProcessIndicatorCommerFlag",
                                                "Completed");
                //                    vo.getCurrentRow().setAttribute("ActualDeliveryDate", castToJboDate(getActualDelDateInputFieldBind().getValue().toString()));


                //                    appM.getDBTransaction().commit();
                //                    vo.executeQuery();
                //                    voEx.executeQuery();

            }
        } catch (Exception e) {

            e.printStackTrace();
            //            showMessage(e.toString(), "warn");
        }


    }


    public void setActualDelDateInputFieldBind(RichInputDate actualDelDateInputFieldBind) {
        this.actualDelDateInputFieldBind = actualDelDateInputFieldBind;
    }

    public RichInputDate getActualDelDateInputFieldBind() {
        return actualDelDateInputFieldBind;
    }

    public void copyRowButtonAction(ActionEvent actionEvent) {
        try {
            System.out.println("enter into copyRowButtonAction");
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            sessionScope = ADFContext.getCurrent().getSessionScope();
            respId = (String)sessionScope.get("respId");
            //            respId = "51159";

            Row row = vo.createRow();
            insertIntoCreatedRow(row, (ViewObjectImpl)vo,
                                 respId); //method for inserting value in CREATED NEW ROW

            vo.insertRow(row);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * @param row
     * @param vo
     * @param paramrespId
     * @return rowWithInsertedValue
     */
    public Row insertIntoCreatedRow(Row row, ViewObjectImpl vo,
                                    String paramrespId) {


        if (!paramrespId.equals(null) &&
            (paramrespId.equals("51159") || paramrespId.equals("52666"))) {
            System.out.println("Enter into if insertIntoMerchantCreatedRow ....");
            row.setAttribute("CourierName",
                             vo.getCurrentRow().getAttribute("CourierName"));
            //            row.setAttribute("AwbId", vo.getCurrentRow().getAttribute("AwbId"));
            row.setAttribute("CourierDate",
                             vo.getCurrentRow().getAttribute("CourierDate"));
            row.setAttribute("ConcigneeUnit",
                             vo.getCurrentRow().getAttribute("ConcigneeUnit"));
            row.setAttribute("PayeeUnit",
                             vo.getCurrentRow().getAttribute("PayeeUnit"));
            row.setAttribute("SenderUnit",
                             vo.getCurrentRow().getAttribute("SenderUnit"));
            row.setAttribute("SupplierCountry",
                             vo.getCurrentRow().getAttribute("SupplierCountry"));
            row.setAttribute("DeliveryLocation",
                             vo.getCurrentRow().getAttribute("DeliveryLocation"));
            row.setAttribute("ItemCode",
                             vo.getCurrentRow().getAttribute("ItemCode"));
            row.setAttribute("Item", vo.getCurrentRow().getAttribute("Item"));
            row.setAttribute("DevSampleBulk",
                             vo.getCurrentRow().getAttribute("DevSampleBulk"));
            row.setAttribute("Buyer",
                             vo.getCurrentRow().getAttribute("Buyer"));
            row.setAttribute("Season",
                             vo.getCurrentRow().getAttribute("Season"));
            row.setAttribute("Qty", vo.getCurrentRow().getAttribute("Qty"));
            row.setAttribute("Uom", vo.getCurrentRow().getAttribute("Uom"));
            row.setAttribute("ValuePrice",
                             vo.getCurrentRow().getAttribute("ValuePrice"));
            row.setAttribute("Remarks",
                             vo.getCurrentRow().getAttribute("Remarks"));
            row.setAttribute("MerchantReceivedBy",
                             vo.getCurrentRow().getAttribute("MerchantReceivedBy"));
            row.setAttribute("CompletionFlag", "Yes");
            row.setAttribute("ProcessIndicatorFlag", "Completed");

        }

        else if (!paramrespId.equals(null) && paramrespId.equals("51318")) {
            System.out.println("Enter into elseif insertIntoCommercialCreatedRow ....");
            row.setAttribute("CourierName",
                             vo.getCurrentRow().getAttribute("CourierName"));
            //            row.setAttribute("AwbId", vo.getCurrentRow().getAttribute("AwbId"));
            row.setAttribute("CourierDate",
                             vo.getCurrentRow().getAttribute("CourierDate"));
            row.setAttribute("ConcigneeUnit",
                             vo.getCurrentRow().getAttribute("ConcigneeUnit"));
            row.setAttribute("PayeeUnit",
                             vo.getCurrentRow().getAttribute("PayeeUnit"));
            row.setAttribute("SenderUnit",
                             vo.getCurrentRow().getAttribute("SenderUnit"));
            row.setAttribute("SupplierCountry",
                             vo.getCurrentRow().getAttribute("SupplierCountry"));
            row.setAttribute("DeliveryLocation",
                             vo.getCurrentRow().getAttribute("DeliveryLocation"));
            row.setAttribute("ItemCode",
                             vo.getCurrentRow().getAttribute("ItemCode"));
            row.setAttribute("Item", vo.getCurrentRow().getAttribute("Item"));
            row.setAttribute("DevSampleBulk",
                             vo.getCurrentRow().getAttribute("DevSampleBulk"));
            row.setAttribute("Buyer",
                             vo.getCurrentRow().getAttribute("Buyer"));
            row.setAttribute("Season",
                             vo.getCurrentRow().getAttribute("Season"));
            row.setAttribute("Qty", vo.getCurrentRow().getAttribute("Qty"));
            row.setAttribute("Uom", vo.getCurrentRow().getAttribute("Uom"));
            row.setAttribute("ValuePrice",
                             vo.getCurrentRow().getAttribute("ValuePrice"));
            row.setAttribute("RemarksCommercial",
                             vo.getCurrentRow().getAttribute("RemarksCommercial"));
            row.setAttribute("MerchantReceivedBy",
                             vo.getCurrentRow().getAttribute("MerchantReceivedBy"));
            /**
             * line #997-1012 is for commercial purpose
             */
            row.setAttribute("InvoiceNo",
                             vo.getCurrentRow().getAttribute("InvoiceNo"));
            //            row.setAttribute("AwbId", vo.getCurrentRow().getAttribute("AwbId"));
            row.setAttribute("InvoiceDate",
                             vo.getCurrentRow().getAttribute("InvoiceDate"));
            row.setAttribute("Currency",
                             vo.getCurrentRow().getAttribute("Currency"));
            row.setAttribute("PackageQty",
                             vo.getCurrentRow().getAttribute("PackageQty"));
            row.setAttribute("Weight",
                             vo.getCurrentRow().getAttribute("Weight"));
            row.setAttribute("QtyYard",
                             vo.getCurrentRow().getAttribute("QtyYard"));
            row.setAttribute("DocRcvdDate",
                             vo.getCurrentRow().getAttribute("DocRcvdDate"));
            row.setAttribute("DocHandoverDate",
                             vo.getCurrentRow().getAttribute("DocHandoverDate"));
            row.setAttribute("ExpectedDeliveryDate",
                             vo.getCurrentRow().getAttribute("ExpectedDeliveryDate"));
            //            row.setAttribute("ActualDeliveryDate", vo.getCurrentRow().getAttribute("ActualDeliveryDate"));
            row.setAttribute("UdNo", vo.getCurrentRow().getAttribute("UdNo"));
            row.setAttribute("ExportLcNo",
                             vo.getCurrentRow().getAttribute("ExportLcNo"));
            row.setAttribute("CnfAgentName",
                             vo.getCurrentRow().getAttribute("CnfAgentName"));
            //            row.setAttribute("CompletionFlagCommercial", "Yes");
            //            row.setAttribute("ProcessIndicatorCommerFlag", "Copied");

        }


        return row;

    }

    public void setGetqtyInputValueBinding(RichInputText getqtyInputValueBinding) {
        this.getqtyInputValueBinding = getqtyInputValueBinding;
    }

    public RichInputText getGetqtyInputValueBinding() {
        return getqtyInputValueBinding;
    }

    public void setGetUomInputValueBinding(RichSelectOneChoice getUomInputValueBinding) {
        this.getUomInputValueBinding = getUomInputValueBinding;
    }

    public RichSelectOneChoice getGetUomInputValueBinding() {
        return getUomInputValueBinding;
    }


    public void qtyValueChangeListener(ValueChangeEvent valueChangeEvent) {
        try {
            System.out.println("UOM Value: " +
                               getUomInputValueBinding.getValue().toString());
            System.out.println("Qty Value: " +
                               getqtyInputValueBinding.getValue());

            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            if (!getqtyInputValueBinding.getValue().equals(null) &&
                getUomInputValueBinding.getValue().toString().equals("0")) {
                System.out.println("In Yard");
                System.out.println("Qty in YDS: " +
                                   Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                              1));
                vo.getCurrentRow().setAttribute("QtyYard",
                                                Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                                           1));

            }


            else if (!getqtyInputValueBinding.getValue().equals(null) &&
                     getUomInputValueBinding.getValue().toString().equals("1")) {
                System.out.println("In Set");
                System.out.println("Qty in YDS: " +
                                   Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                              1));
                vo.getCurrentRow().setAttribute("QtyYard",
                                                Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                                           1));
            } else if (!getqtyInputValueBinding.getValue().equals(null) &&
                       getUomInputValueBinding.getValue().toString().equals("2")) {
                System.out.println("In Meter");

                System.out.println("Qty in YDS: " +
                                   Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                              1.0936));
                vo.getCurrentRow().setAttribute("QtyYard",
                                                Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                                           1.0936));

            } else if (!getqtyInputValueBinding.getValue().equals(null) &&
                       getUomInputValueBinding.getValue().toString().equals("3")) {
                System.out.println("In Piece");
                System.out.println("Qty in YDS: " +
                                   Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                              1));
                vo.getCurrentRow().setAttribute("QtyYard",
                                                Math.round(Double.parseDouble(getqtyInputValueBinding.getValue().toString()) *
                                                           1));
            }
        } catch (NullPointerException ex) {
            showMessage("UOM Can't Be Empty!", "warn");
            warnChoiceList(getUomInputValueBinding, "UOM Can't Be Empty!");
        }

        catch (Exception e) {
            showMessage(e.toString(), "warn");
            e.printStackTrace();
        }

    }

    public void docHandoverDateValueChangeListener(ValueChangeEvent valueChangeEvent) {
        try {
            System.out.println("Before Parsing Doc H/O Date: " +
                               docHanoverDateInputDateBinding.getValue().toString());
            trimmedDocHODAte =
                    trimmedDate(docHanoverDateInputDateBinding.getValue().toString());
            System.out.println("Before Parsing Trimmed Doc H/O Date: " +
                               trimmedDocHODAte);
            ViewObject vo = appM.getMnjCourierInformationLineVO1();
            SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");

            //            SimpleDateFormat dateFormat2 = new  SimpleDateFormat ("dd-MMM-yyyy");

            Calendar cal =
                Calendar.getInstance(); // current input doc h/o date
            Calendar cal2 =
                Calendar.getInstance(); // +3 days from doc h/o date
            Calendar cal3 =
                Calendar.getInstance(); // +4 days from doc h/o date
            Calendar cal4 =
                Calendar.getInstance(); // +5 days from doc h/o date
            //            Calendar cal5 = Calendar.getInstance();
            //            Calendar cal6 = Calendar.getInstance();

            cal.setTime(dateFormat.parse(docHanoverDateInputDateBinding.getValue().toString()));
            cal2.setTime(dateFormat.parse(docHanoverDateInputDateBinding.getValue().toString()));
            cal3.setTime(dateFormat.parse(docHanoverDateInputDateBinding.getValue().toString()));
            cal4.setTime(dateFormat.parse(docHanoverDateInputDateBinding.getValue().toString()));
            //            cal4.setTime(dateFormat2.parse(trimmedDocHODAte));
            //            cal5.setTime(dateFormat2.parse(trimmedDocHODAte));
            //            cal6.setTime(dateFormat2.parse(trimmedDocHODAte));

            System.out.println("After Parsing Doc H/O Date: " +
                               dateFormat.parse(docHanoverDateInputDateBinding.getValue().toString()));


            if (cal.getTime().toString().contains("Sun")) { // Sun
                System.out.println("Into Sun....");
                cal2.add(Calendar.DATE,
                         3); //adding 3 days to current input doc h/o date
                System.out.println("  3 Days Later: " +
                                   cal2.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal2.getTime());

            } else if (cal.getTime().toString().contains("Mon")) { //Mon
                System.out.println("Into Mon....");
                cal2.add(Calendar.DATE,
                         3); //adding 3 days to current input doc h/o date
                System.out.println("  3 Days Later: " +
                                   cal2.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal2.getTime());

            } else if (cal.getTime().toString().contains("Tue")) { //Tue
                System.out.println("Into Tue....");
                cal4.add(Calendar.DATE,
                         5); //adding 5 days to current input doc h/o date
                System.out.println("  5 Days Later: " +
                                   cal4.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal4.getTime());

            } else if (cal.getTime().toString().contains("Wed")) { //Wed
                System.out.println("Into Wed....");
                cal4.add(Calendar.DATE,
                         5); //adding 5 days to current input doc h/o date
                System.out.println("  5 Days Later: " +
                                   cal4.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal4.getTime());

            } else if (cal.getTime().toString().contains("Thu")) { //Thu
                System.out.println("Into Thu....");
                cal4.add(Calendar.DATE,
                         5); //adding 5 days to current input doc h/o date
                System.out.println("  5 Days Later: " +
                                   cal4.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal4.getTime());

            } else if (cal.getTime().toString().contains("Fri")) { //Fri
                System.out.println("Into Fri....");
                cal3.add(Calendar.DATE,
                         4); //adding 4 days to current input doc h/o date
                System.out.println("  4 Days Later: " +
                                   cal3.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal3.getTime());

            } else if (cal.getTime().toString().contains("Sat")) { //Sat
                System.out.println("Into Sat....");
                cal2.add(Calendar.DATE,
                         3); //adding 3 days to current input doc h/o date
                System.out.println("  3 Days Later: " +
                                   cal2.getTime().toString());
                vo.getCurrentRow().setAttribute("ExpectedDeliveryDate",
                                                cal2.getTime());
            }


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public String trimmedDate(String Date) {
        String trimmedDate = Date.substring(0, 11);

        return trimmedDate;
    }

    public static java.util.Date convertDomainDateToUtilDate(oracle.jbo.domain.Date domainDate) throws SQLException {

        if (domainDate != null) {
            return domainDate.getValue();
        }
        return null;

    }

    //    public static Date addDays(Date date, int days)
    //        {
    //            Calendar cal = Calendar.getInstance();
    //            cal.setTime(date);
    //            cal.add(Calendar.DATE, days); //minus number would decrement the days
    //            return cal.getTime();
    //        }


    public void setDocHanoverDateInputDateBinding(RichInputDate docHanoverDateInputDateBinding) {
        this.docHanoverDateInputDateBinding = docHanoverDateInputDateBinding;
    }

    public RichInputDate getDocHanoverDateInputDateBinding() {
        return docHanoverDateInputDateBinding;
    }
}

