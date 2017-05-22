package uk.gov.ons.ctp.response.casesvc.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import uk.gov.ons.ctp.common.endpoint.CTPEndpoint;
import uk.gov.ons.ctp.common.error.CTPException;
import uk.gov.ons.ctp.response.casesvc.domain.model.CaseGroup;
import uk.gov.ons.ctp.response.casesvc.representation.CaseGroupDTO;
import uk.gov.ons.ctp.response.casesvc.service.CaseGroupService;

/**
 * The REST endpoint controller for CaseSvc CaseGroups
 */
@RestController
@RequestMapping(value = "/casegroups", produces = "application/json")
@Slf4j
public final class CaseGroupEndpoint implements CTPEndpoint {

  public static final String ERRORMSG_CASEGROUPNOTFOUND = "CaseGroup not found for";

  @Autowired
  private CaseGroupService caseGroupService;

  @Qualifier("caseSvcBeanMapper")
  @Autowired
  private MapperFacade mapperFacade;

 /**
   * the GET endpoint to find CaseGroups by caseGroupID
   *
   * @param id UUID to find by
   * @return the casegroups found
   * @throws CTPException something went wrong
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public CaseGroupDTO findCaseGroupById(@PathVariable("id") final String id)  throws CTPException {
    log.info("Entering findCaseGroupById with {}", id);

    CaseGroup caseGroupObj = caseGroupService.findCaseGroupById(id);
    if (caseGroupObj == null) {
        throw new CTPException(CTPException.Fault.RESOURCE_NOT_FOUND, String.format("%s casegroup id %s",
                ERRORMSG_CASEGROUPNOTFOUND, id));
    }

    return mapperFacade.map(caseGroupObj, CaseGroupDTO.class);
  }

}
