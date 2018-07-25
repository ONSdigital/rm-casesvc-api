package uk.gov.ons.ctp.response.casesvc.message.sampleunitnotification;

import static org.junit.Assert.assertNotNull;

import javax.xml.bind.JAXBContext;
import org.junit.Test;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.ResourceLoader;
import uk.gov.ons.ctp.common.utility.Mapzer;

public class SampleUnitParentTest {

  @Test
  public void testPartyIdIsOptional() throws Exception {
    // Given
    SampleUnitParent sampleUnitParent =
        SampleUnitParent.builder()
            .withCollectionExerciseId("collectionExerciseId")
            .withSampleUnitType("sampleUnitType")
            .withCollectionInstrumentId("collectionInstrument")
            .withActionPlanId("actionPlanId")
            .withSampleUnitRef("sampleUnitRef")
            .build();

    // When
    String xml = validateBySerialisation(sampleUnitParent);

    // Then
    assertNotNull(xml);
  }

  private String validateBySerialisation(SampleUnitParent sampleUnitParent) throws Exception {
    JAXBContext jaxbContext = JAXBContext.newInstance(SampleUnitParent.class);
    ResourceLoader resourceLoader = new ClassRelativeResourceLoader(SampleUnitParentTest.class);
    Mapzer mapzer = new Mapzer(resourceLoader);
    return mapzer.convertObjectToXml(
        jaxbContext, sampleUnitParent, "casesvc/xsd/inbound/SampleUnitNotification.xsd");
  }
}
