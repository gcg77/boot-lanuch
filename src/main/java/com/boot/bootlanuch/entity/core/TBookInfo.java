package com.boot.bootlanuch.entity.core;

import java.io.Serializable;
import java.util.Date;

/**
 * t_book_info
 * @author 
 */
public class TBookInfo implements Serializable {
    private Integer id;

    private String bookname;

    private String auto;

    private Date updatedate;

    private Date insertdate;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TBookInfo other = (TBookInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBookname() == null ? other.getBookname() == null : this.getBookname().equals(other.getBookname()))
            && (this.getAuto() == null ? other.getAuto() == null : this.getAuto().equals(other.getAuto()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getInsertdate() == null ? other.getInsertdate() == null : this.getInsertdate().equals(other.getInsertdate()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBookname() == null) ? 0 : getBookname().hashCode());
        result = prime * result + ((getAuto() == null) ? 0 : getAuto().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getInsertdate() == null) ? 0 : getInsertdate().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookname=").append(bookname);
        sb.append(", auto=").append(auto);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", insertdate=").append(insertdate);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}