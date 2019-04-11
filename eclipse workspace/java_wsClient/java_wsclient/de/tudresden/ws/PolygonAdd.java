
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Polygon_add complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Polygon_add">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="polygonID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shape" type="{http://ws.tudresden.de/}sumoGeometry" minOccurs="0"/>
 *         &lt;element name="color" type="{http://ws.tudresden.de/}sumoColor" minOccurs="0"/>
 *         &lt;element name="fill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="polygonType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="layer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Polygon_add", propOrder = {
    "polygonID",
    "shape",
    "color",
    "fill",
    "polygonType",
    "layer"
})
public class PolygonAdd {

    protected String polygonID;
    protected SumoGeometry shape;
    protected SumoColor color;
    protected boolean fill;
    protected String polygonType;
    protected int layer;

    /**
     * 取得 polygonID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygonID() {
        return polygonID;
    }

    /**
     * 設定 polygonID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygonID(String value) {
        this.polygonID = value;
    }

    /**
     * 取得 shape 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link SumoGeometry }
     *     
     */
    public SumoGeometry getShape() {
        return shape;
    }

    /**
     * 設定 shape 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoGeometry }
     *     
     */
    public void setShape(SumoGeometry value) {
        this.shape = value;
    }

    /**
     * 取得 color 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link SumoColor }
     *     
     */
    public SumoColor getColor() {
        return color;
    }

    /**
     * 設定 color 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoColor }
     *     
     */
    public void setColor(SumoColor value) {
        this.color = value;
    }

    /**
     * 取得 fill 特性的值.
     * 
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * 設定 fill 特性的值.
     * 
     */
    public void setFill(boolean value) {
        this.fill = value;
    }

    /**
     * 取得 polygonType 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygonType() {
        return polygonType;
    }

    /**
     * 設定 polygonType 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygonType(String value) {
        this.polygonType = value;
    }

    /**
     * 取得 layer 特性的值.
     * 
     */
    public int getLayer() {
        return layer;
    }

    /**
     * 設定 layer 特性的值.
     * 
     */
    public void setLayer(int value) {
        this.layer = value;
    }

}
