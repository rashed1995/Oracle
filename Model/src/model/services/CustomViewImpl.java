package model.services;

import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.server.ViewObjectImpl;

public class CustomViewImpl extends ViewObjectImpl {
    public String getCriteriaItemClause(ViewCriteriaItem viewCriteriaItem){
            if (viewCriteriaItem.getAttributeDef().getJavaType().getName().equals("java.lang.String")){
                viewCriteriaItem.setValue("%" + viewCriteriaItem.getValue() + "%");
            }
            viewCriteriaItem.setUpperColumns(true);
            return super.getCriteriaItemClause(viewCriteriaItem);
        }
}
