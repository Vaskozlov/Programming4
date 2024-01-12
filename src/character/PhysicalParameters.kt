package character

import lib.InvalidPhysicalParameterException

class PhysicalParameters(height: Double, weight: Double, power: Double) {
    var height: Double = height

    var weight: Double = weight
        set(value: Double) {
            if (value < 0.0) {
                throw InvalidPhysicalParameterException("Height can not be negative");
            }

            field = value
        }

    var power: Double = power
        set(value) {
            if (value < 0.0) {
                throw InvalidPhysicalParameterException("Weight can not be negative");
            }

            field = value
        }
}