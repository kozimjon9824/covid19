
package com.example.covidinfo.util
/*

class DataMapper() :Mapper<StateData,RoomData>{
    override fun map(input: StateData): RoomData {
        return RoomData(
            input.message,
            GlobalDataMapper().map(input.global),
            StateInfoMapper().mapList(input.countries) as ArrayList<StateInfoRoomVersion>
        )
    }

}

class StateInfoMapper:Mapper<StateInfo,StateInfoRoomVersion>{
    override fun map(input: StateInfo): StateInfoRoomVersion {
        return StateInfoRoomVersion(
            input.country,
            input.countryCode,
            input.slug,
            input.newConfirmed,
            input.totalConfirmed,
            input.newDeath,
            input.totalDeath,
            input.newRecovered,
            input.totalRecovered,
            input.date
        )
    }
    fun mapList(input: List<StateInfo>):List<StateInfoRoomVersion>{
        return input.map { map(it) }
    }

}



class GlobalDataMapper:Mapper<Global,GlobalRoomVersion>{
    override fun map(input: Global): GlobalRoomVersion {
        return GlobalRoomVersion(
            input.newCon,
            input.totalCon,
            input.newDeaths,
            input.totalDeaths,
            input.newRecovered,
            input.totalRecovered
              )
    }
}*/
