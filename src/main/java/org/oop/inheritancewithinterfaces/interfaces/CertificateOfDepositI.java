package org.oop.inheritancewithinterfaces.interfaces;

import java.time.LocalDate;

public interface CertificateOfDepositI {

    LocalDate getMaturityDate();

    void withdrawMaturedAmount();

    void withdrawPreMaturedAmount();

}

