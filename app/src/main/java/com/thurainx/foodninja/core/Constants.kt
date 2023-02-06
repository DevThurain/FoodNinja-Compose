package com.thurainx.foodninja.core

import com.thurainx.foodninja.R
import com.thurainx.foodninja.data.vo.PaymentVO

object Constants {
    val DEFAULT_PAYMENT_LIST: List<PaymentVO> = listOf(
        PaymentVO(name = "Paypal", photo = R.drawable.payment_paypal),
        PaymentVO(name = "Visa", photo = R.drawable.payment_visa),
        PaymentVO(name = "Payoneer", photo = R.drawable.payment_payoneer),
    )
}