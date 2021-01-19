package com.example.covidinfo.model

import com.google.gson.annotations.SerializedName

class StateData (
    @SerializedName("Message")
    val message: String,
    @SerializedName("Global")
    val global: Global,
    @SerializedName("Countries")
    val countries:ArrayList<StateInfo>
)

class StateInfo(
    @SerializedName("Country")
    val country: String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("Slug")
    val slug: String,
    @SerializedName("NewConfirmed")
    val newConfirmed: Int,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int,
    @SerializedName("NewDeaths")
    val newDeath: Int,
    @SerializedName("TotalDeaths")
    val totalDeath: Int,
    @SerializedName("NewRecovered")
    val newRecovered: Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int,
    @SerializedName("Date")
    val date:String,
    @SerializedName("Premium")
    val premium: Premium)


class Premium

class Global(
    @SerializedName("NewConfirmed")
    val newCon: Int,
    @SerializedName("TotalConfirmed")
    val totalCon:Int,
    @SerializedName("NewDeaths")
    val newDeaths: Int,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int,
    @SerializedName("NewRecovered")
    val newRecovered: Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int
)