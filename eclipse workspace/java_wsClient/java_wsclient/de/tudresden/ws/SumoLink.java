
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoLink complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 from 特性的值.
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
     * 設定 from 特性的值.
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
     * 取得 to 特性的值.
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
     * 設定 to 特性的值.
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
     * 取得 over 特性的值.
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
     * 設定 over 特性的值.
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
     * 取得 notInternalLane 特性的值.
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
     * 設定 notInternalLane 特性的值.
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
     * 取得 internalLane 特性的值.
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
     * 設定 internalLane 特性的值.
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
     * 取得 state 特性的值.
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
     * 設定 state 特性的值.
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
     * 取得 direction 特性的值.
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
     * 設定 direction 特性的值.
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
     * 取得 hasPriority 特性的值.
     * 
     */
    public byte getHasPriority() {
        return hasPriority;
    }

    /**
     * 設定 hasPriority 特性的值.
     * 
     */
    public void setHasPriority(byte value) {
        this.hasPriority = value;
    }

    /**
     * 取得 isOpen 特性的值.
     * 
     */
    public byte getIsOpen() {
        return isOpen;
    }

    /**
     * 設定 isOpen 特性的值.
     * 
     */
    public void setIsOpen(byte value) {
        this.isOpen = value;
    }

    /**
     * 取得 hasApproachingFoe 特性的值.
     * 
     */
    public byte getHasApproachingFoe() {
        return hasApproachingFoe;
    }

    /**
     * 設定 hasApproachingFoe 特性的值.
     * 
     */
    public void setHasApproachingFoe(byte value) {
        this.hasApproachingFoe = value;
    }

    /**
     * 取得 length 特性的值.
     * 
     */
    public double getLength() {
        return length;
    }

    /**
     * 設定 length 特性的值.
     * 
     */
    public void setLength(double value) {
        this.length = value;
    }

}
