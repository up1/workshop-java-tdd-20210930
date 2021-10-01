package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Exception with First name is required")
    public void case01() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, new Speaker());
        });
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception with Last name is required")
    public void case02() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("somkiat");
            business.register(null, speaker);
        });
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception with Last name is required")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("somkiat");
            speaker.setLastName("pui");
            business.register(null, speaker);
        });
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception with invalid domain")
    public void case04() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("somkiat");
            speaker.setLastName("pui");
            speaker.setEmail("xxx");
            business.register(null, speaker);
        });
    }

    @Test
    @DisplayName("Exception with Speaker doesn't meet our standard rules")
    public void case05() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("somkiat");
            speaker.setLastName("pui");
            speaker.setEmail("somkiat@1.com");
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception with can not save")
    public void case06() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("somkiat");
            speaker.setLastName("pui");
            speaker.setEmail("somkiat@gmail.com");
            business.register(new SpeakerRepository() {
                @Override
                public Integer saveSpeaker(Speaker speaker) {
                    throw new RuntimeException("Can not save.");
                }
            }, speaker);
        });
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception with can not save")
    public void case07() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("somkiat");
        speaker.setLastName("pui");
        speaker.setEmail("somkiat@gmail.com");
        int id = business.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, speaker);

        assertEquals(100, id);
    }



}