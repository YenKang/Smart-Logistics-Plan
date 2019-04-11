
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoColor complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="sumoColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="g" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoColor", propOrder = {
    "r",
    "g",
    "b",
    "a"
})
public class SumoColor {

    protected byte r;
    protected byte g;
    protected byte b;
    protected byte a;

    /**
     * 取得 r 特性的值.
     * 
     */
    public byte getR() {
        return r;
    }

    /**
     * 設定 r 特性的值.
     * 
     */
    public void setR(byte value) {
        this.r = value;
    }

    /**
     * 取得 g 特性的值.
     * 
     */
    public byte getG() {
        return g;
    }

    /**
     * 設定 g 特性的值.
     * 
     */
    public void setG(byte value) {
        this.g = value;
    }

    /**
     * 取得 b 特性的值.
     * 
     */
    public byte getB() {
        return b;
    }

    /**
     * 設定 b 特性的值.
     * 
     */
    public void setB(byte value) {
        this.b = value;
    }

    /**
     * 取得 a 特性的值.
     * 
     */
    public byte getA() {
        return a;
    }

    /**
     * 設定 a 特性的值.
     * 
     */
    public void setA(byte value) {
        this.a = value;
    }

}
