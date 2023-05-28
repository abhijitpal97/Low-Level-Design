Functionality

parkingStructure (parking Id , parkingFloor , status)
addParkingSpace
removeParkingSpace


entryVehicle (entryId , vehicle type , vehicleNumber , entry time , alloted parking , exitTime(null), status(Y))
exitVehicle  (entryId , vehicle type , vehicleNumber , entry time , alloted parking , exitTime(update), status(N))

paymentAmount (entryId , payment mode , payment amount)
availableParking (parkingId , parkingFloor)