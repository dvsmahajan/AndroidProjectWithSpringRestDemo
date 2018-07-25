package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Serializable {

    @JsonProperty("resourceId")
    private int resourceId;
    @JsonProperty("empName")
    private String empName;
    @JsonProperty("empDesignation")
    private String empDesignation;
    @JsonProperty("empNumber")
    private String empNumber;
    @JsonProperty("projId")
    private int projId;
    @JsonProperty("empEmail")
    private String empEmail;
    @JsonProperty("empPassword")
    private String empPassword;
    @JsonProperty("managerEmail")
    private String managerEmail;

    public int getResourceId() {
        return this.resourceId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public String getEmpDesignation() {
        return this.empDesignation;
    }

    public String getEmpNumber() {
        return this.empNumber;
    }

    public int getProjId() {
        return this.projId;
    }

    public String getEmpEmail() {
        return this.empEmail;
    }

    public String getEmpPassword() {
        return this.empPassword;
    }

    public String getManagerEmail() {
        return this.managerEmail;
    }
}
