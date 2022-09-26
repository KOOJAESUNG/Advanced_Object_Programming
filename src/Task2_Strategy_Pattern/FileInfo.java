package Task2_Strategy_Pattern;

import java.util.Date;

public class FileInfo {
    private String name;
    private String type;
    private int size;
    private Date modifiedDate;

    public FileInfo(String name, String type, int size, Date modified) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.modifiedDate = modified;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String toString() { //파일 정보 반환
        return "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Size: " + size + "\n" +
                "ModifiedDate: " + modifiedDate;
    }


}
