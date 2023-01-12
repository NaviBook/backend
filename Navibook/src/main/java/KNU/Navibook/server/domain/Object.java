package KNU.Navibook.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Object{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long object_id;
    private String type;
    private long position_x;
    private long position_y;
    private long width;
    private long height;
    private String library_floor;

    public long getObject_id() {
        return object_id;
    }

    public void setObject_id(long object_id) {
        this.object_id = object_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPosition_x() {
        return position_x;
    }

    public void setPosition_x(long position_x) {
        this.position_x = position_x;
    }

    public long getPosition_y() {
        return position_y;
    }

    public void setPosition_y(long position_y) {
        this.position_y = position_y;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getLibrary_floor() {
        return library_floor;
    }

    public void setLibrary_floor(String library_floor) {
        this.library_floor = library_floor;
    }
}