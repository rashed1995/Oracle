package model.services;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import model.services.common.AppModule;


import model.view.MnjCourierInformationHeaderVOImpl;
import model.view.MnjCourierInformationHeaderViewOnlyImpl;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 26 10:59:01 BDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }


    /* Method to Populate WHO Column */

    public void setSessionValues(String orgId, String userId, String respId,
                                 String respAppl) {

        System.out.println("Session UserId: " + userId);
        
        System.out.println("Session RespId: " + respId);

        
        if (userId != null) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();
            HttpSession userSession = (HttpSession)ectx.getSession(false);
            userSession.setAttribute("userId", userId);
             
//            userSession.setAttribute("orgId", orgId);
            userSession.setAttribute("respId", respId);
            userId="1288";
            //respId="51318";//commercial
            respId="51159";
            //respId="52666";//marchat
            
        }
    }


    /**
     * Container's getter for MnjCourierInformationHeaderVO1.
     * @return MnjCourierInformationHeaderVO1
     */
    public ViewObjectImpl getMnjCourierInformationHeaderVO1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationHeaderVO1");
    }

    /**
     * Container's getter for MnjCourierInformationLineVO1.
     * @return MnjCourierInformationLineVO1
     */
    public ViewObjectImpl getMnjCourierInformationLineVO1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationLineVO1");
    }

    /**
     * Container's getter for MnjCourierInformationLiFkLink1.
     * @return MnjCourierInformationLiFkLink1
     */
    public ViewLinkImpl getMnjCourierInformationLiFkLink1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformationLiFkLink1");
    }

    /**
     * Container's getter for MnjCourierInformationLine2VO1.
     * @return MnjCourierInformationLine2VO1
     */
    public ViewObjectImpl getMnjCourierInformationLine2VO1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationLine2VO1");
    }

    /**
     * Container's getter for MnjCourierInformatnLi2FkLink1.
     * @return MnjCourierInformatnLi2FkLink1
     */
    public ViewLinkImpl getMnjCourierInformatnLi2FkLink1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformatnLi2FkLink1");
    }

    /**
     * Container's getter for MnjCourierInformationDetailVO1.
     * @return MnjCourierInformationDetailVO1
     */
    public ViewObjectImpl getMnjCourierInformationDetailVO1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationDetailVO1");
    }

    /**
     * Container's getter for MnjCourierInformationDetFkLink1.
     * @return MnjCourierInformationDetFkLink1
     */
    public ViewLinkImpl getMnjCourierInformationDetFkLink1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformationDetFkLink1");
    }


    /**
     * Container's getter for MnjCourierInformationHeaderViewOnly1.
     * @return MnjCourierInformationHeaderViewOnly1
     */
    public ViewObjectImpl getMnjCourierInformationHeaderViewOnly1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationHeaderViewOnly1");
    }

    /**
     * Container's getter for MnjCourierInformationLine2ViewOnly1.
     * @return MnjCourierInformationLine2ViewOnly1
     */
    public ViewObjectImpl getMnjCourierInformationLine2ViewOnly1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationLine2ViewOnly1");
    }

    /**
     * Container's getter for MnjCourierInformatnLi2FkLink1_1.
     * @return MnjCourierInformatnLi2FkLink1_1
     */
    public ViewLinkImpl getMnjCourierInformatnLi2FkLink1_1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformatnLi2FkLink1_1");
    }

    /**
     * Container's getter for MnjCourierInformationLineViewOnly1.
     * @return MnjCourierInformationLineViewOnly1
     */
    public ViewObjectImpl getMnjCourierInformationLineViewOnly1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationLineViewOnly1");
    }

    /**
     * Container's getter for MnjCourierInformationLiFkLink1_1.
     * @return MnjCourierInformationLiFkLink1_1
     */
    public ViewLinkImpl getMnjCourierInformationLiFkLink1_1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformationLiFkLink1_1");
    }

    /**
     * Container's getter for MnjCourierInformationDetailViewOnly1.
     * @return MnjCourierInformationDetailViewOnly1
     */
    public ViewObjectImpl getMnjCourierInformationDetailViewOnly1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationDetailViewOnly1");
    }

    /**
     * Container's getter for MnjCourierInformationDetFkLink1_1.
     * @return MnjCourierInformationDetFkLink1_1
     */
    public ViewLinkImpl getMnjCourierInformationDetFkLink1_1() {
        return (ViewLinkImpl)findViewLink("MnjCourierInformationDetFkLink1_1");
    }

    /**
     * Container's getter for MnjCourierInformationLineVOEx1.
     * @return MnjCourierInformationLineVOEx1
     */
    public ViewObjectImpl getMnjCourierInformationLineVOEx1() {
        return (ViewObjectImpl)findViewObject("MnjCourierInformationLineVOEx1");
    }

    /**
     * Container's getter for CourierHeaderVOVsCourierLineVOExtViewLink1.
     * @return CourierHeaderVOVsCourierLineVOExtViewLink1
     */
    public ViewLinkImpl getCourierHeaderVOVsCourierLineVOExtViewLink1() {
        return (ViewLinkImpl)findViewLink("CourierHeaderVOVsCourierLineVOExtViewLink1");
    }

    /**
     * Container's getter for CourierLineImportVO1.
     * @return CourierLineImportVO1
     */
    public ViewObjectImpl getCourierLineImportVO1() {
        return (ViewObjectImpl)findViewObject("CourierLineImportVO1");
    }

    /**
     * Container's getter for CourierLineExportVO1.
     * @return CourierLineExportVO1
     */
    public ViewObjectImpl getCourierLineExportVO1() {
        return (ViewObjectImpl)findViewObject("CourierLineExportVO1");
    }

    /**
     * Container's getter for UserNameLOV1.
     * @return UserNameLOV1
     */
    public ViewObjectImpl getUserNameLOV1() {
        return (ViewObjectImpl)findViewObject("UserNameLOV1");
    }

    /**
     * Container's getter for AllUserNameLOV1.
     * @return AllUserNameLOV1
     */
    public ViewObjectImpl getAllUserNameLOV1() {
        return (ViewObjectImpl)findViewObject("AllUserNameLOV1");
    }

    /**
     * Container's getter for popUp1.
     * @return popUp1
     */
    public CustomViewImpl getpopUp1() {
        return (CustomViewImpl)findViewObject("popUp1");
    }
}