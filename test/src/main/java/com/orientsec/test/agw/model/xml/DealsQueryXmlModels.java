package com.orientsec.test.agw.model.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "dealsQueryModels")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealsQueryXmlModels {
    @XmlElement(name = "dealsQueryModel")
    private List<DealsQueryXmlModel> dealsQueryXmlModel;

    public List<DealsQueryXmlModel> getDealsQueryXmlModel() {
        return dealsQueryXmlModel;
    }

    public void setDealsQueryXmlModel(List<DealsQueryXmlModel> dealsQueryXmlModel) {
        this.dealsQueryXmlModel = dealsQueryXmlModel;
    }
}
