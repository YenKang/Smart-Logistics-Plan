
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_getLoadedNumberResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_getLoadedNumberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_getLoadedNumberResponse", propOrder = {
    "_return"
})
public class SimulationGetLoadedNumberResponse {

    @XmlElement(name = "return")
    protected int _return;

    /**
     * ���o return �S�ʪ���.
     * 
     */
    public int getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     */
    public void setReturn(int value) {
        this._return = value;
    }

}
