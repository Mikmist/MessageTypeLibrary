package net.zhspace;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Author: Zino Holwerda
 * Date: 11/18/2017.
 */
@Entity
public class Version implements Comparable<Version>, Serializable {
    
    private static final long serialVersionUID = 2312L;

    @Id
    private long id;

    /** The version with which this object was made */
    private String version;

    /** List of strings containing file names that need to be updated in this version*/
    private List<File> files;

    public String get() {
        return this.version;
    }

    public Version() {}
    public Version(String version) {
        if(version == null)
            throw new IllegalArgumentException("Version can not be null");
        if(!version.matches("[0-9]+(\\.[0-9]+)*"))
            throw new IllegalArgumentException("Invalid version format");
        this.version = version;
    }

    @Override
    public int compareTo(Version that) {
        if(that == null)
            return 1;
        String[] thisParts = this.get().split("\\.");
        String[] thatParts = that.get().split("\\.");
        int length = Math.max(thisParts.length, thatParts.length);
        for(int i = 0; i < length; i++) {
            int thisPart = i < thisParts.length ?
                    Integer.parseInt(thisParts[i]) : 0;
            int thatPart = i < thatParts.length ?
                    Integer.parseInt(thatParts[i]) : 0;
            if(thisPart < thatPart)
                return -1;
            if(thisPart > thatPart)
                return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object that) {
        if(this == that)
            return true;
        if(that == null)
            return false;
        if(this.getClass() != that.getClass())
            return false;
        return this.compareTo((Version) that) == 0;
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFileToVersionList(File filename) {
        this.files.add(filename);
    }

    public void removeFileFromVersionList(String filename) {
        this.files.remove(filename);
    }

    public long getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

}