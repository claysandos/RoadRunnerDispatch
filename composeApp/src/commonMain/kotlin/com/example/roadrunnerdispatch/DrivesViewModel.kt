package com.example.roadrunnerdispatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Machine(val vin: String, val year: String, val make: String, val model: String, val color: String, val action: String)
data class Drive(val action: String, val type: String, val destination: String, val customerName: String?, val customerPhone: String?, val urgent: Boolean, val date: Long, val machine: Machine)

class DrivesViewModel(): ViewModel() {
    // MODEL - Stores actual drive list data (mutable)
    private val actualDriveList: MutableStateFlow<List<Drive>> = MutableStateFlow(listOf())

    // VM - Stores read-only drive list data that view can see (immutable)
    val observableDriveList = actualDriveList as StateFlow<List<Drive>>

    /**
     * Function to add a drive to the list
     *
     * @param action - action of the drive (e.g. Pickup, Dropoff, Trade)
     * @param type - type of drive (e.g. Dealer, Customer)
     * @param destination - destination of the drive (e.g. Dealership, Address)
     * @param customerName - name of the customer if applicable
     * @param customerPhone - phone number of the customer if applicable
     * @param urgent - urgency of the drive
     * @param date - due date of the drive
     * @param machine - machine associated with the drive
     */
    fun addDrive(action: String, type: String, destination: String, customerName: String?, customerPhone: String?, urgent: Boolean, date: Long, machine: Machine){
        viewModelScope.launch {
           val newDrive = Drive(action, type, destination, customerName!!, customerPhone!!, urgent, date, machine)
           actualDriveList.update { list -> list + newDrive }
        }
    }

    /**
     * Function to remove a drive from the list
     *
     * @param drive - drive to delete
     */
    fun removeDrive(drive: Drive){
        viewModelScope.launch {
            actualDriveList.update{ list -> list.filter { it.action != drive.action && it.type != drive.type && it.date != drive.date && it.destination != drive.destination }}
        }
    }
}