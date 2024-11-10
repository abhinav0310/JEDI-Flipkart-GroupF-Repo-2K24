package com.flipfit.dao.interfaces;

import com.flipfit.bean.FlipFitPayments;

public interface IFlipFitPaymentsDAO {
    public FlipFitPayments setPaymentInfo(FlipFitPayments FFP);
    public void deletePaymentInfo(FlipFitPayments FFP);
}
