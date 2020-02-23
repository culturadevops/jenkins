package com.inretailpharma.digital.ordermanager.entity;

import com.inretailpharma.digital.ordermanager.util.Constant;
import io.swagger.annotations.ApiModel;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@ApiModel(value = "Informacion de Parametros", description = "Parametros")
@Entity
@SuppressWarnings("all")
@Table(name = "application_parameter")
public class ApplicationParameter implements Serializable {

    @Transient
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Id
    @Enumerated(EnumType.STRING)
    private Code code;
    private String description;
    private String value;
    @Version
    private Integer version;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIntValue() {
        return Integer.valueOf(value);
    }

    public Long getLongValue() {
        return Long.valueOf(value);
    }

    public Date getDateValue() {
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public Constant.Logical getLogicalValue() {
        return Constant.Logical.valueOf(value);
    }

    public Collection<String> getStringCollectionValue() {
        return Arrays.asList(StringUtils.tokenizeToStringArray(value, ","));
    }

    public Collection<Integer> getIntegerCollectionValue() {
        return Arrays.stream(StringUtils.tokenizeToStringArray(value, ",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public Collection<Long> getLongCollectionValue() {
        return Arrays.stream(StringUtils.tokenizeToStringArray(value, ",")).map(Long::parseLong).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "{\"ApplicationParameter\":{"
                + "\"code\":\"" + code + "\""
                + ", \"description\":\"" + description + "\""
                + ", \"value\":\"" + value + "\""
                + ", \"version\":\"" + version + "\""
                + "}}";
    }

    public enum Code {
        ORDER_EXECUTE_FETCH;
    }
}
