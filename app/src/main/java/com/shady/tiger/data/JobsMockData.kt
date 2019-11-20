package com.shady.tiger.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "jobs_table")
@Parcelize
data class JobsMockData(
    @PrimaryKey @ColumnInfo(name = "id") var order_time: String,
    var __status: String,
    var customer_name: String,
    var distance: String?,
    var job_date : String?,
    var extras: String?,
    var order_duration: String?,
    var order_id: String,
    var payment_method: String,
    var price: String,
    var recurrency: Int?,
    var job_city: String,
    var job_latitude: String,
    var job_longitude: String,
    var job_postalcode: Int?,
    var job_street: String?,
    var status: String
) : Parcelable