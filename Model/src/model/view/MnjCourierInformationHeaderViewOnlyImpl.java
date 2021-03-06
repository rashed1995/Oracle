package model.view;

import model.services.CustomViewImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 01 16:16:44 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MnjCourierInformationHeaderViewOnlyImpl extends CustomViewImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public MnjCourierInformationHeaderViewOnlyImpl() {
    }

    /**
     * Returns the bind variable value for RESP_ID.
     * @return bind variable value for RESP_ID
     */
    public String getRESP_ID() {
        return (String)getNamedWhereClauseParam("RESP_ID");
    }

    /**
     * Sets <code>value</code> for bind variable RESP_ID.
     * @param value value to bind as RESP_ID
     */
    public void setRESP_ID(String value) {
        setNamedWhereClauseParam("RESP_ID", value);
    }
}
