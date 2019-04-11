
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Polygon_add complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o polygonID �S�ʪ���.
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
     * �]�w polygonID �S�ʪ���.
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
     * ���o shape �S�ʪ���.
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
     * �]�w shape �S�ʪ���.
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
     * ���o color �S�ʪ���.
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
     * �]�w color �S�ʪ���.
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
     * ���o fill �S�ʪ���.
     * 
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * �]�w fill �S�ʪ���.
     * 
     */
    public void setFill(boolean value) {
        this.fill = value;
    }

    /**
     * ���o polygonType �S�ʪ���.
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
     * �]�w polygonType �S�ʪ���.
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
     * ���o layer �S�ʪ���.
     * 
     */
    public int getLayer() {
        return layer;
    }

    /**
     * �]�w layer �S�ʪ���.
     * 
     */
    public void setLayer(int value) {
        this.layer = value;
    }

}
