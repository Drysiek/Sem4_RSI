
package org.example.jaxws.server_topdown;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for genre.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="genre"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Horror"/&gt;
 *     &lt;enumeration value="Fantasy"/&gt;
 *     &lt;enumeration value="Romance"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "genre")
@XmlEnum
public enum Genre {

    @XmlEnumValue("Horror")
    HORROR("Horror"),
    @XmlEnumValue("Fantasy")
    FANTASY("Fantasy"),
    @XmlEnumValue("Romance")
    ROMANCE("Romance");
    private final String value;

    Genre(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Genre fromValue(String v) {
        for (Genre c: Genre.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
