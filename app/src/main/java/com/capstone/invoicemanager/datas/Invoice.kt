package com.capstone.invoicemanager.datas

import java.util.Date


data class Invoice (
    var invoiceId : Int,
    var userId :Int,
    var clientName: String,
    var amount :Int,
    var date: Date,
    var description: String,
)

