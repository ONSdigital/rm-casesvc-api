package uk.gov.ons.ctp.response.caseframe.representation;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CaseDTO {

  private Integer caseId;

  private Integer uprn;

  private String caseStatus;

  private Integer caseTypeId;

  private Date createdDatetime;

  private String createdBy;

  private Integer sampleId;

  private Integer actionPlanId;

  private Integer surveyId;

  private String questionSet;

}