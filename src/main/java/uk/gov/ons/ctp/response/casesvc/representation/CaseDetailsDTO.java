package uk.gov.ons.ctp.response.casesvc.representation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Domain model object to represent the full details of a Case (Case, CaseGroup and CaseEvents)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CaseDetailsDTO {

    private CaseState state;

    private UUID id;
    private UUID actionPlanId;
    private UUID collectionInstrumentId;
    private UUID partyId;

    private String iac;
    private String caseRef;
    private String createdBy;
    private String sampleUnitType;

    private Date createdDateTime;

    private CaseGroupDTO caseGroup;

    private List<ResponseDTO> responses;

    private List<CaseEventDTO> caseEvents;

}
