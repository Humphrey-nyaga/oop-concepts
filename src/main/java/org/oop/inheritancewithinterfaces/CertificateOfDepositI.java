package org.oop.inheritancewithinterfaces;

import java.time.LocalDate;

public interface CertificateOfDepositI {

    LocalDate getMaturityDate();

    void withdrawMaturedAmount();

    void earlyWithdrawalPenalty();

    void withdrawPreMaturedAmount();

}

