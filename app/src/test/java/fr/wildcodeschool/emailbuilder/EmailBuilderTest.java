package fr.wildcodeschool.emailbuilder;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class EmailBuilderTest {

  // --------------------------------------------------------------------------
  // TEST : EmailBuilder.Builder class
  // --------------------------------------------------------------------------

  @Test
  public void emailBuilder_GetEmailSimple_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setTld("com")
      .build();
    assertEquals("name@email.com", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailWithSubDomain_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("name@email.co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoUsername_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setDomain("email")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("@email.co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoDomain_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setSubDomain("co")
      .setTld("uk")
      .build();
    assertEquals("name@co.uk", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailNoTld_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("name")
      .setDomain("email")
      .setSubDomain("co")
      .build();
    assertEquals("name@email.co", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetEmailEmptyString_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder
      .Builder()
      .setUserName("")
      .setDomain("")
      .setSubDomain("")
      .setTld("")
      .build();
    assertEquals("", emailBuilder.getEmail());
  }

  @Test
  public void emailBuilder_GetNullEmail_ReturnsTrue() {
    EmailBuilder emailBuilder = new EmailBuilder.Builder().build();
    assertEquals("", emailBuilder.getEmail());
  }

  // --------------------------------------------------------------------------
  // TEST : isValidEmail method
  // --------------------------------------------------------------------------

  @Test
  public void emailBuilder_isValidEmailSimple_ReturnsTrue() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setTld("uk")
            .build();
    assertTrue(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailWithSubDomain_ReturnsTrue() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setSubDomain("co")
            .setTld("uk")
            .build();
    assertTrue(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoUsername_ReturnsFalse() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setDomain("email")
            .setSubDomain("co")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoDomain_ReturnsFalse() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNoTld_ReturnsFalse() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailEmptyString_ReturnsFalse() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("")
            .setDomain("")
            .setSubDomain("")
            .setTld("")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidNullEmail_ReturnsFalse() {
    // Code here
    EmailBuilder emailBuilder = new EmailBuilder.Builder().build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }


  @Test
  public void emailBuilder_isValidWrongEmailName_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
            .setDomain("email")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailNameTooLong_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName(String.join("", Collections.nCopies(257, "a")))
            .setDomain("email")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidWrongEmailDomain_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("*$£%ù^¨")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailDomainTooLong_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain(String.join("", Collections.nCopies(66, "a")))
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidWrongEmailSubDomain_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“")
            .setDomain("email")
            .setSubDomain("*$£%ù^¨&é")
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailSubDomainTooLong_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setSubDomain(String.join("", Collections.nCopies(27, "a")))
            .setTld("uk")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidWrongEmailTld_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setTld("*$£%")
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }

  @Test
  public void emailBuilder_isValidEmailTldTooLong_ReturnsFalse(){
    EmailBuilder emailBuilder = new EmailBuilder
            .Builder()
            .setUserName("name")
            .setDomain("email")
            .setTld(String.join("", Collections.nCopies(27, "a")))
            .build();
    assertFalse(EmailBuilder.isValidEmail(emailBuilder.getEmail()));
  }


  // Add test here
  // * Check name validity (*$£%ù^¨&é"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢“)
  // * Check name length
  // * Check domain validity
  // * Check domain length
  // * Check sub domain validity
  // * Check sub domain length
  // * Check tld validity
  // * Check tld length
}