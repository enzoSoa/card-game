package com.esgi

class HeroDamagingService {
    fun execute(attacker: Hero, defender: Hero): Double {
        var bonus = 0

        when(attacker.speciality) {
            Speciality.TANK -> if (defender.speciality == Speciality.MAGE) bonus = 20
            Speciality.ASSASSIN -> if (defender.speciality == Speciality.TANK) bonus = 30
            Speciality.MAGE -> if (defender.speciality == Speciality.ASSASSIN) bonus = 25
        }

        return attacker.power + bonus - defender.armor
    }
}