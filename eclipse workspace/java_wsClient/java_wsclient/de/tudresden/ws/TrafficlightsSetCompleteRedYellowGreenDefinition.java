
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trafficlights_setCompleteRedYellowGreenDefinition complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Trafficlights_setCompleteRedYellowGreenDefinition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tlsID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tls" type="{http://ws.tudresden.de/}sumoTLSProgram" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trafficlights_setCompleteRedYellowGreenDefinition", propOrder = {
    "tlsID",
    "tls"
})
public class TrafficlightsSetCompleteRedYellowGreenDefinition {

    protected String tlsID;
    protected SumoTLSProgram tls;

    /**
     * ���o tlsID �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTlsID() {
        return tlsID;
    }

    /**
     * �]�w tlsID �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTlsID(String value) {
        this.tlsID = value;
    }

    /**
     * ���o tls �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoTLSProgram }
     *     
     */
    public SumoTLSProgram getTls() {
        return tls;
    }

    /**
     * �]�w tls �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoTLSProgram }
     *     
     */
    public void setTls(SumoTLSProgram value) {
        this.tls = value;
    }

}
