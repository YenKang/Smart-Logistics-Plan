
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trafficlights_setCompleteRedYellowGreenDefinition complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 tlsID 特性的值.
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
     * 設定 tlsID 特性的值.
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
     * 取得 tls 特性的值.
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
     * 設定 tls 特性的值.
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
