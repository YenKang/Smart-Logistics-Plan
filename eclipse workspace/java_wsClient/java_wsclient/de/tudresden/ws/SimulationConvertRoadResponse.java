
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_convertRoadResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_convertRoadResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.tudresden.de/}sumoPosition2D" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_convertRoadResponse", propOrder = {
    "_return"
})
public class SimulationConvertRoadResponse {

    @XmlElement(name = "return")
    protected SumoPosition2D _return;

    /**
     * ���o return �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoPosition2D }
     *     
     */
    public SumoPosition2D getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoPosition2D }
     *     
     */
    public void setReturn(SumoPosition2D value) {
        this._return = value;
    }

}
