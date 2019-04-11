
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoLink complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="sumoLink">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="over" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notInternalLane" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalLane" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasPriority" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="isOpen" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="hasApproachingFoe" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoLink", propOrder = {
    "from",
    "to",
    "over",
    "notInternalLane",
    "internalLane",
    "state",
    "direction",
    "hasPriority",
    "isOpen",
    "hasApproachingFoe",
    "length"
})
public class SumoLink {

    protected String from;
    protected String to;
    protected String over;
    protected String notInternalLane;
    protected String internalLane;
    protected String state;
    protected String direction;
    protected byte hasPriority;
    protected byte isOpen;
    protected byte hasApproachingFoe;
    protected double length;

    /**
     * ���o from �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * �]�w from �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * ���o to �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * �]�w to �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * ���o over �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOver() {
        return over;
    }

    /**
     * �]�w over �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOver(String value) {
        this.over = value;
    }

    /**
     * ���o notInternalLane �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotInternalLane() {
        return notInternalLane;
    }

    /**
     * �]�w notInternalLane �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotInternalLane(String value) {
        this.notInternalLane = value;
    }

    /**
     * ���o internalLane �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalLane() {
        return internalLane;
    }

    /**
     * �]�w internalLane �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalLane(String value) {
        this.internalLane = value;
    }

    /**
     * ���o state �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * �]�w state �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * ���o direction �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * �]�w direction �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * ���o hasPriority �S�ʪ���.
     * 
     */
    public byte getHasPriority() {
        return hasPriority;
    }

    /**
     * �]�w hasPriority �S�ʪ���.
     * 
     */
    public void setHasPriority(byte value) {
        this.hasPriority = value;
    }

    /**
     * ���o isOpen �S�ʪ���.
     * 
     */
    public byte getIsOpen() {
        return isOpen;
    }

    /**
     * �]�w isOpen �S�ʪ���.
     * 
     */
    public void setIsOpen(byte value) {
        this.isOpen = value;
    }

    /**
     * ���o hasApproachingFoe �S�ʪ���.
     * 
     */
    public byte getHasApproachingFoe() {
        return hasApproachingFoe;
    }

    /**
     * �]�w hasApproachingFoe �S�ʪ���.
     * 
     */
    public void setHasApproachingFoe(byte value) {
        this.hasApproachingFoe = value;
    }

    /**
     * ���o length �S�ʪ���.
     * 
     */
    public double getLength() {
        return length;
    }

    /**
     * �]�w length �S�ʪ���.
     * 
     */
    public void setLength(double value) {
        this.length = value;
    }

}
