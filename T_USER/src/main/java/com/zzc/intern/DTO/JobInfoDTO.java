package com.zzc.intern.DTO;




import java.io.Serializable;

import lombok.Data;
@Data
public class JobInfoDTO implements  Serializable {
   
    private Integer jId;
    
    private String tName;
    
    private Integer tId;
    
    private Integer lId;
    
    private String lelementary;
    
    private String lStage;
    
    private Integer aGrade;
    
    private String jName;
    
    private Integer dId;
    
    private String djStage;
}
