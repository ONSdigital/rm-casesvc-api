package uk.gov.ons.ctp.response.casesvc.representation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class SampleDTO {

  private Integer sampleId;

  private String name;

  private String description;

  private String addressCriteria;

  private String survey;

  private SampleCaseTypeDTO[] sampleCaseTypes;

}
