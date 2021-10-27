package model.entity;

import java.sql.SQLException;

import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Nov 15 11:02:56 BDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MnjCourierInformationExportEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        AwbId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getAwbId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setAwbId((String)value);
            }
        }
        ,
        CourierId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getCourierId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setCourierId((Number)value);
            }
        }
        ,
        CourierName {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getCourierName();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setCourierName((String)value);
            }
        }
        ,
        ImportExport {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getImportExport();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setImportExport((String)value);
            }
        }
        ,
        CourierDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getCourierDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setCourierDate((Date)value);
            }
        }
        ,
        Buyer {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getBuyer();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setBuyer((String)value);
            }
        }
        ,
        BuyerId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getBuyerId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setBuyerId((Number)value);
            }
        }
        ,
        DevSampleBulk {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getDevSampleBulk();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setDevSampleBulk((String)value);
            }
        }
        ,
        Unit {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getUnit();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setUnit((String)value);
            }
        }
        ,
        SenderUnit {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getSenderUnit();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setSenderUnit((String)value);
            }
        }
        ,
        DeliveryLocation {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getDeliveryLocation();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setDeliveryLocation((String)value);
            }
        }
        ,
        UserName {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getUserName();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setUserName((String)value);
            }
        }
        ,
        Season {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getSeason();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setSeason((String)value);
            }
        }
        ,
        StyleNumber {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getStyleNumber();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setStyleNumber((String)value);
            }
        }
        ,
        BpoNumber {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getBpoNumber();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setBpoNumber((String)value);
            }
        }
        ,
        ItemCode {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getItemCode();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setItemCode((String)value);
            }
        }
        ,
        Qty {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getQty();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setQty((String)value);
            }
        }
        ,
        DocRcvdDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getDocRcvdDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setDocRcvdDate((Date)value);
            }
        }
        ,
        ExpectedDeliveryDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getExpectedDeliveryDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setExpectedDeliveryDate((Date)value);
            }
        }
        ,
        ActualDeliveryDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getActualDeliveryDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setActualDeliveryDate((Date)value);
            }
        }
        ,
        OrgId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getOrgId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setOrgId((Number)value);
            }
        }
        ,
        SampleDocNo {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getSampleDocNo();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setSampleDocNo((Number)value);
            }
        }
        ,
        VersionNo {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getVersionNo();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setVersionNo((Number)value);
            }
        }
        ,
        VersionDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getVersionDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setVersionDate((Date)value);
            }
        }
        ,
        RespId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getRespId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setRespId((Number)value);
            }
        }
        ,
        UserId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getUserId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setUserId((Number)value);
            }
        }
        ,
        CreationDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        CreatedBy {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        Uom {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getUom();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setUom((String)value);
            }
        }
        ,
        KnowStyle {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getKnowStyle();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setKnowStyle((String)value);
            }
        }
        ,
        HeaderId {
            public Object get(MnjCourierInformationExportEOImpl obj) {
                return obj.getHeaderId();
            }

            public void put(MnjCourierInformationExportEOImpl obj,
                            Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MnjCourierInformationExportEOImpl object);

        public abstract void put(MnjCourierInformationExportEOImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int AWBID = AttributesEnum.AwbId.index();
    public static final int COURIERID = AttributesEnum.CourierId.index();
    public static final int COURIERNAME = AttributesEnum.CourierName.index();
    public static final int IMPORTEXPORT = AttributesEnum.ImportExport.index();
    public static final int COURIERDATE = AttributesEnum.CourierDate.index();
    public static final int BUYER = AttributesEnum.Buyer.index();
    public static final int BUYERID = AttributesEnum.BuyerId.index();
    public static final int DEVSAMPLEBULK = AttributesEnum.DevSampleBulk.index();
    public static final int UNIT = AttributesEnum.Unit.index();
    public static final int SENDERUNIT = AttributesEnum.SenderUnit.index();
    public static final int DELIVERYLOCATION = AttributesEnum.DeliveryLocation.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int SEASON = AttributesEnum.Season.index();
    public static final int STYLENUMBER = AttributesEnum.StyleNumber.index();
    public static final int BPONUMBER = AttributesEnum.BpoNumber.index();
    public static final int ITEMCODE = AttributesEnum.ItemCode.index();
    public static final int QTY = AttributesEnum.Qty.index();
    public static final int DOCRCVDDATE = AttributesEnum.DocRcvdDate.index();
    public static final int EXPECTEDDELIVERYDATE = AttributesEnum.ExpectedDeliveryDate.index();
    public static final int ACTUALDELIVERYDATE = AttributesEnum.ActualDeliveryDate.index();
    public static final int ORGID = AttributesEnum.OrgId.index();
    public static final int SAMPLEDOCNO = AttributesEnum.SampleDocNo.index();
    public static final int VERSIONNO = AttributesEnum.VersionNo.index();
    public static final int VERSIONDATE = AttributesEnum.VersionDate.index();
    public static final int RESPID = AttributesEnum.RespId.index();
    public static final int USERID = AttributesEnum.UserId.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int UOM = AttributesEnum.Uom.index();
    public static final int KNOWSTYLE = AttributesEnum.KnowStyle.index();
    public static final int HEADERID = AttributesEnum.HeaderId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MnjCourierInformationExportEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.entity.MnjCourierInformationExportEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for AwbId, using the alias name AwbId.
     * @return the AwbId
     */
    public String getAwbId() {
        return (String)getAttributeInternal(AWBID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AwbId.
     * @param value value to set the AwbId
     */
    public void setAwbId(String value) {
        setAttributeInternal(AWBID, value);
    }

    /**
     * Gets the attribute value for CourierId, using the alias name CourierId.
     * @return the CourierId
     */
    public Number getCourierId() {
        return (Number)getAttributeInternal(COURIERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CourierId.
     * @param value value to set the CourierId
     */
    public void setCourierId(Number value) {
        setAttributeInternal(COURIERID, value);
    }

    /**
     * Gets the attribute value for CourierName, using the alias name CourierName.
     * @return the CourierName
     */
    public String getCourierName() {
        return (String)getAttributeInternal(COURIERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for CourierName.
     * @param value value to set the CourierName
     */
    public void setCourierName(String value) {
        setAttributeInternal(COURIERNAME, value);
    }

    /**
     * Gets the attribute value for ImportExport, using the alias name ImportExport.
     * @return the ImportExport
     */
    public String getImportExport() {
        return (String)getAttributeInternal(IMPORTEXPORT);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImportExport.
     * @param value value to set the ImportExport
     */
    public void setImportExport(String value) {
        setAttributeInternal(IMPORTEXPORT, value);
    }

    /**
     * Gets the attribute value for CourierDate, using the alias name CourierDate.
     * @return the CourierDate
     */
    public Date getCourierDate() {
        return (Date)getAttributeInternal(COURIERDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CourierDate.
     * @param value value to set the CourierDate
     */
    public void setCourierDate(Date value) {
        setAttributeInternal(COURIERDATE, value);
    }

    /**
     * Gets the attribute value for Buyer, using the alias name Buyer.
     * @return the Buyer
     */
    public String getBuyer() {
        return (String)getAttributeInternal(BUYER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Buyer.
     * @param value value to set the Buyer
     */
    public void setBuyer(String value) {
        setAttributeInternal(BUYER, value);
    }

    /**
     * Gets the attribute value for BuyerId, using the alias name BuyerId.
     * @return the BuyerId
     */
    public Number getBuyerId() {
        return (Number)getAttributeInternal(BUYERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for BuyerId.
     * @param value value to set the BuyerId
     */
    public void setBuyerId(Number value) {
        setAttributeInternal(BUYERID, value);
    }

    /**
     * Gets the attribute value for DevSampleBulk, using the alias name DevSampleBulk.
     * @return the DevSampleBulk
     */
    public String getDevSampleBulk() {
        return (String)getAttributeInternal(DEVSAMPLEBULK);
    }

    /**
     * Sets <code>value</code> as the attribute value for DevSampleBulk.
     * @param value value to set the DevSampleBulk
     */
    public void setDevSampleBulk(String value) {
        setAttributeInternal(DEVSAMPLEBULK, value);
    }

    /**
     * Gets the attribute value for Unit, using the alias name Unit.
     * @return the Unit
     */
    public String getUnit() {
        return (String)getAttributeInternal(UNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Unit.
     * @param value value to set the Unit
     */
    public void setUnit(String value) {
        setAttributeInternal(UNIT, value);
    }

    /**
     * Gets the attribute value for SenderUnit, using the alias name SenderUnit.
     * @return the SenderUnit
     */
    public String getSenderUnit() {
        return (String)getAttributeInternal(SENDERUNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for SenderUnit.
     * @param value value to set the SenderUnit
     */
    public void setSenderUnit(String value) {
        setAttributeInternal(SENDERUNIT, value);
    }

    /**
     * Gets the attribute value for DeliveryLocation, using the alias name DeliveryLocation.
     * @return the DeliveryLocation
     */
    public String getDeliveryLocation() {
        return (String)getAttributeInternal(DELIVERYLOCATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for DeliveryLocation.
     * @param value value to set the DeliveryLocation
     */
    public void setDeliveryLocation(String value) {
        setAttributeInternal(DELIVERYLOCATION, value);
    }

    /**
     * Gets the attribute value for UserName, using the alias name UserName.
     * @return the UserName
     */
    public String getUserName() {
        return (String)getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserName.
     * @param value value to set the UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**
     * Gets the attribute value for Season, using the alias name Season.
     * @return the Season
     */
    public String getSeason() {
        return (String)getAttributeInternal(SEASON);
    }

    /**
     * Sets <code>value</code> as the attribute value for Season.
     * @param value value to set the Season
     */
    public void setSeason(String value) {
        setAttributeInternal(SEASON, value);
    }

    /**
     * Gets the attribute value for StyleNumber, using the alias name StyleNumber.
     * @return the StyleNumber
     */
    public String getStyleNumber() {
        return (String)getAttributeInternal(STYLENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for StyleNumber.
     * @param value value to set the StyleNumber
     */
    public void setStyleNumber(String value) {
        setAttributeInternal(STYLENUMBER, value);
    }

    /**
     * Gets the attribute value for BpoNumber, using the alias name BpoNumber.
     * @return the BpoNumber
     */
    public String getBpoNumber() {
        return (String)getAttributeInternal(BPONUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for BpoNumber.
     * @param value value to set the BpoNumber
     */
    public void setBpoNumber(String value) {
        setAttributeInternal(BPONUMBER, value);
    }

    /**
     * Gets the attribute value for ItemCode, using the alias name ItemCode.
     * @return the ItemCode
     */
    public String getItemCode() {
        return (String)getAttributeInternal(ITEMCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemCode.
     * @param value value to set the ItemCode
     */
    public void setItemCode(String value) {
        setAttributeInternal(ITEMCODE, value);
    }

    /**
     * Gets the attribute value for Qty, using the alias name Qty.
     * @return the Qty
     */
    public String getQty() {
        return (String)getAttributeInternal(QTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Qty.
     * @param value value to set the Qty
     */
    public void setQty(String value) {
        setAttributeInternal(QTY, value);
    }

    /**
     * Gets the attribute value for DocRcvdDate, using the alias name DocRcvdDate.
     * @return the DocRcvdDate
     */
    public Date getDocRcvdDate() {
        return (Date)getAttributeInternal(DOCRCVDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocRcvdDate.
     * @param value value to set the DocRcvdDate
     */
    public void setDocRcvdDate(Date value) {
        setAttributeInternal(DOCRCVDDATE, value);
    }

    /**
     * Gets the attribute value for ExpectedDeliveryDate, using the alias name ExpectedDeliveryDate.
     * @return the ExpectedDeliveryDate
     */
    public Date getExpectedDeliveryDate() {
        return (Date)getAttributeInternal(EXPECTEDDELIVERYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpectedDeliveryDate.
     * @param value value to set the ExpectedDeliveryDate
     */
    public void setExpectedDeliveryDate(Date value) {
        setAttributeInternal(EXPECTEDDELIVERYDATE, value);
    }

    /**
     * Gets the attribute value for ActualDeliveryDate, using the alias name ActualDeliveryDate.
     * @return the ActualDeliveryDate
     */
    public Date getActualDeliveryDate() {
        return (Date)getAttributeInternal(ACTUALDELIVERYDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ActualDeliveryDate.
     * @param value value to set the ActualDeliveryDate
     */
    public void setActualDeliveryDate(Date value) {
        setAttributeInternal(ACTUALDELIVERYDATE, value);
    }

    /**
     * Gets the attribute value for OrgId, using the alias name OrgId.
     * @return the OrgId
     */
    public Number getOrgId() {
        return (Number)getAttributeInternal(ORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrgId.
     * @param value value to set the OrgId
     */
    public void setOrgId(Number value) {
        setAttributeInternal(ORGID, value);
    }

    /**
     * Gets the attribute value for SampleDocNo, using the alias name SampleDocNo.
     * @return the SampleDocNo
     */
    public Number getSampleDocNo() {
        return (Number)getAttributeInternal(SAMPLEDOCNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for SampleDocNo.
     * @param value value to set the SampleDocNo
     */
    public void setSampleDocNo(Number value) {
        setAttributeInternal(SAMPLEDOCNO, value);
    }

    /**
     * Gets the attribute value for VersionNo, using the alias name VersionNo.
     * @return the VersionNo
     */
    public Number getVersionNo() {
        return (Number)getAttributeInternal(VERSIONNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for VersionNo.
     * @param value value to set the VersionNo
     */
    public void setVersionNo(Number value) {
        setAttributeInternal(VERSIONNO, value);
    }

    /**
     * Gets the attribute value for VersionDate, using the alias name VersionDate.
     * @return the VersionDate
     */
    public Date getVersionDate() {
        return (Date)getAttributeInternal(VERSIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for VersionDate.
     * @param value value to set the VersionDate
     */
    public void setVersionDate(Date value) {
        setAttributeInternal(VERSIONDATE, value);
    }

    /**
     * Gets the attribute value for RespId, using the alias name RespId.
     * @return the RespId
     */
    public Number getRespId() {
        return (Number)getAttributeInternal(RESPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RespId.
     * @param value value to set the RespId
     */
    public void setRespId(Number value) {
        setAttributeInternal(RESPID, value);
    }

    /**
     * Gets the attribute value for UserId, using the alias name UserId.
     * @return the UserId
     */
    public Number getUserId() {
        return (Number)getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UserId.
     * @param value value to set the UserId
     */
    public void setUserId(Number value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for Uom, using the alias name Uom.
     * @return the Uom
     */
    public String getUom() {
        return (String)getAttributeInternal(UOM);
    }

    /**
     * Sets <code>value</code> as the attribute value for Uom.
     * @param value value to set the Uom
     */
    public void setUom(String value) {
        setAttributeInternal(UOM, value);
    }

    /**
     * Gets the attribute value for KnowStyle, using the alias name KnowStyle.
     * @return the KnowStyle
     */
    public String getKnowStyle() {
        return (String)getAttributeInternal(KNOWSTYLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for KnowStyle.
     * @param value value to set the KnowStyle
     */
    public void setKnowStyle(String value) {
        setAttributeInternal(KNOWSTYLE, value);
    }

    /**
     * Gets the attribute value for HeaderId, using the alias name HeaderId.
     * @return the HeaderId
     */
    public Number getHeaderId() {
        return (Number)getAttributeInternal(HEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HeaderId.
     * @param value value to set the HeaderId
     */
    public void setHeaderId(Number value) {
        setAttributeInternal(HEADERID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }


    /**
     * @param courierId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number courierId) {
        return new Key(new Object[]{courierId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
        
//        System.out.println("@Into courier entry export create ...");
//        /* Sequence Generation Code of Header by PwC */  
//         oracle.jbo.server.SequenceImpl s = new oracle.jbo.server.SequenceImpl("MNJ_COURIER_INFORMATION_S",getDBTransaction());          
//         oracle.jbo.domain.Number sVal = s.getSequenceNumber();
//         setImportExport("Export");
//         setKnowStyle("N");
//         setCourierId(sVal);
//         setCreationDate((Date)Date.getCurrentDate());
//         System.out.println("In Line Recently Created Line ID --> " + sVal);
//         /* End Sequence Generation Code of Header by PwC */
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

      /**
       * Custom DML update/insert/delete logic here.
       * @param operation the operation type
       * @param e the transaction event
       */
       protected void doDML(int operation, TransactionEvent e) {
             
             super.doDML(operation, e);
       }
}